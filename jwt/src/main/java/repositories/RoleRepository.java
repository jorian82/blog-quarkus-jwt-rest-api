package repositories;

import entities.Role;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * Created by jra, SSDE, Inc
 * on Tue May 07, 2024
 * at 9:52 AM. blog-rest-api
 */
@ApplicationScoped
public class RoleRepository implements PanacheMongoRepository<Role> {
}
