package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Subject;
import ba.unsa.etf.rpr.domain.Task;
import ba.unsa.etf.rpr.exceptions.PlanerException;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    public List<Task> getAll() throws PlanerException {
        return DaoFactory.taskDao().getAll();
    }

    public void delete(int id) throws PlanerException{
        DaoFactory.taskDao().delete(id);
    }

    public Task getById(int id) throws PlanerException {
        return DaoFactory.taskDao().getById(id);
    }

    public void update(Task u) throws PlanerException {
        DaoFactory.taskDao().update(u);
    }

    public Task add(Task u) throws PlanerException{
        return DaoFactory.taskDao().add(u);
    }


    public ArrayList<Task> getTasksWithSubjectID (int id) throws PlanerException {
        return DaoFactory.taskDao().getTasksBySubjectID(id);
    }


}
