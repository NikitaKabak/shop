package nikita.nikita.Controllers;

import nikita.nikita.Entity.Productstatus;
import nikita.nikita.dao.DaoCatalogImp;
import nikita.nikita.Entity.Product;
import nikita.nikita.dao.HbmDaoImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Controller
public class ProductSrv {
    Map<Integer, Integer> backet = new HashMap<>();
    Map<String, Integer> backetList = new HashMap<>();
 //   ApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/app-context.xml");

    @RequestMapping(value = "/shop/product", method = RequestMethod.GET)
    public  void getProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = null;
        HbmDaoImp getProductID = new HbmDaoImp();
       // HbmDaoImp getProductID = context.getBean("HbmDaoImp",HbmDaoImp.class);
        product = (Product) getProductID.read(Product.class,id);
        Productstatus productstatus = product.getProductstatus();
        //product.setProductstatus(product.getProductstatus());
        request.setAttribute("product", product);
        request.getRequestDispatcher("/WEB-INF/pages/product.jsp").forward(request, response);
    }

 /*   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoCatalogImp productID = null;
        try {
            productID = new DaoCatalogImp();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productID.read(id);
        *//*System.out.println(product);*//*
        request.setAttribute("product", product);
        request.getRequestDispatcher("/nikita/nikita/jsp/product.jsp").forward(request, response);
    }*/

    @RequestMapping(value = "/shop/product", method = RequestMethod.POST)
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*System.out.println(request.getParameter("nameButton"));*/
        switch (request.getParameter("nameButton")) {
            case "addInBacket":
                Integer idProduct = Integer.parseInt(request.getParameter("idProduct"));
                Integer qantityByProduct = Integer.parseInt(request.getParameter("byqantity"));

                /*backetList.put(idProduct,qantityByProduct);
                System.out.println(backetList);*/

                /*for (Map.Entry entry : backetList.entrySet()) {
                    System.out.println("Key: " + entry.getKey() + " Value: "
                            + entry.getValue());
                }
*/
                HttpSession session = request.getSession();
                Map<Integer, Integer> map = (Map<Integer, Integer>) session.getAttribute("Backet");

                if (map != null) {
                    backet.putAll(map);
                    System.out.println("Map из requesta");
                    System.out.println(backet);
                    for (Map.Entry entry : backet.entrySet()) {
                        System.out.println("Key: " + entry.getKey() + " Value: "
                                + entry.getValue());
                    }
                }

                System.out.println("add id");
                backet.put(idProduct,qantityByProduct);




                /*Product product = productID.read(idProduct);
                String nameProduct = product.getNameproduct();*/


                for (Map.Entry entry : backet.entrySet()){
                   Integer id = (Integer) entry.getKey();
                   Integer qantity = (Integer) entry.getValue();
                    DaoCatalogImp productID = null;
                    try {
                        productID = new DaoCatalogImp();
                    } catch (NamingException e) {
                        e.printStackTrace();
                    }
                    Product product = productID.read(id);
                    String nameProduct = product.getNameproduct();
                    String backetListKey = "id#name: " + id + "#" + nameProduct + " Количество: " + qantity + " Стоимость : " + (product.getPrice() * qantity);
                    backetList.put(backetListKey, qantity);
                }

                /*String backetListKey = "id#name: " + idProduct + "#" + nameProduct + " Количество: " + qantityByProduct + " Стоимость : " + (product.getPrice() * qantityByProduct);
                backetList.put(backetListKey, qantityByProduct);
                */
                System.out.println(backetList);
                for (Map.Entry entry : backetList.entrySet()) {
                    System.out.println("Key: " + entry.getKey() + " Value: "
                            + entry.getValue());
                }

                session.setAttribute("Backet", backet);
                session.setAttribute("BacketList", backetList);
                CatalogSrv catalogSrv = new CatalogSrv();

                // ИСПРАВИТЬ!!!!!!!!

                 catalogSrv.getCatalog(request, response);




                 request.getRequestDispatcher("/by/nikita/jsp/catalog.jsp").forward(request,response);
            default:
                request.getRequestDispatcher("/WEB-INF/pages/notFound.jsp").forward(request, response);
                break;
        }

    }
}
