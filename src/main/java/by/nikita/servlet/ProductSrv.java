package by.nikita.servlet;

import by.nikita.dao.DaoCatalogImp;
import by.nikita.dao.Product;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductSrv extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoCatalogImp productID = null;
        try {
            productID = new DaoCatalogImp();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productID.read(id);
        System.out.println(product);
        request.setAttribute("product",product);
        request.getRequestDispatcher("/by/nikita/jsp/product.jsp").forward(request, response);
    }


    public  void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}
