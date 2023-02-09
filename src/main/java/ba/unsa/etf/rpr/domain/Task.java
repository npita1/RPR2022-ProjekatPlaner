package ba.unsa.etf.rpr.domain;

import java.util.Date;
import java.util.Objects;

public class Task implements Idable{
    private Integer id;
    private String taskText;
    private Date deadline;
    private Integer subjectId;

    public Task(){}
    public Task(String task_text, Date deadline, Integer subject_id) {
        this.taskText = task_text;
        this.deadline = deadline;
        this.subjectId = subject_id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String task_text) {
        this.taskText = task_text;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subject_id) {
        this.subjectId = subject_id;
    }

    @Override
    public String toString() {
        return "task";
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskText, deadline);
    }
}
