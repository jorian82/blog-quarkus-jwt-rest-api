package repositories;

import entities.Post;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * Created by jra, SSDE, Inc
 * on Tue May 07, 2024
 * at 9:09 AM. blog-rest-api
 */
@ApplicationScoped
public class PostRepository implements PanacheMongoRepository<Post> {
}
