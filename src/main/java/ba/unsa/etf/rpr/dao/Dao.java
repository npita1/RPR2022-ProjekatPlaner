package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.exceptions.PlanerException;

import java.util.List;

// osnovni pozivi na bazu
public interface Dao<T> {

    T getById(int id) throws PlanerException;
    T add(T item) throws PlanerException;
    T update(T item) throws PlanerException;
    void delete(int id) throws PlanerException;
    List<T> getAll() throws PlanerException;

}
