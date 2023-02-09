package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Subject;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.PlanerException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.Map;
import java.util.Properties;

public class UserDaoSQLImpl extends AbstractDao<User> implements UserDao {

    private static UserDaoSQLImpl instance = null;

    private UserDaoSQLImpl() {
        super("users");
    }

    public static UserDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new UserDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public User row2object(ResultSet rs) throws PlanerException {
        return null;
    }

    @Override
    public Map<String, Object> object2row(User object) {
        return null;
    }

    @Override
    public User getByUsername(String username) {
        return null;
    }

    @Override
    public boolean updateTokens(User item, Integer value) {
        return false;
    }



    /*public UserDaoSQLImpl() throws IOException {
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
