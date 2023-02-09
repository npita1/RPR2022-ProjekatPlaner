package ba.unsa.etf.rpr.dao;

public class DaoFactory {

    private static final UserDao userDao = UserDaoSQLImpl.getInstance();
    private static final TaskDao taskDao = TaskDaoSQLImpl.getInstance();
    private static final SubjectDao subjectDao = SubjectDaoSQLImpl.getInstance();

    private DaoFactory(){
    }

    public static UserDao categoryDao(){
        return userDao;
    }

    public static TaskDao quoteDao(){
        return taskDao;
    }

    public static SubjectDao quoteHistoryDao(){
        return subjectDao;
    }

}


