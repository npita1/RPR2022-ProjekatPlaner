package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.PlanerException;

import java.util.List;


public class UserManager {

    public List<User> getAll() throws PlanerException {
        return DaoFactory.userDao().getAll();
    }

    public void delete(int id) throws PlanerException{
        DaoFactory.userDao().delete(id);
    }

    public User getById(int id) throws PlanerException{
        return DaoFactory.userDao().getById(id);
    }

    public void update(User u) throws PlanerException{
        DaoFactory.userDao().update(u);
    }

    public User add(User u) throws PlanerException{
        return DaoFactory.userDao().add(u);
    }

    public boolean validateUsername(String username) throws PlanerException{
        return DaoFactory.userDao().validUsername(username);
    }

    public boolean validatePassword(String username,String password) throws PlanerException{
        return DaoFactory.userDao().validPassword(username,password);
    }

    public boolean validateNewUsernameExist (String username) throws PlanerException {
        return DaoFactory.userDao().validNewUsernameExist(username);
    }

    public boolean validateNewUsernameLength (String username) throws PlanerException {
        return DaoFactory.userDao().validNewUsernameLength(username);
    }

    public boolean validatePasswordLength(String password) throws PlanerException {
        return DaoFactory.userDao().validPasswordLength(password);
    }

    public boolean validateConfirmPassword(String password, String confirmPassword) throws PlanerException {
        return DaoFactory.userDao().validConfirmPassword(password, confirmPassword);
    }

    public User getUserByUsername(String username) throws PlanerException {
        return DaoFactory.userDao().getByUsername(username);
    }

}
