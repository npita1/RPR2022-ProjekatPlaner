package ba.unsa.etf.rpr.domain;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String spol;
    private int tokeni;

    public User(){};
    public User(String username, String password, String spol) {
        this.username = username;
        this.password = password;
        this.spol = spol;
        this.tokeni = 0;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getTokeni() {
        return tokeni;
    }

    public void setTokeni(int tokeni) {
        this.tokeni = tokeni;
    }

    public String getSpol() {
        return spol;
    }

    public void setSpol(String spol) {
        this.spol = spol;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return this.username;
    }

}
