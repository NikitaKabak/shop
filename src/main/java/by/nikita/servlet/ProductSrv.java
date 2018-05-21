package by.nikita.servlet;

import by.nikita.dao.DaoCatalogImp;
import by.nikita.Entity.Product;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProductSrv {
    Map<Integer, Integer> backet = new HashMap<>();
    Map<String, Integer> backetList = new HashMap<>();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoCatalogImp productID = null;
        try {
            productID = new DaoCatalogImp();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productID.read(id);
        /*System.out.println(product);*/
        request.setAttribute("product", product);
        request.getRequestDispatcher("/by/nikita/jsp/product.jsp").forward(request, response);
    }


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
                catalogSrv.doGet(request, response);
                /* request.getRequestDispatcher("/by/nikita/jsp/catalog.jsp").forward(request,response);*/
            default:
                request.getRequestDispatcher("/by/nikita/jsp/notFound.jsp").forward(request, response);
                break;
        }

    }
}
