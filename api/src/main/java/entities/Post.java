package entities;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by jra, SSDE Inc
 * on Sun, Apr 21 2024
 * at 17:54, blog-api
 */
public class Post extends PanacheMongoEntity {
    public String title;
    public String content;
    public String author;
    public Integer votes;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;

    public static List<Post> findAllPosts() {
        return findAll().stream().map(item -> (Post) item).toList();
    }

    public static Post findById(String id) {
        return find("id", new ObjectId(id)).firstResult();
    }

    public static List<Post> findByAuthor(String author) {
        return list("author", author);
    }

    public static void deletePost(String id) {
        delete("id", new ObjectId(id));
    };
}
