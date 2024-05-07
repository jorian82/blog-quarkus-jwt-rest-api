package services;

import entities.Comment;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import mappers.CommentMapper;
import models.CommentDTO;
import org.bson.types.ObjectId;
import responses.CommentResponseRest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jra, SSDE Inc
 * on Sun, Apr 21 2024
 * at 23:52, blog-api
 */
@ApplicationScoped
public class CommentService implements ICommentService{

    @Override
    public Response saveComment(CommentDTO dto) {
        CommentResponseRest result = new CommentResponseRest();
        List<CommentDTO> dtos = new ArrayList<>();

        try {
            Comment comment = CommentMapper.dtoToComment(dto);
            if(comment != null) {
                comment.persist();
                dtos.add(CommentMapper.commentToDto(comment));
                result.getCommentResponse().setComments(dtos);
                result.setMetadata(Response.Status.OK.name(), Response.Status.OK.getStatusCode(), Response.Status.Family.SUCCESSFUL.name());
            }
        } catch ( Exception e ) {
            result.setMetadata(Response.Status.INTERNAL_SERVER_ERROR.name(), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.Family.SERVER_ERROR.name());
            e.getStackTrace();
            return Response.serverError().entity(result).entity(e.getMessage()).build(); //(e.getMessage()).build();
        }

        return Response.ok(result).build();
    }

    @Override
    public Response editComment(CommentDTO dto) {
        CommentResponseRest result = new CommentResponseRest();
        List<CommentDTO> dtos = new ArrayList<>();

        try{
            Comment comment = CommentMapper.dtoToComment(dto);
            if(comment != null) {
                comment.update();
                dtos.add(CommentMapper.commentToDto(comment));
                result.getCommentResponse().setComments(dtos);
                result.setMetadata(Response.Status.OK.name(), Response.Status.OK.getStatusCode(), Response.Status.Family.SUCCESSFUL.name());
            }
        } catch ( Exception e ) {
            result.setMetadata(Response.Status.INTERNAL_SERVER_ERROR.name(), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.Family.SERVER_ERROR.name());
            e.getStackTrace();
            return Response.serverError().entity(result).entity(e.getMessage()).build(); //(e.getMessage()).build();
        }

        return Response.ok(result).build();
    }

    @Override
    public Response deleteComment(String id) {
        CommentResponseRest result = new CommentResponseRest();

        try {
            Comment.deleteById(id);
            result.setMetadata(Response.Status.OK.name(), Response.Status.OK.getStatusCode(), Response.Status.Family.SUCCESSFUL.name());
        } catch ( Exception e ) {
            result.setMetadata(Response.Status.INTERNAL_SERVER_ERROR.name(), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.Family.SERVER_ERROR.name());
            e.getStackTrace();
            return Response.serverError().entity(result).entity(e.getMessage()).build(); //(e.getMessage()).build();
        }

        return Response.ok(result).build();
    }
}
