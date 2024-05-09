package vn.edu.tdt.finalproject.repositories.enums;

public enum BookingPurposeEnum {
    BUYING,
    VISITING,
    RENTING;

    public static BookingPurposeEnum get(int index) {
        switch (index) {
            case 0:
                return BUYING;
            case 1:
                return VISITING;
            case 2:
                return RENTING;
            default:
                return VISITING;
        }
    }
}
