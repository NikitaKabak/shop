package by.nikita.Hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Singleton {

    public static SessionFactory sessionFactory;

    private Singleton(){}

    public static synchronized SessionFactory getSessionFactory(){
      if(sessionFactory == null){
          try {

              sessionFactory = new Configuration().configure().buildSessionFactory();
          } catch (Throwable ex) {
              System.err.println("Fail : " + ex);
              throw new ExceptionInInitializerError(ex);
          }
      }
        return sessionFactory;
    }

    public void shutdown() {
        getSessionFactory().close();
    }

}
