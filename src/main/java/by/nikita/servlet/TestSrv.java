package by.nikita.servlet;

import by.nikita.dao.*;

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

public class TestSrv {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (request.getParameter("nameButton")){
            case "Create":
                request.getRequestDispatcher("/by/nikita/jsp/homepageTest.jsp").forward(request, response);
            default:
                request.getRequestDispatcher("/by/nikita/jsp/notFound.jsp").forward(request, response);
                break;
        }
    };

    public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (request.getParameter("nameButton")){
            case "create":
                Test testCreate = new Test();
                testCreate.setName(request.getParameter("name"));
                testCreate.setQantity(Integer.parseInt(request.getParameter("Qantity")));
                HbmDaoImp hbmDaoImpCreate = new HbmDaoImp(Test.class);
                hbmDaoImpCreate.create(testCreate);
                request.getRequestDispatcher("/by/nikita/jsp/homepageTest.jsp").forward(request, response);
                break;
            case "save":
                Test testSave = new Test();
                testSave.setName(request.getParameter("name"));
                testSave.setQantity(Integer.parseInt(request.getParameter("Qantity")));
                HbmDaoImp hbmDaoImpSave = new HbmDaoImp(Test.class);
                hbmDaoImpSave.save(testSave);
                request.getRequestDispatcher("/by/nikita/jsp/homepageTest.jsp").forward(request, response);
                break;
            case "update":
                Test testUpdate = new Test();
                Integer idUpdate = Integer.parseInt(request.getParameter("id"));
                HbmDaoImp hbmDaoImpUpdate = new HbmDaoImp(Test.class);
                testUpdate = (Test)hbmDaoImpUpdate.get(idUpdate);
                testUpdate.setName(request.getParameter("name"));
                testUpdate.setQantity(Integer.parseInt(request.getParameter("Qantity")));
                hbmDaoImpUpdate.update(testUpdate);
                testUpdate = (Test)hbmDaoImpUpdate.get(idUpdate);
                HttpSession sessionUpdate = request.getSession();
                sessionUpdate.setAttribute("testGet",testUpdate);
                request.getRequestDispatcher("/by/nikita/jsp/homepageTest.jsp").forward(request, response);
                break;
            case "saveOrUpdate":
                Test testSaveOrUpdate = new Test();
                Integer idSaveOrUpdate = Integer.parseInt(request.getParameter("id"));
                HbmDaoImp hbmSaveOrUpdate = new HbmDaoImp(Test.class);
                testSaveOrUpdate = (Test)hbmSaveOrUpdate.get(idSaveOrUpdate);
                testSaveOrUpdate.setName(request.getParameter("name"));
                testSaveOrUpdate.setQantity(Integer.parseInt(request.getParameter("Qantity")));
                hbmSaveOrUpdate.saveOrUpdate(testSaveOrUpdate);
                testSaveOrUpdate = (Test)hbmSaveOrUpdate.get(idSaveOrUpdate);
                HttpSession sessionSaveOrUpdate = request.getSession();
                sessionSaveOrUpdate.setAttribute("testGet",testSaveOrUpdate);
                request.getRequestDispatcher("/by/nikita/jsp/homepageTest.jsp").forward(request, response);
                request.getRequestDispatcher("/by/nikita/jsp/homepageTest.jsp").forward(request, response);
                request.getRequestDispatcher("/by/nikita/jsp/homepageTest.jsp").forward(request, response);
                break;
            case "delete":
                Test testDelete = new Test();
                Integer idDelete = Integer.parseInt(request.getParameter("id"));
                HbmDaoImp hbmDaoImpDelete = new HbmDaoImp(Test.class);
                testDelete = (Test)hbmDaoImpDelete.get(idDelete);
                hbmDaoImpDelete.delete(testDelete);
                /*HttpSession session = request.getSession();
                session.setAttribute("testGet",testGet);*/
                request.getRequestDispatcher("/by/nikita/jsp/homepageTest.jsp").forward(request, response);
                break;
            case "remove":
                Test testRemove = new Test();
                Integer idRemove = Integer.parseInt(request.getParameter("id"));
                HbmDaoImp hbmDaoImpRemove = new HbmDaoImp(Test.class);
                testRemove = (Test)hbmDaoImpRemove.get(idRemove);
                hbmDaoImpRemove.remove(testRemove);
                /*HttpSession session = request.getSession();
                session.setAttribute("testGet",testGet);*/
                request.getRequestDispatcher("/by/nikita/jsp/homepageTest.jsp").forward(request, response);
                break;
            case "get":
                Test testGet = new Test();
                Integer id = Integer.parseInt(request.getParameter("id"));
                HbmDaoImp hbmDaoImpGet = new HbmDaoImp(Test.class);
                testGet = (Test)hbmDaoImpGet.get(id);
                HttpSession session = request.getSession();
                session.setAttribute("testGet",testGet);
                request.getRequestDispatcher("/by/nikita/jsp/homepageTest.jsp").forward(request, response);
                break;
            case "read":
                Test testRead = new Test();
                Integer idRead = Integer.parseInt(request.getParameter("id"));
                HbmDaoImp hbmDaoImpRead = new HbmDaoImp(Test.class);
                testRead = (Test)hbmDaoImpRead.read(idRead);
                HttpSession sessionRead = request.getSession();
                sessionRead.setAttribute("testGet",testRead);
                request.getRequestDispatcher("/by/nikita/jsp/homepageTest.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("/by/nikita/jsp/notFound.jsp").forward(request, response);
                break;
        }

    }
}
