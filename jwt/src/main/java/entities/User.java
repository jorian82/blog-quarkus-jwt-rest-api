package entities;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.types.ObjectId;

/**
 * Created by jra, SSDE Inc
 * on Sun, Apr 21 2024
 * at 17:54, blog-api
 */
public class User {
    public ObjectId id;
    public String username;
    public String password;
    public String email;
    public String role;

//    public static User findByUsername(String username) {
//        return PanacheMongoEntityBase.find("username", username).firstResult();
//    }
//
//    public static User findByEmail(String email) {
//        return PanacheMongoEntityBase.find("email", email).firstResult();
//    }
//
//    public static User findByRole(String role) {
//        return PanacheMongoEntityBase.find("role", role).firstResult();
//    }
}
