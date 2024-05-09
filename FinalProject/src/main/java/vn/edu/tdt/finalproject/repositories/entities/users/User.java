package vn.edu.tdt.finalproject.repositories.entities.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import vn.edu.tdt.finalproject.repositories.enums.RoleEnum;
import vn.edu.tdt.finalproject.repositories.enums.UserStatusEnum;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

    private String id;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private RoleEnum role;
    private UserStatusEnum status;
}
