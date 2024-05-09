package vn.edu.tdt.finalproject.repositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.edu.tdt.finalproject.core.DBContext;
import vn.edu.tdt.finalproject.core.Generator;
import vn.edu.tdt.finalproject.repositories.entities.bookings.BookingDTO;

public class BookingRepository implements IRepository<BookingDTO> {

    private static final String GET
            = "SELECT [id],[purpose],[created_date]"
            + "      ,[estate_id],[customer_id],[status]"
            + "FROM [dbo].[Booking]";
    private static final String POST
            = "INSERT INTO [dbo].[Booking]"
            + "           ([id],[purpose],[estate_id],[customer_id])"
            + "     VALUES (?,?,?,?,?)";
    private static final String PUT
            = "UPDATE [dbo].[Booking]"
            + "   SET [purpose] = ?"
            + "      ,[created_date] = ?"
            + "      ,[estate_id] = ?"
            + "      ,[customer_id] = ?"
            + "      ,[status] = ?"
            + " WHERE [id] = ?";
    private static final String DELETE
            = "UPDATE [dbo].[Booking]"
            + "   SET [status] = 4"
            + " WHERE [id] = ?";
    private final DBContext context = DBContext.getInstance();

    private void logError(String message, Exception ex) {
        Logger.getLogger(EstateRepository.class.getName())
                .log(Level.SEVERE, message, ex);
    }

    @Override
    public List<BookingDTO> get() throws Exception {
        Connection conn = context.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<BookingDTO> list = new ArrayList<>();
        try {
            stm = conn.prepareStatement(GET);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                int purpose = rs.getInt("purpose");
                Date createdDate = rs.getDate("created_date");
                String estateId = rs.getString("estate_id");
                String customerId = rs.getString("customer_id");
                int status = rs.getInt("status");
                list.add(new BookingDTO(id, purpose, createdDate, estateId, customerId, status));
            }
        } catch (SQLException ex) {
            logError("Exception found on get method", ex);
        } finally {
            context.closeResult(rs);
            context.closeStatement(stm);
            context.closeConnection();
        }
        return list;
    }

    @Override
    public BookingDTO post(BookingDTO item) throws Exception {
        Connection conn = context.getConnection();
        PreparedStatement stm = null;
        try {
            stm = conn.prepareStatement(POST);
            item.setId(Generator.generateUUID());
            stm.setString(1, item.getId());
            stm.setInt(2, item.getPurpose());
            stm.setString(3, item.getEstateId());
            stm.setString(4, item.getCustomerId());
            boolean res = stm.executeUpdate() > 0;
            item = res ? item : null;
        } catch (SQLException ex) {
            logError("Exception found on post method", ex);
            return null;
        } finally {
            context.closeStatement(stm);
            context.closeConnection();
        }
        return item;
    }

    @Override
    public BookingDTO put(BookingDTO item) throws Exception {
        Connection conn = context.getConnection();
        PreparedStatement stm = null;
        try {
            stm = conn.prepareStatement(PUT);
            stm.setInt(1, item.getPurpose());
            stm.setString(2, item.getEstateId());
            stm.setString(3, item.getCustomerId());
            stm.setInt(4, item.getStatus());
            stm.setString(5, item.getId());
            boolean res = stm.executeUpdate() > 0;
            item = res ? item : null;
        } catch (SQLException ex) {
            logError("Exception found on post method", ex);
            return null;
        } finally {
            context.closeStatement(stm);
            context.closeConnection();
        }
        return item;
    }

    @Override
    public BookingDTO delete(BookingDTO item) throws Exception {
        Connection conn = context.getConnection();
        PreparedStatement stm = null;
        try {
            stm = conn.prepareStatement(DELETE);
            stm.setString(1, item.getId());
            boolean res = stm.executeUpdate() > 0;
            item = res ? item : null;
        } catch (SQLException ex) {
            logError("Exception found on post method", ex);
            return null;
        } finally {
            context.closeStatement(stm);
            context.closeConnection();
        }
        return item;
    }
}
