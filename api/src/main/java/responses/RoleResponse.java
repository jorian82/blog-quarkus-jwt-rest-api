package responses;

import models.RoleDTO;

import java.util.List;

/**
 * Created by jra, SSDE Inc.
 * on Tuesday, Apr 23, 2024
 * at 0:09 for blog-api project
 */
public class RoleResponse {
    private List<RoleDTO> roles;

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }
}
