package vn.edu.tdt.finalproject.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.tdt.finalproject.repositories.entities.users.User;
import vn.edu.tdt.finalproject.repositories.entities.users.UserDTO;
import vn.edu.tdt.finalproject.repositories.mappers.UserMapper;
import vn.edu.tdt.finalproject.services.UserService;

@WebServlet(name = "SignupController", urlPatterns = {"/signup"})
public class SignupController extends HttpServlet {

    private static final String SUCCESS = "home";
    private static final String ERROR = "signup.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = ERROR;
        try {
            UserService uService = UserService.getInstance();
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            int roleId = Integer.parseInt(request.getParameter("roleId"));
            UserDTO user = new UserDTO("", "", email, password,
                    "", "", "", roleId, 0);
            user = uService.addNewUser(user);
            UserMapper mapper = new UserMapper();
            User loginUser = mapper.convertEntityDTO(user);
            HttpSession session = request.getSession();
            session.setAttribute("LOGIN_USER", loginUser);
            url = SUCCESS;
        } catch (Exception ex) {
            request.setAttribute("SIGNUP_ERROR", ex.getMessage());
            url = ERROR;
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Handle the sign up of users";
    }
}
