package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.exceptions.PlanerException;

import java.util.List;

/**
 * Root interface for all DAO classes
 *
 * @author Dino Keco
 */
public interface Dao<T> {

    /**
     * get entity from database base on ID
     * @param id primary key of entity
     * @return Entity from database
     */
    T getById(int id) throws PlanerException;

    /**
     * Saves entity into database
     * @param item bean for saving to database
     * @return saved item with id field populated
     */
    T add(T item) throws PlanerException;
    
    T update(T item) throws PlanerException;
    void delete(int id) throws PlanerException;
    List<T> getAll() throws PlanerException;

}
