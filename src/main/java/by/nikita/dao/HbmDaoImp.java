package by.nikita.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class HbmDaoImp<T> implements HbmDao{

    Class<T> clas;

    @PersistenceContext
    protected EntityManager entityManager;

    public HbmDaoImp(Class<T> clazz){
        clas = clazz;
    }




    @Override
    public void save() {


    }

    @Override
    public void delete() {

    }

    @Override
    public void updete() {

    }

    @Override
    public Object get() {
        return null;
    }


}
