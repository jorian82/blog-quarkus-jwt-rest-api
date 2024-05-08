package responses;

import models.UserDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jra, SSDE Inc
 * on Mon, Apr 22 2024
 * at 12:26, blog-api
 */
public class UserResponse {

    private List<UserDTO> users = new ArrayList<>();

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
}
