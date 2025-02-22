package rut.miit.views;

public class UserProfileView {

    private String username;
    private String email;
    private String fullname;

    public UserProfileView() {}

    public UserProfileView(String username, String email, String fullname ) {
        this.username = username;
        this.email = email;
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullname;
    }
    public void setFullName(String fullname) {
        this.fullname = fullname;
    }
}