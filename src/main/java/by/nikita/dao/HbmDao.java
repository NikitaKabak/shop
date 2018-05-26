package by.nikita.dao;

import java.io.Serializable;

public interface HbmDao<T, PK> {

    public void create(T t);

    public Serializable save(T t);

    public void update(T t);

    public void saveOrUpdate(T t);

    public T read(Class<T> clazz,PK id);

    public void delete(T t);

    public T get(Class<T> clazz,PK id);
}
