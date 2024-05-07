package entities;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

/**
 * Created by jra, SSDE Inc
 * on Sun, Apr 21 2024
 * at 17:54, blog-api
 */
public class User extends PanacheMongoEntity {
    public String username;
    public String password;
    public String email;
    public String role;

    public static User findByUsername(String username) {
        return find("username", username).firstResult();
    }

    public static User findByEmail(String email) {
        return find("email", email).firstResult();
    }

    public static User findByRole(String role) {
        return find("role", role).firstResult();
    }
}
