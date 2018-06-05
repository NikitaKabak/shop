package nikita.nikita.servlet;

import nikita.nikita.Service.LoginService;
import nikita.nikita.Service.ProductSrv;
import nikita.nikita.Service.RegService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    private Integer iduser;


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("iduser") != null) {
            iduser = (Integer) session.getAttribute("iduser");
        } else {
            iduser = 0;
            session.setAttribute("iduser", iduser);
        }


        String uri = request.getRequestURI();
        switch (uri) {
            case "/shop":
                FirstServlet firstServlet = new FirstServlet();
                firstServlet.doGet(request, response);//
                break;
            case "/shop/catalog":
                CatalogSrv catalogSrv = new CatalogSrv();

                catalogSrv.getCatalog(request, response);
                break;
            case "/shop/product":
                ProductSrv productSrv = new ProductSrv();
                productSrv.getProduct(request, response);

                break;
            case "/shop/order":
                OrderSrv orderSrv = new OrderSrv();
                orderSrv.doGet(request, response);
                break;
            case "/shop/test":
                TestSrv testSrv = new TestSrv();
                testSrv.doGet(request, response);
                break;

            default:
                request.getRequestDispatcher("/nikita/nikita/jsp/notFound.jsp").forward(request, response);
                break;
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("iduser") != null) {
            iduser = (Integer) session.getAttribute("iduser");
        } else {
            iduser = 0;
            session.setAttribute("iduser", iduser);
        }

        String uri = request.getRequestURI();
        switch (uri) {
            case "/shop":
                FirstServlet firstServlet = new FirstServlet();
                firstServlet.doPost(request, response);
                break;
            case "/shop/catalog":
                CatalogSrv catalogSrv = new CatalogSrv();
                catalogSrv.doPost(request, response);
                break;
            case "/shop/product":
                ProductSrv productSrv = new ProductSrv();
                productSrv.doPost(request, response);
                break;
            case "/shop/order":
                OrderSrv orderSrv = new OrderSrv();
                orderSrv.doPost(request, response);
                break;
            case "/shop/test":
                TestSrv testSrv = new TestSrv();
                testSrv.doPost(request, response);
                break;
            case "/shop/registracion":
                RegService regService = new RegService();
                regService.registracion(request, response);
                break;

            case "/shop/login":
                LoginService loginService = new LoginService();
                loginService.login(request, response);
                break;
            default:
                request.getRequestDispatcher("/nikita/nikita/jsp/notFound.jsp").forward(request, response);
                break;
        }
    }
}
