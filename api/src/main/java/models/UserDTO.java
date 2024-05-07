package models;

/**
 * Created by jra, SSDE Inc
 * on Sun, Apr 21 2024
 * at 21:07, blog-api
 */
public class UserDTO {
    private String id;
    private String username;
    private String password;
    private String email;
    private String role;

    public String getId() {
        return id;
    }

    public UserDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getRole() {
        return role;
    }

    public UserDTO setRole(String role) {
        this.role = role;
        return this;
    }
}
