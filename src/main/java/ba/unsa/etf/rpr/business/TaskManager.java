package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Task;
import ba.unsa.etf.rpr.exceptions.PlanerException;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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

    public boolean validateEnteredDate (Date date) throws PlanerException, ParseException {
        return DaoFactory.taskDao().checkDate(date);
    }

}
