package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.UserDao;
import ba.unsa.etf.rpr.dao.UserDaoSQLImpl;
import ba.unsa.etf.rpr.domain.User;


public class App
{
    public static void main( String[] args )
    {
        UserDao dao = new UserDaoSQLImpl();
        User user1 = new User("PrviClan","1234","M");

        /*// add testiranje
        dao.add(user1);
        System.out.println(user1.getId());
        System.out.println(user1.getUsername());
        System.out.println(user1.getPassword());
        System.out.println(user1.getGender());
        System.out.println(user1.getTokens());*/

        /*// update testiranje
        user1.setUsername("NoviName");
        user1.setGender("F");
        user1.setId(12);
        dao.update(user1);
        System.out.println(user1.getId());
        System.out.println(user1.getUsername());
        System.out.println(user1.getPassword());
        System.out.println(user1.getGender());
        System.out.println(user1.getTokens());*/

        /*// update 2 testiranje
        User help = new User();
        help.setUsername("NajnovijiUsername");
        help.setPassword("najboljipass");
        help.setGender(user1.getGender());
        help.setId(user1.getId());
        help.setTokens(user1.getTokens());
        dao.update(help);*/

        /*User user2;
        user2 = dao.getById(12);
        System.out.println(user2.getId());
        System.out.println(user2.getUsername());
        System.out.println(user2.getPassword());
        System.out.println(user2.getGender());
        System.out.println(user2.getTokens());*/

        /*// testiranje delete
        dao.delete(12);*/


    }
}
