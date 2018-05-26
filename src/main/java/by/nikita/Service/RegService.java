package by.nikita.Service;

import by.nikita.Entity.User;
import by.nikita.Entity.UserRole;
import by.nikita.dao.HbmDaoImp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;

public class RegService {
    public void registracion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameUser = request.getParameter("name");
        String passwordUser = request.getParameter("password");
        String emailUser = request.getParameter("email");
        if (nameUser.equals("") || passwordUser.equals("") || emailUser.equals("")) {
            request.getRequestDispatcher("/by/nikita/jsp/loginError.jsp").forward(request, response);
        } else {
            HbmDaoImp hbmDaoImpReg = new HbmDaoImp();
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
                request.getRequestDispatcher("/by/nikita/jsp/homepageTest.jsp").forward(request, response);

            } else {
                request.getRequestDispatcher("/by/nikita/jsp/loginError.jsp").forward(request, response);
            }


        }
    }
}
