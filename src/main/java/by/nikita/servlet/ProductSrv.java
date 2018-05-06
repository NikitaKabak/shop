package by.nikita.servlet;

import by.nikita.Service.Backet;
import by.nikita.dao.DaoCatalogImp;
import by.nikita.dao.Product;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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


    public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("nameButton"));
        switch (request.getParameter("nameButton")){
            case "addInBacket":
                Integer idProduct = Integer.parseInt(request.getParameter("idProduct"));
                Integer qantityByProduct = Integer.parseInt(request.getParameter("byqantity"));
                Backet backet = new Backet();
                backet.setBacket(idProduct,qantityByProduct);
                Map<Integer,Integer> backetList = new HashMap<>();
                backetList = backet.getBacket();
                System.out.println(backetList);
                HttpSession session = request.getSession();
                session.setAttribute("Backet",backetList);
                request.getRequestDispatcher("/by/nikita/jsp/catalog.jsp").forward(request,response);
        }

    }
}
