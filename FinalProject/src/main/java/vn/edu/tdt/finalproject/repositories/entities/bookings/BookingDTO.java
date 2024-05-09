package vn.edu.tdt.finalproject.repositories.entities.bookings;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookingDTO {

    private String id;
    private int purpose;
    private Date createdDate;
    private String estateId;
    private String customerId;
    private int status;
}
