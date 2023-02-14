package ba.unsa.etf.rpr.dao;

public class DaoFactory {

    private static final UserDao userDao = UserDaoSQLImpl.getInstance();
    private static final TaskDao taskDao = TaskDaoSQLImpl.getInstance();
    private static final SubjectDao subjectDao = SubjectDaoSQLImpl.getInstance();

    private DaoFactory(){
    }

    public static UserDao userDao(){
        return userDao;
    }

    public static TaskDao taskDao(){
        return taskDao;
    }

    public static SubjectDao subjectDao(){
        return subjectDao;
    }

}


