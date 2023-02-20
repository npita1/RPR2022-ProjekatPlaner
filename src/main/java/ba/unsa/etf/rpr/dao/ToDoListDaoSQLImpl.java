package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.ToDoList;
import ba.unsa.etf.rpr.exceptions.PlanerException;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class ToDoListDaoSQLImpl extends AbstractDao<ToDoList> implements ToDoListDao{

    private static ToDoListDaoSQLImpl instance = null;

    private ToDoListDaoSQLImpl() {
        super("to_do_lists");
    }

    public static ToDoListDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new ToDoListDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public ToDoList row2object(ResultSet rs) throws PlanerException {
        try {
            ToDoList u = new ToDoList();
            u.setId(rs.getInt("id"));
            u.setTaskId(rs.getInt("task_id"));
            u.setUserId(rs.getInt("user_todo_id"));
            u.setTaskText(rs.getString("task_text_todo"));
            u.setSubjectAcronym(rs.getString("subject_acronym"));
            return u;
        } catch (Exception e) {
            throw new PlanerException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(ToDoList object) {
        Map<String, Object> item = new TreeMap<>();
        //item.put("id", object.getId());
        item.put("task_id", object.getTaskId());
        item.put("user_todo_id", object.getUserId());
        item.put("task_text_todo", object.getTaskText());
        item.put("subject_acronym", object.getSubjectAcronym());
        return item;
    }

    @Override
    public ToDoList getToDoListItemByTaskID(int id) throws PlanerException {
        return executeQueryUnique("SELECT * FROM to_do_lists WHERE task_id=?", new Object[]{id});
    }

    @Override
    public ArrayList<ToDoList> getAllTODOTasksFromUser(int id) throws PlanerException {
        return (ArrayList<ToDoList>) executeQuery("SELECT * FROM to_do_lists WHERE user_todo_id=?",new Object[]{id});
    }

    @Override
    public ArrayList<ToDoList> checkIfTaskIDExists(int taskId) throws PlanerException {
        return (ArrayList<ToDoList>) executeQuery("SELECT * FROM to_do_lists WHERE task_id=?", new Object[]{taskId});
    }

    @Override
    public ArrayList<ToDoList> getAllTODOBySubjectAcronym(String acronym) throws PlanerException {
        return (ArrayList<ToDoList>) executeQuery("SELECT * FROM to_do_lists WHERE subject_acronym=?", new Object[]{acronym});
    }

    @Override
    public boolean isSubjectOnTODO(String acronym) throws PlanerException {
        ArrayList<ToDoList> list = getAllTODOBySubjectAcronym(acronym);
        if(list.size() == 0) return false;
        return true;
    }

    @Override
    public boolean isTaskOnTODO(int id) throws PlanerException {
        ArrayList<ToDoList> list = (ArrayList<ToDoList>) executeQuery("SELECT * FROM to_do_lists WHERE task_id=?", new Object[]{id});
        if(list.size() == 0) return false;
        return true;
    }


}
