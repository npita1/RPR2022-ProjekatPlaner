package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.ToDoList;
import ba.unsa.etf.rpr.exceptions.PlanerException;

import java.util.ArrayList;

/**
 * Dao interface for To do list item domain bean
 *
 * @author Naida Pita
 */
public interface ToDoListDao extends Dao<ToDoList> {

    /**
     * Returns To do list item that is connected to the given task id
     * @param id
     * @return
     * @throws PlanerException
     */
    ToDoList getToDoListItemByTaskID (int id) throws PlanerException;

    /**
     * Returns all to do items from user
     * @param id
     * @return
     * @throws PlanerException
     */
    ArrayList<ToDoList> getAllTODOTasksFromUser (int id) throws PlanerException;

    /**
     * Returns all to do list items in order to check if task exists
     * @param taskId
     * @return
     * @throws PlanerException
     */
    ArrayList<ToDoList> checkIfTaskIDExists(int taskId) throws PlanerException;

    /**
     * Returns all to do list items that are connected to their subject acronym
     * @param acronym
     * @return
     * @throws PlanerException
     */
    ArrayList<ToDoList> getAllTODOBySubjectAcronym(String acronym) throws PlanerException;

    /**
     * 
     * @param acronym
     * @return
     * @throws PlanerException
     */
    boolean isSubjectOnTODO(String acronym) throws PlanerException;

    boolean isTaskOnTODO(int id) throws PlanerException;
}
