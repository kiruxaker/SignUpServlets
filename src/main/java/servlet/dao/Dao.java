package servlet.dao;


import java.util.List;

public interface Dao<T> {

    List<T> findAll();
    T save(T obj);
    T findByEmail(String email);

}
