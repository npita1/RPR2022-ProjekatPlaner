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
        String query = "INSERT INTO users (username,password,gender) values (?, ?,?);";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setString(1, item.getUsername());
            stmt.setString(2, item.getPassword());
            stmt.setString(3, item.getGender());
            stmt.executeUpdate(); // moras ovo da napises da bi se upisalo u bazu
            return item;
        } catch (SQLException e) {
            e.printStackTrace(); // poor error handling
        }
        return null;
    }

    @Override
    public User update(User item) {
        return null;
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User searchByUsername(String username) {
        return null;
    }
}
