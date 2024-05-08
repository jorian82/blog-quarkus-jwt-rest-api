package resources;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import models.CommentDTO;
import services.ICommentService;

/**
 * Created by jra, SSDE Inc
 * on Sun, Apr 21 2024
 * at 11:51 PM, blog-api
 */
@Path("/api/v1/comment")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
    @Inject
    ICommentService commentService;

    @POST
    @RolesAllowed({"admin","creator"})
    public Response add(CommentDTO dto) {
        return commentService.saveComment(dto);
    }

    @DELETE
    @RolesAllowed({"admin"})
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        return commentService.deleteComment(id);
    }
}
