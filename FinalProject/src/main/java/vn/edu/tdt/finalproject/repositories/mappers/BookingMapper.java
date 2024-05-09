package vn.edu.tdt.finalproject.repositories.mappers;

import vn.edu.tdt.finalproject.repositories.entities.bookings.Booking;
import vn.edu.tdt.finalproject.repositories.entities.bookings.BookingDTO;
import vn.edu.tdt.finalproject.repositories.enums.BookingPurposeEnum;
import vn.edu.tdt.finalproject.repositories.enums.BookingStatusEnum;

public class BookingMapper implements IEntityMapper<BookingDTO, Booking> {

    @Override
    public BookingDTO convertEntity(Booking entity) throws Exception {
        BookingDTO res = new BookingDTO();
        res.setId(entity.getId());
        res.setCreatedDate(entity.getCreatedDate());
        res.setEstateId(entity.getEstateId());
        res.setCustomerId(entity.getCustomerId());
        res.setPurpose(entity.getPurpose().ordinal());
        res.setStatus(entity.getStatus().ordinal());
        return res;
    }

    @Override
    public Booking convertEntityDTO(BookingDTO entity) throws Exception {
        Booking res = new Booking();
        res.setId(entity.getId());
        res.setCreatedDate(entity.getCreatedDate());
        res.setEstateId(entity.getEstateId());
        res.setCustomerId(entity.getCustomerId());
        res.setPurpose(BookingPurposeEnum.get(entity.getPurpose()));
        res.setStatus(BookingStatusEnum.get(entity.getStatus()));
        return res;
    }
}
