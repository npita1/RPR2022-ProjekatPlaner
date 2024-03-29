package ba.unsa.etf.rpr.dao;

/**
 * Factory method for singleton implementation of DAOs
 *
 * @author Naida Pita
 */
public class DaoFactory {

    private static final UserDao userDao = UserDaoSQLImpl.getInstance();
    private static final TaskDao taskDao = TaskDaoSQLImpl.getInstance();
    private static final SubjectDao subjectDao = SubjectDaoSQLImpl.getInstance();
    private static final ToDoListDao toDoListDao = ToDoListDaoSQLImpl.getInstance();

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
    public static ToDoListDao toDoListDao(){
        return toDoListDao;
    }

}


