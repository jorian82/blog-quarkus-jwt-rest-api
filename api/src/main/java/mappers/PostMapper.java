package mappers;

import entities.Post;
import models.PostDTO;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

/**
 * Created by jra, SSDE Inc
 * on Sun, Apr 21 2024
 * at 21:10, blog-api
 */
public class PostMapper {
    public static PostDTO postToDTO(Post post) {
        PostDTO dto = new PostDTO();

        if (post == null) {
            return null;
        }

        dto.setId(post.id.toString());
        dto.setVotes(post.votes);
        dto.setTitle(post.title);
        dto.setAuthor(post.author);
        dto.setContent(post.content);
        dto.setCreatedAt(post.createdAt);
        dto.setUpdatedAt(post.updatedAt);

        return dto;
    }

    public static Post dtoToPost(PostDTO dto) {
        Post post = new Post();

        if (dto == null) {
            return null;
        }

        if(dto.getId() != null) {
            post.id = new ObjectId(dto.getId());
        }
        return getPost(post, dto);
    }

    public static Post updateEntity(Post post, PostDTO dto) {
        if(dto == null) {
            return post;
        }

        if(post == null) {
            return null;
        }

        return getPost(post, dto);
    }

    private static Post getPost(Post post, PostDTO dto) {
        if(dto.getTitle()!=null) {
            post.title = dto.getTitle();
        }
        if(dto.getVotes()!=null) {
            post.votes = dto.getVotes();
        }
        if(dto.getAuthor()!=null) {
            post.author = dto.getAuthor();
        }
        if(dto.getContent()!=null) {
            post.content = dto.getContent();
        }
        post.createdAt = dto.getCreatedAt()!=null?dto.getCreatedAt(): LocalDateTime.now();
        post.updatedAt = LocalDateTime.now();

        return post;
    }
}
