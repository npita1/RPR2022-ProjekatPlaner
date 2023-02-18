package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Subject;
import ba.unsa.etf.rpr.domain.ToDoList;
import ba.unsa.etf.rpr.exceptions.PlanerException;

import java.sql.ResultSet;
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
        return item;
    }
}
