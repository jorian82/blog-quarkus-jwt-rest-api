package resources;

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import models.PostDTO;
import services.IPostService;

/**
 * Created by jra, SSDE Inc
 * on Sun, Apr 21 2024
 * at 23:24, blog-api
 */
@Path("/api/v1/post")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PostResource {
    @Inject
    IPostService postService;

    @GET
    @PermitAll
    public Response search() {
        return postService.getAllPosts();
    }

    @POST
    @RolesAllowed({"admin","creator"})
    public Response savePost(PostDTO dto) {
        return postService.savePost(dto);
    }

    @PATCH
    @RolesAllowed({"admin","creator"})
    public Response updatePost(PostDTO dto) {
        return postService.updatePost(dto);
    }

    @DELETE
    @RolesAllowed({"admin"})
    @Path("/{id}")
    public Response deletePost(@PathParam("id") String id) {
        return postService.deletePost(id);
    }
}
