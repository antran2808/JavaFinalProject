package vn.edu.tdt.finalproject.repositories.mappers;

import vn.edu.tdt.finalproject.repositories.entities.users.User;
import vn.edu.tdt.finalproject.repositories.entities.users.UserDTO;
import vn.edu.tdt.finalproject.repositories.enums.RoleEnum;
import vn.edu.tdt.finalproject.repositories.enums.UserStatusEnum;

public class UserMapper implements IEntityMapper<UserDTO, User> {

    @Override
    public UserDTO convertEntity(User entity) throws Exception {
        UserDTO res = new UserDTO();
        res.setId(entity.getId());
        res.setEmail(entity.getEmail());
        res.setUsername(entity.getUsername());
        res.setFirstName(entity.getFirstName());
        res.setLastName(entity.getLastName());
        res.setPassword(entity.getPassword());
        res.setPhone(entity.getPhone());
        res.setRoleId(entity.getRole().ordinal());
        res.setStatus(entity.getStatus().ordinal());
        return res;
    }

    @Override
    public User convertEntityDTO(UserDTO entity) throws Exception {
        User res = new User();
        res.setId(entity.getId());
        res.setEmail(entity.getEmail());
        res.setUsername(entity.getUsername());
        res.setFirstName(entity.getFirstName());
        res.setLastName(entity.getLastName());
        res.setPassword(entity.getPassword());
        res.setPhone(entity.getPhone());
        res.setRole(RoleEnum.get(entity.getRoleId()));
        res.setStatus(UserStatusEnum.get(entity.getStatus()));
        return res;
    }
}
