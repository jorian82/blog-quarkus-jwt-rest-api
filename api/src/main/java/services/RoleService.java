package services;

import entities.Role;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import mappers.RoleMapper;
import models.RoleDTO;
import responses.RoleResponseRest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jra, SSDE Inc.
 * on Tuesday, Apr 23, 2024
 * at 0:06 for blog-api project
 */
@ApplicationScoped
public class RoleService implements IRoleService{
    @Override
    public Response addRole(Role role) {
        return null;
    }

    @Override
    public Response updateRole(Role role) {
        return null;
    }

    @Override
    public Response deleteRole(String id) {
        return null;
    }

    @Override
    public Response getAllRoles() {
        RoleResponseRest roleResponseRest = new RoleResponseRest();

        try {
            List<RoleDTO> dtos = Role.findAllRoles().stream().map(RoleMapper::entityToDTO).toList();
            roleResponseRest.getRoleResponse().setRoles(dtos);
            roleResponseRest.setMetadata(Response.Status.OK.name(), Response.Status.OK.getStatusCode(), Response.Status.Family.SUCCESSFUL.name());
        } catch ( Exception e ) {
            roleResponseRest.setMetadata(Response.Status.INTERNAL_SERVER_ERROR.name(), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
            e.getStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(roleResponseRest).entity(e.getMessage()).build();
        }

        return Response.ok().entity(roleResponseRest).build();
    }
}
