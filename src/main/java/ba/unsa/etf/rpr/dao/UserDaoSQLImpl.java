package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;

import java.util.List;
import java.sql.*;

public class UserDaoSQLImpl implements UserDao {

    private Connection connection;

    public UserDaoSQLImpl(){
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7583326", "sql7583326", "ddNCxnl689");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getById(int id) {
        String query = "SELECT * FROM users WHERE id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { // result set is iterator.
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getString("gender"));
                rs.close();
                return user;
            } else {
                return null; // if there is no elements in the result set return null
            }
        } catch (SQLException e) {
            e.printStackTrace(); // poor error handling
        }
        return null;
    }

    @Override
    public User add(User item) {
        String insert = "INSERT INTO users (username,password,gender) values (?, ?,?);";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, item.getUsername());
            stmt.setString(2, item.getPassword());
            stmt.setString(3, item.getGender());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next(); // we know that there is one key
            item.setId(rs.getInt(1)); //set id to return it back
            return item;
        } catch (SQLException e) {
            e.printStackTrace(); // poor error handling
        }
        return null;
    }

    @Override
    public User update(User item) {
        String insert = "UPDATE users SET username = ?, password=?, gender=? WHERE id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, item.getUsername());
            stmt.setObject(2, item.getPassword());
            stmt.setObject(3, item.getGender());
            stmt.setObject(4, item.getId());
            stmt.executeUpdate();
            return item;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete(int id) {
        String insert = "DELETE FROM users WHERE id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getByUsername(String username) {
        return null;
    }
}
