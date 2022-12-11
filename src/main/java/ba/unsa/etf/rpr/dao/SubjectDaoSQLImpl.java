package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Subject;

import java.sql.Connection;
import java.sql.DriverManager;
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
        return null;
    }

    @Override
    public Subject add(Subject item) {
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
