package vn.edu.tdt.finalproject.services;

public class BookingService {

    private static BookingService instance;

    private BookingService() {
    }

    public static BookingService getInstance() {
        return instance = instance == null ? new BookingService() : instance;
    }
}
