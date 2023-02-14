package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.dao.UserDao;
import ba.unsa.etf.rpr.dao.UserDaoSQLImpl;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.PlanerException;

import java.io.IOException;

public class App {

    public static void main( String[] args ) throws IOException, PlanerException {
        /*UserDao dao = new UserDaoSQLImpl();
        User user1 = new User("PrviClan","1234","M");

        //test baza
        dao.add(user1);
        System.out.println(user1.getId());
        System.out.println(user1.getUsername());
        System.out.println(user1.getPassword());
        System.out.println(user1.getGender());
        System.out.println(user1.getTokens());*/

        UserDao userDao = DaoFactory.userDao();
        System.out.println(userDao.getAll().toString());
    }
}

