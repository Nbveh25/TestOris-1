package model;

public class Log {
    private Integer id;
    private String login;

    public Log(Integer id, String login) {
        this.id = id;
        this.login = login;
    }

    public Log(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
