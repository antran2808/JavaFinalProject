package vn.edu.tdt.finalproject.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import vn.edu.tdt.finalproject.repositories.entities.estates.Estate;
import vn.edu.tdt.finalproject.repositories.entities.estates.EstateDTO;
import vn.edu.tdt.finalproject.repositories.mappers.EstateMapper;
import vn.edu.tdt.finalproject.services.EstateService;

@WebServlet(name = "DetailController", urlPatterns = {"/estate"})
public class DetailController extends HttpServlet {

    private static final String SUCCESS = "detail.jsp";
    private static final String ERROR = "detail.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = ERROR;
        try {
            String id = request.getParameter("id");
            EstateService eService = EstateService.getInstance();
            EstateDTO e = eService.findById(id);
            EstateMapper mapper = new EstateMapper();
            Estate estate = mapper.convertEntityDTO(e);
            System.out.println(estate);
            request.setAttribute("ESTATE", estate);
            url = SUCCESS;
        } catch (Exception ex) {
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
        return "Short description";
    }// </editor-fold>

}
