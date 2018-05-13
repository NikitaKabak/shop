package by.nikita.dao;

import by.nikita.Hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.*;
import java.io.Serializable;

public class HbmDaoImp<T, PK> implements HbmDao<T, PK> {


    protected final Class<T> clas;

    protected SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    /*@PersistenceUnit(unitName = "CRM")
    protected EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;*/

    public HbmDaoImp(Class<T> clazz) {

        this.clas = clazz;
    }


    @Override
    public void create(T t) {
       /* entityManagerFactory = Persistence.createEntityManagerFactory("CRM");
        entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction tx =  entityManager.getTransaction();
        tx.begin();
        entityManager.persist(t);
        tx.commit();
        entityManager.close();*/
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(t);
        transaction.commit();
        session.close();


    }

    @Override
    public void save(T t) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(t);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(T t) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(t);
        transaction.commit();
        session.close();

    }

    @Override
    public void saveOrUpdate(T t) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(t);
        transaction.commit();
        session.close();


    }

    @Override
    public void delete(T t) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.merge(t));
        transaction.commit();
        session.close();


    }

    public void remove(T t) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(session.merge(t));
        transaction.commit();
        session.close();


    }

    @Override
    public T get(PK id) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
       Class<T> tClass ;
        T entity = (T) session.get(clas, (Serializable) id);
        transaction.commit();
        session.close();

        return entity;
    }

    @Override
    public T read(PK id) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Class<T> tClass ;
        T entity = session.find(clas,id);
        transaction.commit();
        session.close();


        return entity;

    }



}
