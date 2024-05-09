package vn.edu.tdt.finalproject.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.edu.tdt.finalproject.core.DBContext;
import vn.edu.tdt.finalproject.core.Generator;
import vn.edu.tdt.finalproject.repositories.entities.users.UserDTO;

public class UserRepository implements IRepository<UserDTO> {

    private static final String GET
            = "SELECT [id]"
            + "      ,[email]"
            + "      ,[username]"
            + "      ,[password]"
            + "      ,[first_name]"
            + "      ,[last_name]"
            + "      ,[phone]"
            + "      ,[role_id]"
            + "      ,[status]"
            + "  FROM [EstateManager].[dbo].[Users]";
    private static final String POST
            = "INSERT INTO [dbo].[Users]\n"
            + "           ([id]"
            + "           ,[email]"
            + "           ,[username]"
            + "           ,[password]"
            + "           ,[first_name]"
            + "           ,[last_name]"
            + "           ,[phone]"
            + "           ,[role_id])"
            + "     VALUES"
            + "           (? , ? , ? , ? , ? , ? , ? , ?)";
    private static final String PUT
            = "UPDATE [dbo].[Users]"
            + "   SET [email] = ?"
            + "      ,[username] = ?"
            + "      ,[password] = ?"
            + "      ,[first_name] = ?"
            + "      ,[last_name] = ?"
            + "      ,[phone] = ?"
            + "      ,[role_id] = ?"
            + "      ,[status] = ?"
            + " WHERE [id] = ?";
    private static final String DELETE
            = "UPDATE [dbo].[Users]"
            + "   SET [status] = 2"
            + " WHERE [id] = ?";
    private final DBContext context = DBContext.getInstance();

    private void logError(String message, Exception ex) {
        Logger.getLogger(UserRepository.class.getName())
                .log(Level.SEVERE, message, ex);
    }

    @Override
    public List<UserDTO> get() throws Exception {
        Connection conn = context.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<UserDTO> list = new ArrayList<>();
        try {
            stm = conn.prepareStatement(GET);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String phone = rs.getString("phone");
                int roleId = rs.getInt("role_id");
                int status = rs.getInt("status");
                list.add(new UserDTO(id, username, email, password,
                        firstName, lastName, phone, roleId, status));
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
    public UserDTO post(UserDTO item) throws Exception {
        Connection conn = context.getConnection();
        PreparedStatement stm = null;
        try {
            stm = conn.prepareStatement(POST);
            item.setId(Generator.generateUUID());
            stm.setString(1, item.getId());
            stm.setString(2, item.getEmail());
            stm.setString(3, item.getUsername());
            stm.setString(4, item.getPassword());
            stm.setString(5, item.getFirstName());
            stm.setString(6, item.getLastName());
            stm.setString(7, item.getPhone());
            stm.setString(8, Integer.toString(item.getRoleId()));
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
    public UserDTO put(UserDTO item) throws Exception {
        Connection conn = context.getConnection();
        PreparedStatement stm = null;
        try {
            stm = conn.prepareStatement(PUT);
            stm.setString(1, item.getEmail());
            stm.setString(2, item.getUsername());
            stm.setString(3, item.getPassword());
            stm.setString(4, item.getFirstName());
            stm.setString(5, item.getLastName());
            stm.setString(6, item.getPhone());
            stm.setString(7, Integer.toString(item.getRoleId()));
            stm.setString(8, Integer.toString(item.getStatus()));
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
    public UserDTO delete(UserDTO item) throws Exception {
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
