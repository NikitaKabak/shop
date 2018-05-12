package by.nikita.dao;

import by.nikita.Hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.*;

public class HbmDaoImp<T, PK> implements HbmDao<T, PK>{

    Class<T> clas;

    /*@PersistenceUnit(unitName = "CRM")*/
    protected EntityManagerFactory entityManagerFactory;

    EntityManager entityManager;

    public HbmDaoImp(Class<T> clazz){

        clas = clazz;
    }


    @Override
    public void create(T t) {
        entityManagerFactory = Persistence.createEntityManagerFactory("CRM");
        entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction tx =  entityManager.getTransaction();
        tx.begin();
        entityManager.persist(t);
        tx.commit();
        entityManager.close();
    }

    @Override
    public T read(PK id) {

        return entityManager.find(clas,id);

    }

    @Override
    public T updete(T t) {
        return  entityManager.merge(t);

    }

    @Override
    public void delete(T t) {
        t = entityManager.merge(t);
        entityManager.remove(t);

    }



    @Override
    public void save(T t) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(t);
        transaction.commit();
        session.close();



    }



    @Override
    public T get() {
        return null;
    }



}
