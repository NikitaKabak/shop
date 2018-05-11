package by.nikita.servlet;

import by.nikita.dao.Backet;
import by.nikita.dao.DaoOrderImp;
import by.nikita.dao.HbmDaoImp;
import by.nikita.dao.Order;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class OrderSrv {
    public void doGet( HttpServletRequest request, HttpServletResponse response){


    };
    public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (request.getParameter("nameButton")){
            case "Create":
                HttpSession session = request.getSession();
                Integer iduser = (Integer) session.getAttribute("iduser");
                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println(dateFormat.format(date));

                String data = dateFormat.format(date);

                DaoOrderImp orderImp = null;
                Order order = new Order();
                orderImp = new DaoOrderImp();


                try {
                    orderImp.create(iduser,data);
                } catch (NamingException e) {
                    e.printStackTrace();
                }
                try {
                    order = orderImp.getOrder(iduser,data);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (NamingException e) {
                    e.printStackTrace();
                }
                Integer orderID = order.getIdorder();
                System.out.println(orderID);



                Map<Integer, Integer> map = (Map<Integer, Integer>) session.getAttribute("Backet");

                if (map != null) {
                    Map<Integer, Integer> backetMap = new HashMap<>();
                    backetMap.putAll(map);
                    System.out.println("Map из requesta");
                    System.out.println(backetMap);

                    Backet backet = new Backet();
                    HbmDaoImp daoBacket = new HbmDaoImp(Backet.class);
                    /*backet.setIdbacket(1);*/
                    backet.setIdorder(orderID);

                    for (Map.Entry entry : backetMap.entrySet()) {
                        Integer idProduckt = (Integer) entry.getKey();
                        Integer qantityby = (Integer) entry.getValue();
                        System.out.println("Key: " + idProduckt + " Value: " + qantityby);
                        backet.setIdproduct(idProduckt);
                        backet.setQantityby(qantityby);
                        daoBacket.create(backet);
                        /*daoBacket.save(backet);*/
                    }
                    System.out.println(backet);
                }







                /*session.getAttribute("backet");


                backetImp.add(orderID, idproduct, quantityby);*/

                session.setAttribute("backet", null);
                request.getRequestDispatcher("/by/nikita/jsp/homepage.jsp").forward(request, response);

            default:
                request.getRequestDispatcher("/by/nikita/jsp/notFound.jsp").forward(request, response);
                break;
        }

    };
}
