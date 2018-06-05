package nikita.nikita.servlet;

import nikita.nikita.Entity.Backet;
import nikita.nikita.Entity.Order;
import nikita.nikita.Entity.Product;
import nikita.nikita.Entity.User;
import nikita.nikita.Service.HomePageService;
import nikita.nikita.dao.DaoOrderImp;
import nikita.nikita.dao.HbmDaoImp;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class OrderSrv {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (request.getParameter("nameButton")) {
            case "Create":
                HttpSession session = request.getSession();
                HbmDaoImp daoImpl = new HbmDaoImp();
                Integer iduser = (Integer) session.getAttribute("iduser");
                User user = (User) daoImpl.get(User.class, iduser);

                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String data = dateFormat.format(date);

                Order order = new Order();

                order.setData(data);
                order.setUser(user);
                order.setOrgerStatus(order.DEFAULT_ORDERSTATUS);

////////////// ХЗ КАК ЭТО БУДЕТ РАБОТАТЬ

                Map<Integer, Integer> map = (Map<Integer, Integer>) session.getAttribute("Backet");
                List<Backet> backetList = new ArrayList<>();

                if (map != null) {
                    Map<Integer, Integer> backetMap = new HashMap<>();
                    backetMap.putAll(map);
                    System.out.println("Map из requesta");
                    System.out.println(backetMap);

                    for (Map.Entry entry : backetMap.entrySet()) {
                        Backet backet = new Backet();

                        Integer idProduckt = (Integer) entry.getKey();
                        Integer qantityby = (Integer) entry.getValue();
                        System.out.println("Key: " + idProduckt + " Value: " + qantityby);

                        backet.setOrder(order);
                        backet.setProduct((Product) daoImpl.get(Product.class, idProduckt));
                        backet.setQantityby(qantityby);
                        backetList.add(backet);
                    }
                }

                order.setListBacket(backetList);
                daoImpl.save(order);



                session.setAttribute("backet", null);
                HomePageService gotoPage = new HomePageService(request, response);
                gotoPage.gotoHomePage(user);


            default:
                request.getRequestDispatcher("/nikita/nikita/jsp/notFound.jsp").forward(request, response);
                break;
        }

    }

    ;
}
