package responses;

/**
 * Created by jra, SSDE Inc.
 * on Tuesday, Apr 23, 2024
 * at 0:10 for blog-api project
 */
public class RoleResponseRest extends ResponseRest{
    private RoleResponse roleResponse = new RoleResponse();

    public RoleResponse getRoleResponse() {
        return roleResponse;
    }

    public void setRoleResponse(RoleResponse roleResponse) {
        this.roleResponse = roleResponse;
    }
}
