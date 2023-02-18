package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class ToDoList implements Idable {

    private int id;
    private int taskId;
    private String taskText;
    private String subjectAcronym;
    private int userId;


    public ToDoList(int userID,int taskId, String taskText, String subjectAcronym) {
        this.taskId = taskId;
        this.taskText = taskText;
        this.subjectAcronym = subjectAcronym;
        this.userId = userID;
    }

    public ToDoList(int userID,int taskId) {
        this.taskId = taskId;
        this.userId = userID;
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

    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    public String getSubjectAcronym() {
        return subjectAcronym;
    }

    public void setSubjectAcronym(String subjectAcronym) {
        this.subjectAcronym = subjectAcronym;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
