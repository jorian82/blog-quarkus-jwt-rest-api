package mappers;

import entities.User;
import models.UserDTO;
import org.bson.types.ObjectId;

/**
 * Created by jra, SSDE Inc
 * on Mon, Apr 22 2024
 * at 11:16, blog-api
 */
public class UserMapper {
    public static User dtoToEntity(UserDTO dto) {
        User user = new User();

        if (dto == null) {
            return null;
        }

        if (dto.getId() != null) {
            user.id = new ObjectId(dto.getId());
        }
        if (dto.getUsername() != null) {
            user.username = dto.getUsername();
        }
        if (dto.getPassword() != null) {
            user.password = dto.getPassword();
        }
        if (dto.getEmail() != null) {
            user.email = dto.getEmail();
        }
        if (dto.getRole() != null) {
            user.role = dto.getRole();
        }

        return user;
    }

    public static UserDTO entityToDto(User user) {
        UserDTO dto = new UserDTO();

        if (user == null) {
            return null;
        }

        dto.setId(user.id.toString());
        dto.setUsername(user.username);
        dto.setEmail(user.email);

        return dto;
    }
}
