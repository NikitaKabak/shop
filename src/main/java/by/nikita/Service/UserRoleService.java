package by.nikita.Service;

import by.nikita.Entity.UserRole;
import by.nikita.Hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


public class UserRoleService {

    SessionFactory  sessionFactory;

    public UserRoleService(){
    }

    public UserRoleService(SessionFactory  sf){
        this.sessionFactory = sf;
    }

    public void getSessionFactory(){
        this.sessionFactory = HibernateUtil.getSessionFactory();

    }

    public UserRole getUserRole(){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" FROM UserRole  WHERE role = 'guest'");
        UserRole userRole = (UserRole)query.getSingleResult();
        session.close();
        return userRole;
    }
}
