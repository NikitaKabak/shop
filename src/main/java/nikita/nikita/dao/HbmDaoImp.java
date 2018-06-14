package nikita.nikita.dao;


import nikita.nikita.Entity.Order;
import nikita.nikita.Hibernate.Singleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public class HbmDaoImp<T, PK> implements HbmDao<T, PK> {


    protected Class<T> clas;

    protected SessionFactory sessionFactory = Singleton.getSessionFactory();



    /*@PersistenceUnit(unitName = "CRM")
    protected EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;*/

    public HbmDaoImp() {
    }


   /* public HbmDaoImp(Class<T> clazz) {
        this.clas = clazz;
    }*/

    public SessionFactory getSessionFactory() {
        return sessionFactory;
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


        //Session session = sessionFactory.openSession();

        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();


        session.persist(t);
        transaction.commit();

        //session.close();


    }

    @Override
    public Serializable save(T t) {

        //Session session = sessionFactory.openSession();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

/*
         for (Integer id = 1; id <= 10; id++) {
            Backet backet = new Backet();
             Backet backetT = (Backet) t;

            backet.setIdorder(backetT.getIdorder());
             backet.setIdproduct(backetT.getIdproduct());
             backet.setQantityby(backetT.getQantityby());

             session.save(backet);
           *//* transaction.commit();*//*
        }*/
        //session.save(t);
        Serializable id;
        id = session.save(t);
        transaction.commit();
        // session.close();
        return id;
    }

    @Override
    public void update(T t) {

        //Session session = sessionFactory.openSession();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(t);
        transaction.commit();
        //session.close();

    }

    @Override
    public void saveOrUpdate(T t) {
        //Session session = sessionFactory.openSession();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(t);
        transaction.commit();
        //session.close();


    }

    @Override
    public void delete(T t) {

        //Session session = sessionFactory.openSession();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.merge(t));
        transaction.commit();
        //session.close();


    }

    public void remove(T t) {

        //Session session = sessionFactory.openSession();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.remove(session.merge(t));
        transaction.commit();
        //session.close();

    }

    @Override
    public T get(Class<T> clazz, PK id) {

        //Session session = sessionFactory.openSession();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        this.clas = clazz;
        T entity = (T) session.get(clas, (Serializable) id);
        transaction.commit();
        //session.close();

        return entity;
    }

    public T getWhereName(Class<T> clazz, String entityName, String param, Object entityparam) {

        //Session session = sessionFactory.openSession();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        T entity;

        String qeryStr = "From " + entityName + " WHERE " + param + " = :entityparam";
        Query query = session.createQuery(qeryStr).setParameter("entityparam", entityparam);

        try {
            entity = (T) query.getSingleResult();
        } catch (NoResultException ex) {
            entity = null;
        } finally {
            transaction.commit();
            // session.close();

        }
        return entity;
    }

    public List<T> getListWhereName(Class<T> clazz, String entityName, String param, Object entityparam) {

        //Session session = sessionFactory.openSession();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<T> entity;

        String qeryStr = "From " + entityName + " WHERE " + param + " = :entityparam";
        Query query = session.createQuery(qeryStr).setParameter("entityparam", entityparam);
        //Query query = session.createQuery("FROM  Backet where Backet.order = :or ", Backet.class).setParameter("or",order);

        try {
            entity = query.getResultList();
        } catch (NoResultException ex) {
            entity = null;
        } finally {
            transaction.commit();
            //  session.close();

        }
        return entity;

    }



    public Order getListWhereNameJoin(String entityName, String entityname2, String param, String param2, Object entityparam) {

        //Session session = sessionFactory.openSession();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Order entity;


        /// String qeryStr = "From " + entityName + " WHERE " + param + " = :entityparam";

        // SELECT * FROM orders  Left outer join backet  ON backet.idord = orders.idorder where idorder = 46 ;
        //  String qeryStr = "From " + "Order" + " Left outer join " + "Backet" + " ON " + " Backet.order = Order  " + " WHERE " + " Order = :entityparam";
        //    Query query = session.createQuery(qeryStr).setParameter("entityparam", order);
        //String qeryStr = "From " + "Order" + " Left outer join " + "Backet" +" ON " + " Backet.order = Order  " + " WHERE " + " Order = :entityparam" ;

     // Query query = session.createQuery("select  Order , Backet from Order , Backet  where Backet.order = :or ", Order.class).setParameter("or",order);

       // Query query = session.createQuery("FROM  Backet where order = :or ", Backet.class).setParameter("or",order);
     //   String qeryStr = "From  " + entityName + " Left outer join  " +  entityname2 + " on " + param2 + " = :entityparam" + " WHERE " + param + " = :entityparam";
//        Query query = session.createQuery(qeryStr).setParameter("entityparam", entityparam);
        Query query = session.createQuery("FROM Order nn left outer join fetch nn.listBacket where nn = :entity",Order.class).setParameter("entity",entityparam);
        //entity = (Order)query.getSingleResult();
      //  Query query = session.createQuery("FROM  Order  left  outer join Backet  on Backet.order = :or ", Backet.class).setParameter("or",order);

       // List<Order> orders = session.createQuery(" FROM  Order  left  outer join Backet  on order = :order ",Order.class).setParameter("order",order).getResultList();
      //  where Order.idorder = :idorder
        //        .setParameter("idorder",order.getIdorder()

       /* List<Person> persons = entityManager.createQuery(
                "select distinct pr " +
                        "from Person pr " +
                        "left outer join pr.phones ph " +
                        "where ph is null " +
                        "   or ph.type = :phoneType", Person.class )
                .setParameter( "phoneType", PhoneType.LAND_LINE )
                .getResultList();*/
        //Query query = session.createQuery(qeryStr);


        try {
            entity = (Order) query.getSingleResult();
        } catch (NoResultException ex) {
            entity = null;
        } finally {
            transaction.commit();

        }
        return entity;

    }


    @Override
    public T read(Class<T> clazz, PK id) {


        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        this.clas = clazz;
        T entity = session.find(clas, id);
        transaction.commit();



        return entity;

    }

    public List getAll(Class<T> clazz) {
        this.clas = clazz;
        List list = null;

        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(clas);
        Root<T> root = query.from(clas);
        query.select(root);


        list = session.createQuery(query).getResultList();
        transaction.commit();

        return list;
    }

    public void setClas(Class<T> clas) {
        this.clas = clas;
    }

    public Class<T> getClas() {
        return clas;
    }
}



