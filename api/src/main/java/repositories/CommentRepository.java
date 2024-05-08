package repositories;

import entities.Comment;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * Created by jra, SSDE, Inc
 * on Tue May 07, 2024
 * at 9:14 AM. blog-rest-api
 */
@ApplicationScoped
public class CommentRepository implements PanacheMongoRepository<Comment> {
}
