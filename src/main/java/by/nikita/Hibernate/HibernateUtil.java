package by.nikita.Hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.ejb.Ejb3Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static  final Ejb3Configuration ejb3Configuration  = ejb3Configuration();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex){
            System.err.println("Fail : " + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }
    private static Ejb3Configuration ejb3Configuration() {
        try {
            return new Ejb3Configuration().configure("/hibernate.cfg.xml");
        } catch (Throwable ex){
            System.err.println("Fail : " + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }

    public static  SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static  Ejb3Configuration getEjb3Configuration(){
        return ejb3Configuration;
    }


    public  void shutdown(){
        getSessionFactory().close();
    }
}
