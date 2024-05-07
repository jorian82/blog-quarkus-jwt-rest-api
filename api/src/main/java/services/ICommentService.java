package services;

import entities.Comment;
import jakarta.ws.rs.core.Response;
import models.CommentDTO;

/**
 * Created by jra, SSDE Inc
 * on Mon, Apr 22 2024
 * at 10:56, blog-api
 */
public interface ICommentService {

    public Response saveComment(CommentDTO dto);

    public Response deleteComment(String id);

    public Response editComment(CommentDTO dto);
}
