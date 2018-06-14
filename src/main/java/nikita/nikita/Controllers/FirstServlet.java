package nikita.nikita.Controllers;

import nikita.nikita.dao.DaoUsersImp;
import nikita.nikita.Entity.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Controller
public class FirstServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(FirstServlet.class);

    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/pages/startpage.jsp").forward(request, response);
        String uri = request.getRequestURI();
        System.out.println(uri);
    }

    @RequestMapping(value = "/shop", method = RequestMethod.POST)
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        switch (request.getParameter("nameButton")) {
            case "catalog":
                request.getRequestDispatcher("/WEB-INF/pages/catalog.jsp").forward(request, response);
                break;
            case "login":
                String loginU = request.getParameter("login");
                String passwordU = request.getParameter("password");
                if (loginU.equals("") || passwordU.equals("") ){
                    request.getRequestDispatcher("/WEB-INF/pages/loginError.jsp").forward(request, response);
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
                        request.getRequestDispatcher("/WEB-INF/pages/homepage.jsp").forward(request, response);
                    } else
                    {
                        request.getRequestDispatcher("/WEB-INF/pages/loginError.jsp").forward(request, response);
                    }
                }
                break;
            case "Reg":
                String nameUser = request.getParameter("name");
                String passwordUser = request.getParameter("password");
                String emailUser = request.getParameter("email");
                if (nameUser.equals("") || passwordUser.equals("") || emailUser.equals("") ){
                    request.getRequestDispatcher("/WEB-INF/pages/loginError.jsp").forward(request, response);
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
                    request.getRequestDispatcher("/WEB-INF/pages/users.jsp").forward(request, response);
                }
                break;
            case "registracion":
                request.getRequestDispatcher("/by/nikita/jsp/registracion.jsp").forward(request, response);
                break;
            case "users":
                request.getRequestDispatcher("/WEB-INF/pages/users.jsp").forward(request, response);
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
                request.getRequestDispatcher("/WEB-INF/pages/userInfo.jsp").forward(request, response);
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
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/usersInfo.jsp");
                rd.forward(request, response);
                break;
            default:
                System.out.println("Чтото  не так");
                break;

        }

    }
}
