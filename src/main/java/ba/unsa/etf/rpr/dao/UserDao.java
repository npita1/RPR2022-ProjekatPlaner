package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.PlanerException;

/**
 * Dao interface for To do list item domain bean
 *
 * @author Naida Pita
 */
public interface UserDao extends Dao<User>{

    /**
     * Returns user from username
     * @param username
     * @return
     * @throws PlanerException
     */
    User getByUsername (String username) throws PlanerException;

    /**
     * Updates tokens
     * @param item
     * @param value
     * @return
     */
    User updateTokens(User item, Integer value);

    /**
     * Checks if the username is valid
     * @param username
     * @return
     * @throws PlanerException
     */
    boolean validUsername(String username) throws PlanerException;

    /**
     * Checks if the password is valid
     * @param username
     * @param password
     * @return
     * @throws PlanerException
     */
    boolean validPassword(String username, String password) throws PlanerException;

    /**
     * Checks if the new sign up username already exists
     * @param username
     * @return
     * @throws PlanerException
     */
    boolean validNewUsernameExist(String username) throws PlanerException;

    /**
     * Checks the length of the sign up username
     * @param username
     * @return
     * @throws PlanerException
     */
    boolean validNewUsernameLength (String username) throws PlanerException;

    /**
     * 
     * @param password
     * @return
     * @throws PlanerException
     */
    boolean validPasswordLength(String password) throws PlanerException;

    boolean validConfirmPassword(String password, String confirmPassword) throws PlanerException;

}
