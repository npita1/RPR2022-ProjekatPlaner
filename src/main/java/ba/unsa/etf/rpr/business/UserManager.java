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

    public User add(User q) throws PlanerException{
        return DaoFactory.userDao().add(q);
    }

    public boolean validateUser(User user) throws PlanerException{
        if(DaoFactory.userDao().validUsername(user) && DaoFactory.userDao().validPassword(user))
            return true;
        return false;
    }


}
