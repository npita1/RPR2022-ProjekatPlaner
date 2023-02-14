package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Subject;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.PlanerException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.sql.*;

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
        try {
            User u = new User();
            u.setId(rs.getInt("id"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setGender(rs.getString("gender"));
            u.setTokens(rs.getInt("tokens"));
            return u;
        } catch (Exception e) {
            throw new PlanerException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(User object) {
        Map<String, Object> item = new TreeMap<>();
        item.put("id", object.getId());
        item.put("username", object.getUsername());
        item.put("password", object.getPassword());
        item.put("gender", object.getGender());
        item.put("tokens", object.getTokens());
        return item;
    }

    @Override
    public User getByUsername(String username) throws PlanerException{
        return executeQueryUnique("SELECT * FROM users WHERE username= ", new Object[]{username});
    }

    @Override
    public boolean updateTokens(User item, Integer value) {
        return false;
    }

    @Override
    public  boolean validUsername(String username) throws PlanerException{
        ArrayList<User> users = (ArrayList<User>) executeQuery("SELECT * FROM users WHERE username=?", new Object[]{username});
        //System.out.println(users.toString());
        if(users.size() == 1) return true;
        return false;
    }

    @Override
    public boolean validPassword(String username, String password) throws PlanerException {
        ArrayList<User> users = (ArrayList<User>) executeQuery("SELECT * FROM users WHERE username=? AND password=?", new Object[]{username,password});
        //System.out.println(users.toString());
        if(users.size() == 1) return true;
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
