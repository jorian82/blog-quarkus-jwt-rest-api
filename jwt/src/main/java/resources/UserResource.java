package resources;

import jakarta.annotation.security.PermitAll;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import models.UserDTO;
import services.IUserService;
import services.UserService;

/**
 * Created by jra, SSDE Inc.
 * on Tuesday, May 07, 2024
 * at 23:21 for blog-jwt-rest-api project
 */
@Path("/api/v1/jwt")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    IUserService userService;

    @POST
    @Path("/login")
    @PermitAll
    public Response login(UserDTO dto) {
        return userService.login(dto.getUsername(), dto.getPassword());
    }
}
