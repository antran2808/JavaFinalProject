package vn.edu.tdt.finalproject.repositories.entities.estates;

public class EstateError extends Exception {

    public EstateError() {
    }

    public EstateError(String message) {
        super(message);
    }

    public EstateError(String message, Throwable cause) {
        super(message, cause);
    }
}
