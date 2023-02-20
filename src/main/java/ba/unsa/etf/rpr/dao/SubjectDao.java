package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Subject;
import ba.unsa.etf.rpr.exceptions.PlanerException;

import java.util.ArrayList;
import java.util.List;

public interface SubjectDao extends Dao<Subject>{
    Subject getSubjectByName(String name) throws PlanerException;
    Subject getSubjectByAcronym(String acronym) throws PlanerException;
    Subject getSubjectByColor(String color) throws PlanerException;

    List<Subject> getSubjectsFromUserID(int id) throws PlanerException;
    //List<Subject> getSubjectsFromUsername (String username) throws PlanerException;

    boolean duplicateSubjectForOneUser(int userID, String subjectName) throws PlanerException;
    boolean duplicateAcronymForUser(int userID,String acronym) throws PlanerException;

    ArrayList<Subject> getSubjectFromNameAndUserID(String name, int id) throws PlanerException;

}
