package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class ToDoList implements Idable {

    private int id;
    private int taskId;


    public ToDoList(int id, int taskId) {
        this.id = id;
        this.taskId = taskId;
    }

    public ToDoList() {
    }


    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return "subject";
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDoList list = (ToDoList) o;
        return id == list.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,taskId);
    }
}
