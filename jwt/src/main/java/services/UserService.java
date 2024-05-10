package services;

import entities.User;
import io.quarkus.mongodb.panache.PanacheQuery;
import io.smallrye.jwt.build.Jwt;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import mappers.UserMapper;
import models.UserDTO;
import repositories.UserRepository;
import responses.TokenResponseRest;
import responses.UserResponseRest;

import java.util.*;

/**
 * Created by jra, SSDE Inc
 * on Mon, Apr 22 2024
 * at 12:22, blog-api
 */
@ApplicationScoped
public class UserService implements IUserService{

    @Inject
    UserRepository userRepository;

    @Override
    public Response login(String username, String password) {
        TokenResponseRest response = new TokenResponseRest();
        User logged = userRepository.find("username", username).firstResult();
        Set<String> roles = new HashSet<>(
                Arrays.asList("admin","creator")
        );

//        if (logged == null) {
//            response.setMetadata(Response.Status.NOT_FOUND.name(), Response.Status.NOT_FOUND.getStatusCode(), "Username/Password incorrect");
//            return Response.ok().entity(response).build();//.entity("Username/Password do not match any user").build();
//        } else {
//            roles = new HashSet<>(
//                    Arrays.asList(logged.role.split(","))
//            );
//        }

        long duration = System.currentTimeMillis()+3600;

        final String token = Jwt.issuer("www.ssde.com.mx")
                .subject("blog-api")
                .groups(roles)
                .expiresAt(duration)
                .sign();

        try {
            response.getTokenResponse().setToken(token);
            response.setMetadata(Response.Status.OK.name(), Response.Status.OK.getStatusCode(), Response.Status.Family.SUCCESSFUL.name());
        } catch (Exception e) {
            response.setMetadata(Response.Status.INTERNAL_SERVER_ERROR.name(), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.getMessage());
            e.getStackTrace();
            return Response.serverError().entity(response).build();
        }

        return Response.ok().entity(response).build();
    }

    @PermitAll
    @Override
    public Response logout() {
        return Response.ok().build();
    }

    @RolesAllowed({"admin", "creator"})
    @Override
    public Response changePassword(String username, String oldPassword, String newPassword) {
        return Response.ok().build();
    }

    @Override
    @RolesAllowed({"admin"})
    public Response addUser(UserDTO dto) {
        UserResponseRest result = new UserResponseRest();
        List<UserDTO> dtos = new ArrayList<>();

        try {
            User user = UserMapper.dtoToEntity(dto);
            if(user != null) {
                userRepository.persist(user);
                dtos.add(UserMapper.entityToDto(user));
                result.getUserResponse().setUsers(dtos);
                result.setMetadata(Response.Status.CREATED.name(), Response.Status.CREATED.getStatusCode(), Response.Status.CREATED.getReasonPhrase());
            } else {
                result.setMetadata(Response.Status.BAD_REQUEST.name(), Response.Status.BAD_REQUEST.getStatusCode(), "request body can't be null");
            }
        } catch (Exception e) {
            result.setMetadata(Response.Status.INTERNAL_SERVER_ERROR.name(), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
            e.getStackTrace();
            return Response.serverError().entity(result).entity(e.getMessage()).build();
        }
        return Response.ok().build();
    }

    @Override
    @RolesAllowed({"admin"})
    public Response deleteUser(String id) {
        return null;
    }
}
