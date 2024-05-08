package services;

import jakarta.ws.rs.core.Response;
import models.UserDTO;

/**
 * Created by jra, SSDE Inc
 * on Mon, Apr 22 2024
 * at 12:19, blog-api
 */
public interface IUserService {

    public Response login(String username, String password);

    public Response logout();

    public Response changePassword(String username, String oldPassword, String newPassword);

    public Response addUser(UserDTO user);

    public Response deleteUser(String id);
}
