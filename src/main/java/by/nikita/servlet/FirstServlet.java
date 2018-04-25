package by.nikita.servlet;

import by.nikita.dao.DaoUsers;
import by.nikita.dao.User;
import org.apache.log4j.Logger;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
                DaoUsers user = null;
                try {
                    user = new DaoUsers();
                } catch (NamingException e) {
                    e.printStackTrace();
                }

                int id = Integer.parseInt(request.getParameter("idusers"));

                ArrayList<String> listl = user.read(id);
                System.out.println(listl);

                request.getSession().setAttribute( "list",listl);
                request.getRequestDispatcher("/by/nikita/jsp/userInfo.jsp").forward(request, response);
               /* RequestDispatcher rd = request.getRequestDispatcher("/by/nikita/jsp/userInfo.jsp");
                rd.forward(request, response);*/
                break;
            case"showAllusers":
                DaoUsers users = null;
                try {
                    users = new DaoUsers();
                } catch (NamingException e) {
                    e.printStackTrace();
                }
                List<User> usersList = null;
                try {
                    usersList=users.getall();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                request.setAttribute("users", usersList);
                RequestDispatcher rd = request.getRequestDispatcher("/by/nikita/jsp/usersInfo.jsp");
                rd.forward(request, response);
                break;
            default:
                System.out.println("Чтото  не так");
                break;

        }

    }
}
