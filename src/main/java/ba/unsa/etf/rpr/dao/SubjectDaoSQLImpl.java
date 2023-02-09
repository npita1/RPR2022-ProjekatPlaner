package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Subject;
import ba.unsa.etf.rpr.exceptions.PlanerException;

import java.sql.ResultSet;
import java.util.Map;

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
        return null;
    }

    @Override
    public Map<String, Object> object2row(Subject object) {
        return null;
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
