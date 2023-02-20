package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.ToDoList;
import ba.unsa.etf.rpr.exceptions.PlanerException;

import java.util.ArrayList;

public interface ToDoListDao extends Dao<ToDoList> {

    ToDoList getToDoListItemByTaskID (int id) throws PlanerException;

    ArrayList<ToDoList> getAllTODOTasksFromUser (int id) throws PlanerException;
    ArrayList<ToDoList> checkIfTaskIDExists(int taskId) throws PlanerException;

    ArrayList<ToDoList> getAllTODOBySubjectAcronym(String acronym) throws PlanerException;

    boolean isSubjectOnTODO(String acronym) throws PlanerException;

    boolean isTaskOnTODO(int id) throws PlanerException;
}
