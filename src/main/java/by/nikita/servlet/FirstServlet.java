package by.nikita.servlet;

import by.nikita.Hibernate.TestCreate;
import by.nikita.dao.DaoUsersImp;
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


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/by/nikita/jsp/startpage.jsp").forward(request, response);
        String uri = request.getRequestURI();
        System.out.println(uri);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        switch (request.getParameter("nameButton")) {
            case "catalog":
                request.getRequestDispatcher("/by/nikita/jsp/catalog.jsp").forward(request, response);
                break;
            case "login":
                String loginU = request.getParameter("login");
                String passwordU = request.getParameter("password");
                if (loginU.equals("") || passwordU.equals("") ){
                    request.getRequestDispatcher("/by/nikita/jsp/loginError.jsp").forward(request, response);
                } else {
                    DaoUsersImp user = null;
                    try {
                        user = new DaoUsersImp();
                    } catch (NamingException e) {
                        e.printStackTrace();
                    }
                    ArrayList<String> list = null;
                    try {
                        list = user.read(loginU);
                    } catch (NamingException e) {
                        e.printStackTrace();
                    }
                    System.out.println(list);
                    String pass = list.get(2);
                    if (passwordU.equals(pass)){
                        request.getRequestDispatcher("/by/nikita/jsp/homepage.jsp").forward(request, response);
                    } else
                    {
                        request.getRequestDispatcher("/by/nikita/jsp/loginError.jsp").forward(request, response);
                    }
                }
                break;
            case "Reg":
                String nameUser = request.getParameter("name");
                String passwordUser = request.getParameter("password");
                String emailUser = request.getParameter("email");
                if (nameUser.equals("") || passwordUser.equals("") || emailUser.equals("") ){
                    request.getRequestDispatcher("/by/nikita/jsp/loginError.jsp").forward(request, response);
                } else {
                    /*TestCreate userr = null;*/
                    DaoUsersImp userr = null;
                    try {

                        /*userr = new TestCreate();
                        userr.createTest();*/
                        userr = new DaoUsersImp();
                        userr.create(nameUser, passwordUser, emailUser);
                    } catch (NamingException e) {
                        e.printStackTrace();
                    }
                    request.getRequestDispatcher("/by/nikita/jsp/users.jsp").forward(request, response);
                }
                break;
            case "registracion":
                request.getRequestDispatcher("/by/nikita/jsp/registracion.jsp").forward(request, response);
                break;
            case "users":
                request.getRequestDispatcher("/by/nikita/jsp/users.jsp").forward(request, response);
                break;
            case "showUser":
                DaoUsersImp user = null;
                try {
                    user = new DaoUsersImp();
                } catch (NamingException e) {
                    e.printStackTrace();
                }

                int id = Integer.parseInt(request.getParameter("idusers"));

                ArrayList<String> listl = null;
                try {
                    listl = user.read(id);
                } catch (NamingException e) {
                    e.printStackTrace();
                }
                System.out.println(listl);

                request.getSession().setAttribute( "list",listl);
                request.getRequestDispatcher("/by/nikita/jsp/userInfo.jsp").forward(request, response);
               /* RequestDispatcher rd = request.getRequestDispatcher("/by/nikita/jsp/userInfo.jsp");
                rd.forward(request, response);*/
                break;
            case"showAllusers":
                DaoUsersImp users = null;
                try {
                    users = new DaoUsersImp();
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
