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
public class Comment {
    public ObjectId id;
    public String comment;
    public String author;
    public String post_id;
    public Integer votes;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;

//    public static List<Comment> findByPostId(String post_id) {
//        return list("post_id", post_id);
//    }
//
//    public static List<Comment> findByAuthor(String author) {
//        return list("author", author);
//    }
}
