package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Task;
import ba.unsa.etf.rpr.exceptions.PlanerException;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public interface TaskDao extends Dao<Task>{
    public ArrayList<Task> getTasksBySubjectID (int id) throws PlanerException;
}
