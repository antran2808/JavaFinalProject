package vn.edu.tdt.finalproject.repositories.entities.bookings;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import vn.edu.tdt.finalproject.repositories.enums.BookingPurposeEnum;
import vn.edu.tdt.finalproject.repositories.enums.BookingStatusEnum;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Booking {

    private String id;
    private BookingPurposeEnum purpose;
    private Date createdDate;
    private String estateId;
    private String customerId;
    private BookingStatusEnum status;
}
