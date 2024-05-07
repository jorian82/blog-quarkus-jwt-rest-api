package mappers;

import entities.Role;
import models.RoleDTO;
import org.bson.types.ObjectId;

/**
 * Created by jra, SSDE Inc
 * on Mon, Apr 22 2024
 * at 12:12, blog-api
 */
public class RoleMapper {

    public static RoleDTO entityToDTO(Role role) {

        RoleDTO dto = new RoleDTO();

        if (role == null) {
            return null;
        }

        dto.setId(role.id.toString());
        dto.setName(role.name);
        dto.setDescription(role.description);

        return dto;
    }

    public static Role dtoToEntity(RoleDTO dto) {
        Role role = new Role();

        if (dto == null) {
            return null;
        }

        if(dto.getId() != null) {
            role.id = new ObjectId(dto.getId());
        }
        if(dto.getName() != null) {
            role.name = dto.getName();
        }
        if(dto.getDescription() != null) {
            role.description = dto.getDescription();
        }

        return role;
    }
}
