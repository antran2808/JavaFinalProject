package vn.edu.tdt.finalproject.repositories.entities.bookings;

public class BookingError extends Exception {

    public BookingError() {
    }

    public BookingError(String message) {
        super(message);
    }

    public BookingError(String message, Throwable cause) {
        super(message, cause);
    }
}
