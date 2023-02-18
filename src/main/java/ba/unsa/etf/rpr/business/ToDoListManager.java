package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.ToDoList;
import ba.unsa.etf.rpr.exceptions.PlanerException;

import java.util.ArrayList;
import java.util.List;

public class ToDoListManager {

    public List<ToDoList> getAll() throws PlanerException {
        return DaoFactory.toDoListDao().getAll();
    }

    public void delete(int id) throws PlanerException{
        DaoFactory.toDoListDao().delete(id);
    }

    public ToDoList getById(int id) throws PlanerException {
        return DaoFactory.toDoListDao().getById(id);
    }

    public void update(ToDoList u) throws PlanerException {
        DaoFactory.toDoListDao().update(u);
    }

    public ToDoList add(ToDoList u) throws PlanerException{
        return DaoFactory.toDoListDao().add(u);
    }

    public ToDoList getToDoItemByTaskID (int id) throws PlanerException {
        return DaoFactory.toDoListDao().getToDoListItemByTaskID(id);
    }

    public ArrayList<ToDoList> getAllToDoTasksFromUser (int id) throws PlanerException {
        return DaoFactory.toDoListDao().getAllTODOTasksFromUser(id);
    }
}
