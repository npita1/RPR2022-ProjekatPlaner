package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Subject;
import ba.unsa.etf.rpr.domain.Task;
import ba.unsa.etf.rpr.exceptions.PlanerException;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

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
            u.setId(rs.getInt("id"));
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

    @Override
    public ArrayList<Task> getTasksBySubjectID(int id) throws PlanerException {
        return (ArrayList<Task>) executeQuery("SELECT * FROM tasks WHERE subject_id=?",new Object[]{id});
    }

    @Override
    public boolean checkDate(Date date) throws PlanerException, ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate = dateFormat.format(new Date());
        Date d = dateFormat.parse(stringDate);

        if(date != null) {
            if (date.before(d)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean hasAnyTasks(int id) throws PlanerException {
        ArrayList<Task> list = getTasksBySubjectID(id);
        if(list.size() == 0) return false;
        return true;
    }


}
