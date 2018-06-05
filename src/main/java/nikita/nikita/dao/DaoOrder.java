package nikita.nikita.dao;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface DaoOrder<T> {
    public void create(int iduser, String data) throws NamingException;

    public void delete();

    public void updete(T obj);

    public T getOrder(Integer iduser, String data) throws SQLException, NamingException;

    public List<T> getall() throws NamingException;
}