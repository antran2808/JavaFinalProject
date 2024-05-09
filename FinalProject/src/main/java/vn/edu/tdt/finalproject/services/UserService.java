package vn.edu.tdt.finalproject.services;

import java.util.List;
import vn.edu.tdt.finalproject.repositories.UserRepository;
import vn.edu.tdt.finalproject.repositories.entities.users.UserDTO;
import vn.edu.tdt.finalproject.repositories.entities.users.UserError;

public class UserService {

    private static UserService instance;

    private UserService() {
    }

    public static UserService getInstance() {
        return instance = instance == null ? new UserService() : instance;
    }

    public UserDTO addNewUser(UserDTO user) throws Exception {
        UserRepository repo = new UserRepository();
        if (findByEmail(user.getEmail()) != null) {
            throw new UserError("This email already exist in the system");
        }
        repo.post(user);
        return findByEmail(user.getEmail());
    }

    public UserDTO findByEmail(String email) throws Exception {
        UserRepository repo = new UserRepository();
        List<UserDTO> userList = repo.get();
        for (UserDTO user : userList) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public UserDTO checkLogin(String email, String password) throws Exception {
        UserDTO user = findByEmail(email);
        if (findByEmail(email) == null) {
            throw new UserError("This email does not exist in the system");
        }
        if (user.getPassword().equals(password)) {
            return user;
        } else {
            throw new UserError("Wrong password");
        }
    }
}
