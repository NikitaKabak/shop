package nikita.nikita.Service;

import nikita.nikita.Entity.Order;
import nikita.nikita.Entity.User;
import nikita.nikita.dao.HbmDaoImp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomePageService {
    HttpServletRequest request;
    HttpServletResponse response;
    ApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/app-context.xml");


    public HomePageService(HttpServletRequest request, HttpServletResponse response) {

        this.request = request;
        this.response = response;
    }


    public void gotoHomePage(User userLog) throws ServletException, IOException {
        List<Order> testOrderList = new ArrayList<>();
        List<Order> testOrderList2 = new ArrayList<>();
        Integer iduserLog = userLog.getIdUser();

       // HbmDaoImp hbmDaoImpReg = new HbmDaoImp();
        HbmDaoImp hbmDaoImpReg = context.getBean("HbmDaoImp",HbmDaoImp.class);

        HttpSession session = request.getSession();
        testOrderList = hbmDaoImpReg.getListWhereName(Order.class, "Order", "user", userLog);
        // testOrderList = hbmDaoImpReg.getListWhereNameJoin();
        //  List<Backet> testBacketList = null;

        for (Order order : testOrderList) {
            testOrderList2.add(hbmDaoImpReg.getListWhereNameJoin("Order", "Backet", "Order", "order", order));
            //    testOrderList2 = hbmDaoImpReg.getListWhereName(Backet.class, "Backet", "order", order);

        }
                /*List<Backet> backetList = new ArrayList<>();
                backetList = testOrder.getListBacket();
                Orderstatus orgerstatus = testOrder.getOrgerStatus();*/
                /*UserRoleService userRoleService = new UserRoleService(hbmDaoImpReg.getSessionFactory());
                UserRole userRoleGuest = userRoleService.getUserRoleGuest();
                userReg = new User();
                userReg.setNameUser(nameUser);
                userReg.setPasswordUser(passwordUser);
                userReg.setEmailUser(emailUser);
                userReg.setUserRole(userRoleGuest);
                Serializable id = hbmDaoImpReg.save(userReg);
                userReg = (User) hbmDaoImpReg.get(User.class, id);
*/
        session.setAttribute("iduser", iduserLog);
        session.setAttribute("TestUser", userLog);
        session.setAttribute("TestOrderList", testOrderList2);
        session.getAttribute("iduser");
        //  session.setAttribute("BacketList",testBacketList);
        // session.setAttribute("Orderstatus",orgerstatus);


        request.getRequestDispatcher("/WEB-INF/pages/homepageUsers.jsp").forward(request, response);
    }
}