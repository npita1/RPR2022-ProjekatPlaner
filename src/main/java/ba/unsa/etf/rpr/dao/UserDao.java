package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;

import java.util.List;

public interface UserDao extends Dao<User>{
    User getByUsername(String username);
}
