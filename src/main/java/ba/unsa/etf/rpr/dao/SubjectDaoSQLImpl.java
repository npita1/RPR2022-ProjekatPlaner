package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Subject;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.PlanerException;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
        return item;
    }

    @Override
    public Subject getSubjectByName(String name)throws PlanerException {
        return executeQueryUnique("SELECT * FROM subjects where name=?", new Object[]{name});
    }

    @Override
    public Subject getSubjectByAcronym(String acronym) throws PlanerException {
        return executeQueryUnique("SELECT * FROM subjects where acronym=?", new Object[]{acronym});
    }

    @Override
    public Subject getSubjectByColor(String color) throws PlanerException {
        return executeQueryUnique("SELECT * FROM subjects where color=?", new Object[]{color});
    }

    @Override
    public List<Subject> getSubjectsFromUserID(int id) throws PlanerException {
        ArrayList<Subject> subjects = (ArrayList<Subject>) executeQuery("SELECT * FROM subjects WHERE user_id=?",new Object[]{id});
        return subjects;
    }

    @Override
    public List<Subject> getSubjectsFromUsername(String username) throws PlanerException {
        User user = (User) executeQuery("SELECT * FROM users WHERE username=?", new Object[]{username});
        ArrayList<Subject> subjects = (ArrayList<Subject>) executeQuery("SELECT * FROM subjects WHERE user_id=?", new Object[]{user.getId()});
        return subjects;
    }





    /*public SubjectDaoSQLImpl() throws IOException {
        Properties p = new Properties();
        InputStream is = new FileInputStream("db.properties");
        p.load(is);
        try {
            this.connection = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}
