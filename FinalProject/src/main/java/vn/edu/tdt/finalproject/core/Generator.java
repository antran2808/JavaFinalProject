package vn.edu.tdt.finalproject.core;

import java.sql.Date;
import java.util.UUID;

public final class Generator {

    public static String generateUUID() {
        UUID uuid = UUID.randomUUID();
        Date date = new Date(System.currentTimeMillis());
        String _date = date.toString();
        String uuidStr = (_date + uuid.toString())
                .replaceAll("-", "")
                .replaceAll("\\D", "")
                .substring(0, 20); // Ensure the length does not exceed UUID length
        return uuidStr;
    }
}
