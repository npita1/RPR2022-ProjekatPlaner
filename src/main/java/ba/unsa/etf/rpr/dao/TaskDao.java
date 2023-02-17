package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Task;
import ba.unsa.etf.rpr.exceptions.PlanerException;
import javafx.collections.ObservableList;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public interface TaskDao extends Dao<Task>{
    public ArrayList<Task> getTasksBySubjectID (int id) throws PlanerException;

    boolean checkDate(Date date) throws PlanerException, ParseException;
}
