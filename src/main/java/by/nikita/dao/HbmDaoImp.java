package by.nikita.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class HbmDaoImp<T, PK> implements HbmDao<T, PK>{

    Class<T> clas;

    @PersistenceContext
    protected EntityManager entityManager;

    public HbmDaoImp(Class<T> clazz){
        clas = clazz;
    }




    @Override
    public void create(T t) {
        entityManager.persist(t);
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
    public void save() {


    }



    @Override
    public T get() {
        return null;
    }



}
