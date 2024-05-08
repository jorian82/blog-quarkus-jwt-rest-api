package entities;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * Created by jra, SSDE Inc
 * on Sun, Apr 21 2024
 * at 17:54, blog-api
 */
public class Role {
    public ObjectId id;
    public String name;
    public String description;

//    public static List<Role> findAllRoles() {
//        return PanacheMongoEntityBase.findAll().stream().map(role -> (Role) role).toList();
//    }
//
//    public static Role findByName(String name) {
//        return PanacheMongoEntityBase.find("name", name).firstResult();
//    }
}
