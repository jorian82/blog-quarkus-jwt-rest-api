package mappers;

import entities.Comment;
import models.CommentDTO;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

/**
 * Created by jra, SSDE Inc
 * on Sun, Apr 21 2024
 * at 21:43, blog-api
 */
public class CommentMapper {
    public static CommentDTO commentToDto(Comment comment) {
        CommentDTO dto = new CommentDTO();

        if (comment == null) {
            return null;
        }

        dto.setId(comment.id.toString());
        dto.setAuthor(comment.author);
        dto.setComment(comment.comment);
        dto.setCreatedAt(comment.createdAt);
        dto.setUpdatedAt(comment.updatedAt);
        dto.setPost_id(comment.post_id);
        dto.setVotes(comment.votes);

        return dto;
    }

    public static Comment dtoToComment(CommentDTO dto) {
        Comment comment = new Comment();

        if (dto == null) {
            return null;
        }

        if(dto.getId()!=null) {
            comment.id = new ObjectId(dto.getId());
        }
        if(dto.getAuthor()!=null) {
            comment.author = dto.getAuthor();
        }
        if(dto.getComment()!=null) {
            comment.comment = dto.getComment();
        }
        if(dto.getPost_id()!=null) {
            comment.post_id = dto.getPost_id();
        }
        if(dto.getVotes()!=null) {
            comment.votes = dto.getVotes();
        }
        comment.createdAt = dto.getCreatedAt()!=null?dto.getCreatedAt():LocalDateTime.now();
        comment.updatedAt = LocalDateTime.now();

        return comment;
    }
}
