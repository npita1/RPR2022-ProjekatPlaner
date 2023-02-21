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

    
    List<Subject> getSubjectsFromUserID(int id) throws PlanerException;

    boolean duplicateSubjectForOneUser(int userID, String subjectName) throws PlanerException;
    boolean duplicateAcronymForUser(int userID,String acronym) throws PlanerException;

    ArrayList<Subject> getSubjectFromNameAndUserID(String name, int id) throws PlanerException;

}
