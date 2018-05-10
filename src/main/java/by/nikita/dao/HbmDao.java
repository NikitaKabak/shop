package by.nikita.dao;

public interface HbmDao<T,PK> {


    public  void save();
    public  void delete();
    public  void updete();
    public  T get();
}
