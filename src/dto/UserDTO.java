package dto;

public class UserDTO {

    private String login;
    private String email;
    private String password;
    private String confirmPassword;

    public UserDTO(String login, String email, String password, String confirmPassword) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public UserDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
