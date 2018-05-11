package by.nikita.dao;

public interface HbmDao<T, PK> {

    public void create(T t);

    public T read(PK id);

    public T updete(T t);

    public void delete(T t);

    public void save(T t);

    public T get();
}
