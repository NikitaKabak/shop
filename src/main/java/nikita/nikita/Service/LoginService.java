package nikita.nikita.Service;

//import by.nikita.Entity.*;
import nikita.nikita.dao.HbmDaoImp;
import nikita.nikita.Entity.Backet;
import nikita.nikita.Entity.Order;
import nikita.nikita.Entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginService {

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameUser = request.getParameter("name");
        String passwordUser = request.getParameter("password");
        HttpSession session = request.getSession();
        if (nameUser.equals("") || passwordUser.equals("")) {
            String error = "Заполните все поля";
            session.setAttribute("Error", error);
            request.getRequestDispatcher("/nikita/nikita/jsp/loginError.jsp").forward(request, response);
        } else {
            HbmDaoImp hbmDaoImpReg = new HbmDaoImp();
            User userLog; // = new User(); // надо  ли  new User()?
            userLog = (User) hbmDaoImpReg.getWhereName(User.class, "User", "nameUser", nameUser);


            if (userLog != null && passwordUser.equals(userLog.getPasswordUser())) {
                HomePageService gotoPage = new HomePageService(request, response);
                gotoPage.gotoHomePage(userLog);

               /* testOrderList = hbmDaoImpReg.getListWhereName(Order.class, "Order", "user", userLog);
               // testOrderList = hbmDaoImpReg.getListWhereNameJoin();
              //  List<Backet> testBacketList = null;

                for(Order order : testOrderList){
                  testOrderList2.add(hbmDaoImpReg.getListWhereNameJoin("Order","Backet", "Order","order",order));
               //    testOrderList2 = hbmDaoImpReg.getListWhereName(Backet.class, "Backet", "order", order);
                }

                *//*List<Backet> backetList = new ArrayList<>();
                backetList = testOrder.getListBacket();
                Orderstatus orgerstatus = testOrder.getOrgerStatus();*//*
                *//*UserRoleService userRoleService = new UserRoleService(hbmDaoImpReg.getSessionFactory());
                UserRole userRoleGuest = userRoleService.getUserRoleGuest();
                userReg = new User();
                userReg.setNameUser(nameUser);
                userReg.setPasswordUser(passwordUser);
                userReg.setEmailUser(emailUser);
                userReg.setUserRole(userRoleGuest);
                Serializable id = hbmDaoImpReg.save(userReg);
                userReg = (User) hbmDaoImpReg.get(User.class, id);
*//*
                session.setAttribute("iduser",iduserLog);
                session.setAttribute("TestUser", userLog);
                session.setAttribute("TestOrderList",testOrderList2);
                session.getAttribute("iduser");
              //  session.setAttribute("BacketList",testBacketList);
               // session.setAttribute("Orderstatus",orgerstatus);


                request.getRequestDispatcher("/nikita/nikita/jsp/homepageUsers.jsp").forward(request, response);*/

            } else {
                String error = "Вы ввели не верные данные:";
                session.setAttribute("Error", error);
                request.getRequestDispatcher("/nikita/nikita/jsp/loginError.jsp").forward(request, response);
            }
        }


    }

}
