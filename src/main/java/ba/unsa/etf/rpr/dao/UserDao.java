package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.PlanerException;

import java.util.List;

public interface UserDao extends Dao<User>{
    User getByUsername(String username) throws PlanerException;
    boolean updateTokens(User item, Integer value);

    boolean validUsername(String username) throws PlanerException;

    boolean validPassword(String username, String password) throws PlanerException;
}
