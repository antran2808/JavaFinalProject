package vn.edu.tdt.finalproject.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import vn.edu.tdt.finalproject.repositories.entities.estates.Estate;
import vn.edu.tdt.finalproject.repositories.entities.estates.EstateDTO;
import vn.edu.tdt.finalproject.repositories.enums.EstateStatusEnum;
import vn.edu.tdt.finalproject.repositories.mappers.EstateMapper;
import vn.edu.tdt.finalproject.services.EstateService;

public class HomeController extends HttpServlet {

    private static final String HOME = "index.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = HOME;
        try {
            EstateService eService = EstateService.getInstance();
            List<EstateDTO> eList = eService.getAllEstate();
            List<Estate> estateList = new ArrayList<>();
            EstateMapper eMapper = new EstateMapper();
            for (EstateDTO e : eList) {
                Estate estate = eMapper.convertEntityDTO(e);
                if (estate.getStatus() == EstateStatusEnum.ACTIVE) {
                    estateList.add(estate);
                }
            }
            request.setAttribute("ESTATE_LIST", estateList);
        } catch (Exception ex) {
            log("Internal server error: " + ex.toString());
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
