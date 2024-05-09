package vn.edu.tdt.finalproject.repositories.entities.users;

public class UserError extends Exception {

    public UserError() {
    }

    public UserError(String message) {
        super(message);
    }

    public UserError(String message, Throwable cause) {
        super(message, cause);
    }
}
