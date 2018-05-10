package by.nikita.dao;

public class HbmDaoImp<T> implements HbmDao{
    Class<T> clas;

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
