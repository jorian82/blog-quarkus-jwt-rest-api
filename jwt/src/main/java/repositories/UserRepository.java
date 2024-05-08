package repositories;

import entities.User;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * Created by jra, SSDE, Inc
 * on Tue May 07, 2024
 * at 9:51 AM. blog-rest-api
 */
@ApplicationScoped
public class UserRepository implements PanacheMongoRepository<User> {
}
