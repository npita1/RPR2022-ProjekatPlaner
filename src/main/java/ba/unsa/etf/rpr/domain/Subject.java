package ba.unsa.etf.rpr.domain;

public class Subject {
    private Integer id;
    private String name;
    private String acronym;
    private String color;
    private Integer userId;

    public Subject() {}

    public Subject(String name, String acronym, String color) {
        this.name = name;
        this.acronym = acronym;
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
