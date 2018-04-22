package by.nikita.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class FirstServlet extends HttpServlet {

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
            default:
                System.out.println("Чтото  не так");
                break;

        }

    }
}
