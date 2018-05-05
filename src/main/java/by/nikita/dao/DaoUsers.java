package by.nikita.dao;

import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.List;

public interface DaoUsers<T> {
    public  void create(String nameUser, String passwordUser, String emailUser) throws NamingException;

    public ArrayList<String> read(int id) throws NamingException;

    public  void updete(T ob);

    public  void delete(T ob);

    public List<User> getall()throws Exception;
}
