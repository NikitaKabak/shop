package by.nikita.servlet;

import by.nikita.dao.DaoCatalogImp;
import by.nikita.dao.Product;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CatalogSrv extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoCatalogImp product = null;
        try {
            product = new DaoCatalogImp();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        List<Product>catalog = null;
        try {
          catalog = product.getall();

        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("catalog", catalog);
        request.getRequestDispatcher("/by/nikita/jsp/catalog.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request.getParameter("id"));

    }
}
