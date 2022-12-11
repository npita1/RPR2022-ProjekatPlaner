package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.UserDao;
import ba.unsa.etf.rpr.dao.UserDaoSQLImpl;
import ba.unsa.etf.rpr.domain.User;


public class App
{
    public static void main( String[] args )
    {
        UserDao dao = new UserDaoSQLImpl();
        User user = new User("ime","1234","M");
        User k = dao.add(user);
        System.out.println(user);
    }
}
