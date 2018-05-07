package by.nikita.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        switch (uri) {
            case "/shop":
                FirstServlet firstServlet = new FirstServlet();
                firstServlet.doGet(request, response);
//               /* response.sendRedirect("by/nikita/servlet/FirstServlet");*/
                break;
            case "/shop/catalog":
                CatalogSrv catalogSrv = new CatalogSrv();
                catalogSrv.doGet(request,response);
                break;
            case "/shop/product":
                ProductSrv productSrv = new ProductSrv();
                productSrv.doGet(request,response);
                break;

            default:
                request.getRequestDispatcher("/by/nikita/jsp/notFound.jsp").forward(request, response);
                break;
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        switch (uri) {
            case "/shop":
                FirstServlet firstServlet = new FirstServlet();
                firstServlet.doPost(request, response);
                break;
            case "/shop/catalog":
                CatalogSrv catalogSrv = new CatalogSrv();
                catalogSrv.doPost(request,response);
                break;
            case "/shop/product":
                ProductSrv productSrv = new ProductSrv();
                productSrv.doPost(request,response);
                break;
            default:
                request.getRequestDispatcher("/by/nikita/jsp/notFound.jsp").forward(request, response);
                break;
        }
    }
}
