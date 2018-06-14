package nikita.nikita.Service;

import nikita.nikita.Entity.User;
import nikita.nikita.Entity.UserRole;
import nikita.nikita.dao.HbmDaoImp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;

public class RegService {
    ApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/app-context.xml");
    public void registracion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameUser = request.getParameter("name");
        String passwordUser = request.getParameter("password");
        String emailUser = request.getParameter("email");
        if (nameUser.equals("") || passwordUser.equals("") || emailUser.equals("")) {
            request.getRequestDispatcher("/WEB-INF/pages/loginError.jsp").forward(request, response);
        } else {
           // HbmDaoImp hbmDaoImpReg = new HbmDaoImp();
            HbmDaoImp hbmDaoImpReg = context.getBean("HbmDaoImp",HbmDaoImp.class);
            User userReg; // = new User(); // надо  ли  new User()?
            userReg = (User) hbmDaoImpReg.getWhereName(User.class, "User", "nameUser", nameUser);

            if (userReg == null) {
                UserRoleService userRoleService = new UserRoleService(hbmDaoImpReg.getSessionFactory());
                UserRole userRoleGuest = userRoleService.getUserRoleGuest();
                userReg = new User();
                userReg.setNameUser(nameUser);
                userReg.setPasswordUser(passwordUser);
                userReg.setEmailUser(emailUser);
                userReg.setUserRole(userRoleGuest);
                Serializable id = hbmDaoImpReg.save(userReg);
                userReg = (User) hbmDaoImpReg.get(User.class, id);

                HttpSession session = request.getSession();
                session.setAttribute("TestUser", userReg);
                request.getRequestDispatcher("/WEB-INF/pages/homepageTest.jsp").forward(request, response);

            } else {
                request.getRequestDispatcher("/WEB-INF/pages/loginError.jsp").forward(request, response);
            }


        }
    }
}
