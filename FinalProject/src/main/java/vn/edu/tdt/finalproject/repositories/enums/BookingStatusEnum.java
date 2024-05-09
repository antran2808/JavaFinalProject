package vn.edu.tdt.finalproject.repositories.enums;

public enum BookingStatusEnum {
    UNREAD,
    ACCEPTED,
    DECLINED,
    COMPLETED,
    DELETED;

    public static BookingStatusEnum get(int index) {
        switch (index) {
            case 0:
                return UNREAD;
            case 1:
                return ACCEPTED;
            case 2:
                return DECLINED;
            case 3:
                return COMPLETED;
            case 4:
                return DELETED;
            default:
                return UNREAD;
        }
    }
}
