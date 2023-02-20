package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Subject;
import ba.unsa.etf.rpr.exceptions.PlanerException;

import java.util.ArrayList;
import java.util.List;

/**
 * Business logic layer for managing Subjects
 *
 * @author Naida Pita
 */
public class SubjectManager {

    public List<Subject> getAll() throws PlanerException {
        return DaoFactory.subjectDao().getAll();
    }

    public void delete(int id) throws PlanerException{
        DaoFactory.subjectDao().delete(id);
    }

    public Subject getById(int id) throws PlanerException {
        return DaoFactory.subjectDao().getById(id);
    }

    public void update(Subject u) throws PlanerException {
        DaoFactory.subjectDao().update(u);
    }

    public Subject add(Subject u) throws PlanerException{
        return DaoFactory.subjectDao().add(u);
    }

    public ArrayList<Subject> getSubjectsFromUser(int id) throws PlanerException {
        return (ArrayList<Subject>) DaoFactory.subjectDao().getSubjectsFromUserID(id);
    }

    public Subject getSubjectByName(String name) throws PlanerException {
        return DaoFactory.subjectDao().getSubjectByName(name);
    }

    public boolean hasDuplicateSubjectUser(int userID,String subjectName) throws PlanerException {
        return DaoFactory.subjectDao().duplicateSubjectForOneUser(userID,subjectName);
    }

    public boolean hasDuplicateAcronymUser (int userID, String acronym) throws PlanerException {
        return DaoFactory.subjectDao().duplicateAcronymForUser(userID,acronym);
    }

}
