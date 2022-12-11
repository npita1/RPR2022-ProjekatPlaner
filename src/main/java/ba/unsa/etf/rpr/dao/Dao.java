package ba.unsa.etf.rpr.dao;

import java.util.List;

// osnovni pozivi na bazu
public interface Dao<T> {

    T getById(int id);
    void add(T item);
    void update(T item);
    void delete(int id);
    List<T> getAll();

}
