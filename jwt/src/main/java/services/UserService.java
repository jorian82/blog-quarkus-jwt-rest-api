package services;

import entities.User;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import mappers.UserMapper;
import models.UserDTO;
import repositories.UserRepository;
import responses.UserResponseRest;

import java.util.ArrayList;
import java.util.List;

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
    @PermitAll
    public Response login(String username, String password) {
        User logged = (User) userRepository.find("username", username);
        return Response.ok().build();
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
