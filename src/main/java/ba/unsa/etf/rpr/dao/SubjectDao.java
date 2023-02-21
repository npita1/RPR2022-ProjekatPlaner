package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Subject;
import ba.unsa.etf.rpr.exceptions.PlanerException;

import java.util.ArrayList;
import java.util.List;

/**
 * Dao interface for Subject domain bean
 *
 * @author Naida Pita
 */
public interface SubjectDao extends Dao<Subject>{

    /**
     * Returns a subject with the given name
     * @param name
     * @return
     * @throws PlanerException
     */
    Subject getSubjectByName(String name) throws PlanerException;

    /**
     * Returns a subject with the given acronym
     * @param acronym
     * @return
     * @throws PlanerException
     */
    Subject getSubjectByAcronym(String acronym) throws PlanerException;

    /**
     * Returns all subjects from given user, id
     * @param id
     * @return
     * @throws PlanerException
     */
    List<Subject> getSubjectsFromUserID(int id) throws PlanerException;

    /**
     * Checks for duplicate subject name of one user
     * @param userID
     * @param subjectName
     * @return
     * @throws PlanerException
     */
    boolean duplicateSubjectForOneUser(int userID, String subjectName) throws PlanerException;

    /**
     * 
     * @param userID
     * @param acronym
     * @return
     * @throws PlanerException
     */
    boolean duplicateAcronymForUser(int userID,String acronym) throws PlanerException;

    ArrayList<Subject> getSubjectFromNameAndUserID(String name, int id) throws PlanerException;

}
