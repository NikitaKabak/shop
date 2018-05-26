package by.nikita.servlet;

import by.nikita.Entity.*;
import by.nikita.Service.UserRoleService;
import by.nikita.dao.*;

import javax.persistence.PrePersist;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

public class TestSrv {

    public static final Integer DEFAULT_ROLE = 0;
    public static final Integer DEFAULT_STATUS = 3;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (request.getParameter("nameButton")) {
            case "Create":
                request.getRequestDispatcher("/by/nikita/jsp/homepageTest.jsp").forward(request, response);
            default:
                request.getRequestDispatcher("/by/nikita/jsp/notFound.jsp").forward(request, response);
                break;
        }
    }

    ;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (request.getParameter("nameButton")) {
            case "Reg":
                //CREATE USER
                HbmDaoImp hbmDaoImpReg = new HbmDaoImp();
                User userReg = new User();
                UserRoleService userRoleService = new UserRoleService(hbmDaoImpReg.getSessionFactory());
                UserRole userRole = userRoleService.getUserRoleGuest();
                userReg.setNameUser(request.getParameter("name"));
                userReg.setPasswordUser(request.getParameter("password"));
                userReg.setEmailUser(request.getParameter("email"));
                userReg.setUserRole(userRole);
                /*UserRole defaultRole = new UserRole(0,"guest");
                Userstatus defaultStatus = new Userstatus(3,"new");
                userReg.setUserRole(defaultRole);
                userReg.setUserStatus(defaultStatus);*/
                hbmDaoImpReg.create(userReg);



                request.getRequestDispatcher("/by/nikita/jsp/homepageTest.jsp").forward(request, response);
                break;

            case "create":
                //CREATE TEST
                Test testCreate = new Test();
                testCreate.setName(request.getParameter("name"));
                testCreate.setQantity(Integer.parseInt(request.getParameter("Qantity")));
                HbmDaoImp hbmDaoImpCreate = new HbmDaoImp();
                hbmDaoImpCreate.create(testCreate);
                /*//CREATE USER
                User userCreate = new User();
                userCreate.setNameUser(request.getParameter("name"));
                userCreate.setPasswordUser(request.getParameter("password"));
                userCreate.setEmailUser(request.getParameter("email"));
                HbmDaoImp hbmDaoImpCreate = new HbmDaoImp(Test.class);
                hbmDaoImpCreate.create(userCreate);*/



                request.getRequestDispatcher("/by/nikita/jsp/homepageTest.jsp").forward(request, response);
                break;
            case "save":
                Test testSave = new Test();
                testSave.setName(request.getParameter("name"));
                testSave.setQantity(Integer.parseInt(request.getParameter("Qantity")));
                HbmDaoImp hbmDaoImpSave = new HbmDaoImp();
                hbmDaoImpSave.save(testSave);



                request.getRequestDispatcher("/by/nikita/jsp/homepageTest.jsp").forward(request, response);
                break;
            case "update":
                Test testUpdate = new Test();
                Integer idUpdate = Integer.parseInt(request.getParameter("id"));
                HbmDaoImp hbmDaoImpUpdate = new HbmDaoImp();
                testUpdate = (Test) hbmDaoImpUpdate.get(Test.class,idUpdate);
                testUpdate.setName(request.getParameter("name"));
                testUpdate.setQantity(Integer.parseInt(request.getParameter("Qantity")));
                hbmDaoImpUpdate.update(testUpdate);
                testUpdate = (Test) hbmDaoImpUpdate.get(Test.class,idUpdate);
                HttpSession sessionUpdate = request.getSession();
                sessionUpdate.setAttribute("testGet", testUpdate);
                request.getRequestDispatcher("/by/nikita/jsp/homepageTest.jsp").forward(request, response);
                break;
            case "saveOrUpdate":
                Test testSaveOrUpdate = new Test();
                Integer idSaveOrUpdate = Integer.parseInt(request.getParameter("id"));
                HbmDaoImp hbmSaveOrUpdate = new HbmDaoImp();
                testSaveOrUpdate = (Test) hbmSaveOrUpdate.get(Test.class, idSaveOrUpdate);
                testSaveOrUpdate.setName(request.getParameter("name"));
                testSaveOrUpdate.setQantity(Integer.parseInt(request.getParameter("Qantity")));
                hbmSaveOrUpdate.saveOrUpdate(testSaveOrUpdate);
                testSaveOrUpdate = (Test) hbmSaveOrUpdate.get(Test.class, idSaveOrUpdate);
                HttpSession sessionSaveOrUpdate = request.getSession();
                sessionSaveOrUpdate.setAttribute("testGet", testSaveOrUpdate);
                request.getRequestDispatcher("/by/nikita/jsp/homepageTest.jsp").forward(request, response);
                request.getRequestDispatcher("/by/nikita/jsp/homepageTest.jsp").forward(request, response);
                request.getRequestDispatcher("/by/nikita/jsp/homepageTest.jsp").forward(request, response);
                break;
            case "delete":
                Test testDelete = new Test();
                Integer idDelete = Integer.parseInt(request.getParameter("id"));
                HbmDaoImp hbmDaoImpDelete = new HbmDaoImp();
                testDelete = (Test) hbmDaoImpDelete.get(Test.class, idDelete);
                hbmDaoImpDelete.delete(testDelete);
                /*HttpSession session = request.getSession();
                session.setAttribute("testGet",testGet);*/
                request.getRequestDispatcher("/by/nikita/jsp/homepageTest.jsp").forward(request, response);
                break;
            case "remove":
                Test testRemove = new Test();
                Integer idRemove = Integer.parseInt(request.getParameter("id"));
                HbmDaoImp hbmDaoImpRemove = new HbmDaoImp();
                testRemove = (Test) hbmDaoImpRemove.get(Test.class, idRemove);
                hbmDaoImpRemove.remove(testRemove);
                /*HttpSession session = request.getSession();
                session.setAttribute("testGet",testGet);*/
                request.getRequestDispatcher("/by/nikita/jsp/homepageTest.jsp").forward(request, response);
                break;
            case "get":
                /*Test testGet = new Test();
                Integer id = Integer.parseInt(request.getParameter("id"));
                HbmDaoImp hbmDaoImpGet = new HbmDaoImp(Test.class);
                testGet = (Test)hbmDaoImpGet.get(id);*/

                // GET Bucket
             /*   Backet testGet = new Backet();
                Integer id = Integer.parseInt(request.getParameter("id"));
                HbmDaoImp hbmDaoImpGet = new HbmDaoImp(Backet.class);
                testGet = (Backet)hbmDaoImpGet.get(id);
                Order getOrder = testGet.getOrder();
                Product getProduct = testGet.getProduct();*/

                //GET ORDER
                /*Order testOrder = new Order();
                Integer id = Integer.parseInt(request.getParameter("id"));
                HbmDaoImp hbmDaoImpGet = new HbmDaoImp(Order.class);
                testOrder = (Order)hbmDaoImpGet.get(id);
                List<Backet> backetList = new ArrayList<>();
                backetList = testOrder.getListBacket();
                User user = testOrder.getUser();
                Orgerstatus orgerstatus = testOrder.getOrgerStatus();*/

                //GET PRODUCT
               /* Product testProduct = new Product();
                Integer id = Integer.parseInt(request.getParameter("id"));
                HbmDaoImp hbmDaoImpGet = new HbmDaoImp(Product.class);
                testProduct = (Product)hbmDaoImpGet.get(id);
                Productstatus productstatus = testProduct.getProductstatus();*/

                //USER
                /*User testUser = new User();
                Integer id = Integer.parseInt(request.getParameter("id"));
                HbmDaoImp hbmDaoImpGet = new HbmDaoImp();
                testUser = (User) hbmDaoImpGet.get(User.class, id);
                //List<Backet> backetList = new ArrayList<>();
                //backetList = testGet.getListBacket();
                UserRole userRole = testUser.getUserRole();
                Userstatus userstatus = testUser.getUserStatus();*/

                //ROlE
                UserRole testUserRole = new UserRole();
                Integer id = Integer.parseInt(request.getParameter("id"));
                HbmDaoImp hbmDaoImpGet = new HbmDaoImp();
                testUserRole = (UserRole) hbmDaoImpGet.get(UserRole.class, id);
                //List<User> listUser = testUserRole.getListUser();

                HttpSession session = request.getSession();


                //GET Bucket
                /*session.setAttribute("getProduct",getProduct);
                session.setAttribute("getOrder",getOrder);*/

                //GET ORDER
                /*session.setAttribute("TestOrder",testOrder);
                session.setAttribute("backetList",backetList);
                session.setAttribute("User",user);
                session.setAttribute("Orgerstatus",orgerstatus);*/

                //GET PRODUCT
                /*session.setAttribute("TestProduct",testProduct);
                session.setAttribute("Productstatus",productstatus);*/

                //GET USER
                /*session.setAttribute("TestUser", testUser);
                session.setAttribute("UserRole", userRole);
                session.setAttribute("Userstatus", userstatus);*/

                //GET USERROLE
                session.setAttribute("UserRole", testUserRole);
                //session.setAttribute("ListUser", listUser);

                request.getRequestDispatcher("/by/nikita/jsp/homepageTest.jsp").forward(request, response);
                break;
            case "read":
                Test testRead = new Test();
                Integer idRead = Integer.parseInt(request.getParameter("id"));
                HbmDaoImp hbmDaoImpRead = new HbmDaoImp();
                testRead = (Test) hbmDaoImpRead.read(Test.class, idRead);
                HttpSession sessionRead = request.getSession();
                sessionRead.setAttribute("testGet", testRead);
                request.getRequestDispatcher("/by/nikita/jsp/homepageTest.jsp").forward(request, response);
                break;
            case "getAll":

                // Test ERntuty
                /*List<Order> listTest = new ArrayList();
                Order test = new Order();
                HbmDaoImp hbmDaoImpgetAll = new HbmDaoImp(Order.class);
                listTest = hbmDaoImpgetAll.getAll(Order.class);*/

                //getALL USERS
                List<User> listTest = new ArrayList();
                User test = new User();
                HbmDaoImp hbmDaoImpgetAll = new HbmDaoImp();
                listTest = hbmDaoImpgetAll.getAll(Order.class);

                /*List<Test> listTest = new ArrayList();
                Test test = new Test();
                HbmDaoImp hbmDaoImpgetAll = new HbmDaoImp(Test.class);
                listTest = hbmDaoImpgetAll.getAll(Test.class);*/
                HttpSession sessiongetAll = request.getSession();
                sessiongetAll.setAttribute("listTest", listTest);
                request.getRequestDispatcher("/by/nikita/jsp/homepageTest.jsp").forward(request, response);
                break;

            default:
                request.getRequestDispatcher("/by/nikita/jsp/notFound.jsp").forward(request, response);
                break;
        }

    }
}
