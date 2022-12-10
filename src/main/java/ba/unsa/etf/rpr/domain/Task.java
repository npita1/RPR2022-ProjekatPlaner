package ba.unsa.etf.rpr.domain;

import java.util.Date;

public class Task {
    private Integer id;
    private String task_text;
    private Date deadline;
    private Integer subject_id;

    public Task(){}
    public Task(String task_text, Date deadline, Integer subject_id) {
        this.task_text = task_text;
        this.deadline = deadline;
        this.subject_id = subject_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTask_text() {
        return task_text;
    }

    public void setTask_text(String task_text) {
        this.task_text = task_text;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Integer getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Integer subject_id) {
        this.subject_id = subject_id;
    }
}
