package by.nikita.dao;

import java.util.ArrayList;
import java.util.List;

public interface DaoCatalog<T> {
    public  T create();

    public Product read(int id);

    public  void updete(T ob);

    public  void delete(T ob);

    public List<User> getall()throws Exception;

}
