package by.nikita.dao;

import javax.naming.NamingException;
import java.util.List;

public interface DaoOrder<T> {
    public void create(int iduser, String data) throws NamingException;

    public void delete();

    public void updete(T obj);

    public T reade(int id);

    public List<T> getall() throws NamingException;
}