package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Subject;
import ba.unsa.etf.rpr.domain.User;

import java.sql.*;
import java.util.List;

public class SubjectDaoSQLImpl implements SubjectDao{

    private Connection connection;

    public SubjectDaoSQLImpl() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7583326", "sql7583326", "ddNCxnl689");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Subject getById(int id) {
        String query = "SELECT * FROM subjects WHERE id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { // result set is iterator.
                Subject subject = new Subject();
                subject.setId(rs.getInt("id"));
                subject.setName(rs.getString("name"));
                subject.setColor(rs.getString("color"));
                subject.setAcronym(rs.getString("acronym"));
                subject.setUserId(rs.getInt("user_id"));
                rs.close();
                return subject;
            } else {
                return null; // if there is no elements in the result set return null
            }
        } catch (SQLException e) {
            e.printStackTrace(); // poor error handling
        }
        return null;
    }

    @Override
    public Subject add(Subject item) {
        String insert = "INSERT INTO subjects (name,acronym,color,user_id) values (?, ?,?);";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, item.getName());
            stmt.setString(2, item.getAcronym());
            stmt.setString(3, item.getColor());
            stmt.setInt(4, item.getUserId());
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
    public Subject update(Subject item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Subject> getAll() {
        return null;
    }
}
