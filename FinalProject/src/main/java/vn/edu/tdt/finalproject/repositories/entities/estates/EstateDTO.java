package vn.edu.tdt.finalproject.repositories.entities.estates;

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
public class EstateDTO {

    private String id;
    private String name;
    private String images;
    private String description;
    private Date publicDate;
    private String ownerId;
    private int sellPrice;
    private int rentPrice;
    private String address;
    private int status;
}
