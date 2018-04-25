package by.nikita.servlet;

import by.nikita.dao.DaoUsers;
import by.nikita.logger.App;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

public class FirstServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(FirstServlet.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/by/nikita/jsp/startpage.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        switch (request.getParameter("nameButton")) {
            case "catalog":
                request.getRequestDispatcher("/by/nikita/jsp/catalog.jsp").forward(request, response);
                break;
            case "login":
                request.getRequestDispatcher("/by/nikita/jsp/login.jsp").forward(request, response);
                break;
            case "registracion":
                request.getRequestDispatcher("/by/nikita/jsp/registracion.jsp").forward(request, response);
                break;
            case "users":
                request.getRequestDispatcher("/by/nikita/jsp/users.jsp").forward(request, response);
                break;
            case "showUser":
                DaoUsers list = new DaoUsers();

                int id = Integer.parseInt(request.getParameter("idusers"));

                ArrayList<String> listl = list.read(id);
                System.out.println(listl);

                request.getSession().setAttribute( "list",listl);
                request.getRequestDispatcher("/by/nikita/jsp/userInfo.jsp").forward(request, response);
                break;
            default:
                System.out.println("Чтото  не так");
                break;

        }

    }
}
