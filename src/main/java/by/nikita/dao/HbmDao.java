package by.nikita.dao;

public interface HbmDao<T, PK> {

    public void create(T t);

    public void save(T t);

    public void update(T t);

    public void saveOrUpdate(T t);

    public T read(PK id);

    public void delete(T t);

    public T get(PK id);
}
