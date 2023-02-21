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
     * Checks if the deadline date is valid
     * @param date
     * @return
     * @throws PlanerException
     * @throws ParseException
     */
    boolean checkDate(Date date) throws PlanerException, ParseException;

    /**
     * Checks if subject has any tasks
     * @param id
     * @return
     * @throws PlanerException
     */
    boolean hasAnyTasks(int id) throws PlanerException;

    ArrayList<Task> searchTasksByTaskName(String taskName, int subjectID) throws PlanerException;



}
