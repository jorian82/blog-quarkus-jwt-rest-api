package services;

import entities.Role;
import jakarta.ws.rs.core.Response;

/**
 * Created by jra, SSDE Inc.
 * on Tuesday, Apr 23, 2024
 * at 0:03 for blog-api project
 */
public interface IRoleService {

    public Response addRole(Role role);

    public Response updateRole(Role role);

    public Response deleteRole(String id);

    public Response getAllRoles();
}
