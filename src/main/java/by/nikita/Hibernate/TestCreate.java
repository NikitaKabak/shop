package by.nikita.Hibernate;

import by.nikita.Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TestCreate {
    public  void  createTest(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        

        Transaction tx = session.beginTransaction();

        User user = new User();
        user.setNameUser("niki");
        user.setPasswordUser("niki");
        user.setEmailUser("niki@niki");
        user.setIdRole(0);
        user.setIdStatus(0);

        session.save(user);
        tx.commit();
        session.close();

    }
}
