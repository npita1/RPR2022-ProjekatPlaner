package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Task;
import ba.unsa.etf.rpr.exceptions.PlanerException;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class TaskDaoSQLImpl extends AbstractDao<Task> implements TaskDao{
    private static TaskDaoSQLImpl instance = null;

    private TaskDaoSQLImpl() {
        super("subjects");
    }

    public static TaskDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new TaskDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public Task row2object(ResultSet rs) throws PlanerException {
        return null;
    }

    @Override
    public Map<String, Object> object2row(Task object) {
        return null;
    }
}
