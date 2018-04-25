package by.nikita.dao;

import java.util.ArrayList;
import java.util.List;

public interface DaoInterface<T> {
    public  T create();

    public ArrayList<String> read(int id);

    public  void updete(T ob);

    public  void delete(T ob);

    public List<T> getall()throws Exception;
}
