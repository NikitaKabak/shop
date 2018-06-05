package nikita.nikita.dao;

import nikita.nikita.Entity.Product;
import nikita.nikita.Entity.User;

import java.util.List;

public interface DaoCatalog<T> {
    public  void create();

    public Product read(int id);

    public  void updete(T ob);

    public  void delete(T ob);

    public List<User> getall()throws Exception;

}
