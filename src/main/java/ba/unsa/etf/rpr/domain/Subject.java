package ba.unsa.etf.rpr.domain;

import java.util.Objects;

/**
 * bean for subject
 * @author Naida Pita
 */
public class Subject implements Idable {
    private Integer id;
    private String name;
    private String acronym;
    private String color;
    private Integer userId;

    public int getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    private Integer taskNumber = 0;

    public Subject() {}

    public Subject(String name, String acronym, String color,Integer userId, int taskNumber) {
        this.name = name;
        this.acronym = acronym;
        this.color = color;
        this.userId = userId;
        this.taskNumber = taskNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "subject";
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return id == subject.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, acronym, color);
    }

}
