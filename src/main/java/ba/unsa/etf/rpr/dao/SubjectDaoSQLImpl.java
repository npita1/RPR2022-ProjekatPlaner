package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Subject;
import ba.unsa.etf.rpr.exceptions.PlanerException;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * MySQL implementation of the DAO
 * @author Naida Pita
 */
public class SubjectDaoSQLImpl extends AbstractDao<Subject> implements SubjectDao {

    private static SubjectDaoSQLImpl instance = null;

    private SubjectDaoSQLImpl() {
        super("subjects");
    }

    public static SubjectDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new SubjectDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public Subject row2object(ResultSet rs) throws PlanerException {
        try {
            Subject u = new Subject();
            u.setId(rs.getInt("id"));
            u.setName(rs.getString("name"));
            u.setAcronym(rs.getString("acronym"));
            u.setColor(rs.getString("color"));
            u.setUserId(rs.getInt("user_id"));
            u.setTaskNumber(rs.getInt("broj_taskova"));
            return u;
        } catch (Exception e) {
            throw new PlanerException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Subject object) {
        Map<String, Object> item = new TreeMap<>();
        //item.put("id", object.getId());
        item.put("name", object.getName());
        item.put("acronym", object.getAcronym());
        item.put("color", object.getColor());
        item.put("user_id", object.getUserId());
        //item.put("broj_taskova",object.getTaskNumber());
        return item;
    }

    @Override
    public Subject getSubjectByName(String name)throws PlanerException {
        return (Subject) executeQuery("SELECT * FROM subjects where name=?", new Object[]{name});
    }

    @Override
    public Subject getSubjectByAcronym(String acronym) throws PlanerException {
        return (Subject) executeQuery("SELECT * FROM subjects where acronym=?", new Object[]{acronym});
    }

    @Override
    public List<Subject> getSubjectsFromUserID(int id) throws PlanerException {
        ArrayList<Subject> subjects = (ArrayList<Subject>) executeQuery("SELECT subjects.*,count(tasks.id) \"broj_taskova\" FROM subjects LEFT JOIN tasks ON subjects.id=tasks.subject_id  WHERE user_id=? GROUP BY subjects.id ",new Object[]{id});
        return subjects;
    }

    @Override
    public boolean duplicateSubjectForOneUser(int userID, String subjectName) throws PlanerException {
        ArrayList<Subject> subjects = (ArrayList<Subject>) executeQuery("SELECT * FROM subjects WHERE user_id=? AND name=?", new Object[]{userID,subjectName});
        if(subjects.size() != 0) return true;
        return false;
    }

    @Override
    public boolean duplicateAcronymForUser(int userID, String acronym) throws PlanerException {
        ArrayList<Subject> subjects = (ArrayList<Subject>) executeQuery("SELECT * FROM subjects WHERE user_id=? AND acronym=?", new Object[]{userID,acronym});
        if(subjects.size() != 0) return true;
        return false;
    }

    @Override
    public ArrayList<Subject> getSubjectFromNameAndUserID(String name, int id) throws PlanerException {
        return (ArrayList<Subject>) executeQuery("SELECT * FROM subjects WHERE name=? AND user_id=?", new Object[]{name,id});
    }

    @Override
    public int getNumberOfTasks(int id) throws PlanerException {
        ArrayList<Subject> sub = (ArrayList<Subject>) executeQuery("SELECT COUNT(*) FROM subjects INNER JOIN tasks ON subjects.id=? AND subjects.id = tasks.subject_id",new Object[]{id});
        return sub.size();
     }


}
