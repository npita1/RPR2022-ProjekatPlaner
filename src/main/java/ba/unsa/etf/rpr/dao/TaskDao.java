package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Task;
import ba.unsa.etf.rpr.exceptions.PlanerException;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Dao interface for Task domain bean
 *
 * @author Naida Pita
 */
public interface TaskDao extends Dao<Task>{

    /**
     * Returns all tasks for the given subject by id
     * @param id
     * @return
     * @throws PlanerException
     */
    ArrayList<Task> getTasksBySubjectID (int id) throws PlanerException;

    /**
     * 
     * @param date
     * @return
     * @throws PlanerException
     * @throws ParseException
     */
    boolean checkDate(Date date) throws PlanerException, ParseException;

    boolean hasAnyTasks(int id) throws PlanerException;

}
