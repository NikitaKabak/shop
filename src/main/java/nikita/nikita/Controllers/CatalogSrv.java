package nikita.nikita.Controllers;

import nikita.nikita.dao.DaoCatalogImp;
import nikita.nikita.Entity.Product;
import nikita.nikita.dao.HbmDaoImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@Controller
public class CatalogSrv  {
    @RequestMapping(value = "/shop/catalog", method = RequestMethod.GET)
    public  ModelAndView  getCatalog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> catalog = null;
        HbmDaoImp productList = new HbmDaoImp();
        catalog = productList.getAll(Product.class);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("catalog", catalog);
        modelAndView.setViewName("catalog");
       /* request.setAttribute("catalog", catalog);
        request.getRequestDispatcher("/nikita/nikita/jsp/catalog.jsp").forward(request, response);*/
        return modelAndView;
    }

  /*  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoCatalogImp product = null;
        try {
            product = new DaoCatalogImp();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        List<Product> catalog = null;
        try {
            catalog = product.getall();

        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("catalog", catalog);
        request.getRequestDispatcher("/nikita/nikita/jsp/catalog.jsp").forward(request, response);
    }*/


    public void doPost(HttpServletRequest request, HttpServletResponse response) {
    }
}
