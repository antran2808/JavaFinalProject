package vn.edu.tdt.finalproject.repositories.enums;

public enum UserStatusEnum {
    ACTIVE,
    DEACTIVE,
    DELETED,
    BANNED;

    public static UserStatusEnum get(int index) {
        switch (index) {
            case 0:
                return ACTIVE;
            case 1:
                return DEACTIVE;
            case 2:
                return DELETED;
            case 3:
                return BANNED;
            default:
                return ACTIVE;
        }
    }
}
