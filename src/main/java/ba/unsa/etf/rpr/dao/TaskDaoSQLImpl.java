package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Subject;
import ba.unsa.etf.rpr.domain.Task;
import ba.unsa.etf.rpr.exceptions.PlanerException;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TaskDaoSQLImpl extends AbstractDao<Task> implements TaskDao{
    private static TaskDaoSQLImpl instance = null;

    private TaskDaoSQLImpl() {
        super("tasks");
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
        try {
            Task u = new Task();
            u.setTaskText(rs.getString("task_text"));
            u.setDeadline(rs.getDate("deadline"));
            u.setSubjectId(rs.getInt("subject_id"));
            return u;
        } catch (Exception e) {
            throw new PlanerException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Task object) {
        Map<String, Object> item = new TreeMap<>();
        //item.put("id", object.getId());
        item.put("task_text", object.getTaskText());
        item.put("deadline", object.getDeadline());
        item.put("subject_id", object.getSubjectId());

        return item;
    }
}
