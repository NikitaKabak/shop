package nikita.nikita.Service;

import nikita.nikita.Entity.UserRole;
import nikita.nikita.Hibernate.HibernateUtil;
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

    public UserRole getUserRoleGuest(){
        Session session = sessionFactory.openSession();
        String rol = "guest";
        Query query = session.createQuery(" FROM UserRole WHERE role = :role").setParameter("role",rol);
        UserRole userRole = (UserRole)query.getSingleResult();
        session.close();
        return userRole;
    }
}
