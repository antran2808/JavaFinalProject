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
import vn.edu.tdt.finalproject.repositories.entities.estates.EstateDTO;

public class EstateRepository implements IRepository<EstateDTO> {

    private static final String GET
            = "SELECT [id],[name],[images],[description],[public_date]"
            + "      ,[owner_id],[sell_price],[rent_price],[addresss],[status]"
            + "  FROM [dbo].[Estates]";
    private static final String POST
            = "INSERT INTO [dbo].[Estates]\n"
            + "           ([id],[name],[images],[description]"
            + "           ,[owner_id],[sell_price],[rent_price],[addresss])"
            + "     VALUES (?,?,?,?,?,?,?,?)";
    private static final String PUT
            = "UPDATE [dbo].[Estates]"
            + "   SET [name] = ?"
            + "      ,[images] = ?"
            + "      ,[description] = ?"
            + "      ,[owner_id] = ?"
            + "      ,[sell_price] = ?"
            + "      ,[rent_price] = ?"
            + "      ,[addresss] = ?"
            + "      ,[status] = ?"
            + " WHERE [id] = ?";
    private static final String DELETE
            = "UPDATE [dbo].[Estates]"
            + "   SET [status] = 1"
            + " WHERE [id] = ?";
    private final DBContext context = DBContext.getInstance();

    private void logError(String message, Exception ex) {
        Logger.getLogger(EstateRepository.class.getName())
                .log(Level.SEVERE, message, ex);
    }

    @Override
    public List<EstateDTO> get() throws Exception {
        Connection conn = context.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EstateDTO> list = new ArrayList<>();
        try {
            stm = conn.prepareStatement(GET);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id").trim();
                String name = rs.getString("name").trim();
                String images = rs.getString("images").trim();
                String description = rs.getString("description").trim();
                Date publicDate = rs.getDate("public_date");
                String ownerId = rs.getString("owner_id").trim();
                int sellPrice = rs.getInt("sell_price");
                int rentPrice = rs.getInt("rent_price");
                String address = rs.getString("addresss").trim();
                int status = rs.getInt("status");
                list.add(new EstateDTO(id, name, images, description, publicDate, ownerId, sellPrice, rentPrice, address, status));
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
    public EstateDTO post(EstateDTO item) throws Exception {
        Connection conn = context.getConnection();
        PreparedStatement stm = null;
        try {
            stm = conn.prepareStatement(POST);
            item.setId(Generator.generateUUID());
            stm.setString(1, item.getId());
            stm.setString(2, item.getName());
            stm.setString(3, item.getImages());
            stm.setString(4, item.getDescription());
            stm.setString(5, item.getOwnerId());
            stm.setInt(6, item.getSellPrice());
            stm.setInt(7, item.getRentPrice());
            stm.setString(8, item.getAddress());
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
    public EstateDTO put(EstateDTO item) throws Exception {
        Connection conn = context.getConnection();
        PreparedStatement stm = null;
        try {
            stm = conn.prepareStatement(PUT);
            stm.setString(1, item.getName());
            stm.setString(2, item.getImages());
            stm.setString(3, item.getDescription());
            stm.setString(4, item.getOwnerId());
            stm.setInt(5, item.getSellPrice());
            stm.setInt(6, item.getRentPrice());
            stm.setString(7, item.getAddress());
            stm.setInt(8, item.getStatus());
            stm.setString(9, item.getId());
            boolean res = stm.executeUpdate() > 0;
            item = res ? item : null;
        } catch (SQLException ex) {
            logError("Exception found on put method", ex);
            return null;
        } finally {
            context.closeStatement(stm);
            context.closeConnection();
        }
        return item;
    }

    @Override
    public EstateDTO delete(EstateDTO item) throws Exception {
        Connection conn = context.getConnection();
        PreparedStatement stm = null;
        try {
            stm = conn.prepareStatement(DELETE);
            stm.setString(1, item.getId());
            boolean res = stm.executeUpdate() > 0;
            item = res ? item : null;
        } catch (SQLException ex) {
            logError("Exception found on put method", ex);
            return null;
        } finally {
            context.closeStatement(stm);
            context.closeConnection();
        }
        return item;
    }

}
