package vn.edu.tdt.finalproject.repositories.enums;

public enum RoleEnum {
    ADMIN,
    SELLER,
    CUSTOMER,
    GUEST;

    public static RoleEnum get(int index) {
        switch (index) {
            case 0:
                return ADMIN;
            case 1:
                return SELLER;
            case 2:
                return CUSTOMER;
            default:
                return GUEST;
        }
    }
}
