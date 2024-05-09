package vn.edu.tdt.finalproject.repositories.enums;

public enum EstateStatusEnum {
    ACTIVE,
    DELETED,
    RENTED,
    SOLD;

    public static EstateStatusEnum get(int index) {
        switch (index) {
            case 0:
                return ACTIVE;
            case 1:
                return DELETED;
            case 2:
                return RENTED;
            case 3:
                return SOLD;
            default:
                return ACTIVE;
        }
    }
}
