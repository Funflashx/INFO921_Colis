/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.INFO921;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author francoiscaillet
 */
@WebServlet(name = "TrackingServlet")
public class TrackingServlet extends HttpServlet {
    
    @EJB
    private ColisSessionBeanLocal colisDao;
    
    @EJB
    private PositionSessionBeanLocal positionDao;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        Integer id_colis = Integer.parseInt(request.getParameter( "colis_id" ));
        Colis colis = colisDao.findColisById(id_colis);
        request.setAttribute("colis", colis);
         if(action != null){
            if (action.equalsIgnoreCase("Valider")) {
                BigDecimal latitude = new BigDecimal(request.getParameter("latitude"));
                BigDecimal longitude = new BigDecimal(request.getParameter("longitude"));
                Position position = new Position(latitude, longitude);
                //position.setColis(colis);
                if (request.getParameter("etat").equals("en_attente")){
                    colis.setEtatCourant(Etat.en_attente);
                }else if (request.getParameter("etat").equals("en_acheminement")){
                    colis.setEtatCourant(Etat.en_acheminement);
                }else if (request.getParameter("etat").equals("livre")){
                    colis.setEtatCourant(Etat.livre);
                }else if (request.getParameter("etat").equals("bloque")){
                    colis.setEtatCourant(Etat.bloque);
                }
                colis.addPosition(position);
                colisDao.enregistrementColis(colis);
                positionDao.enregistrementPosition(position);
                request.setAttribute("isValid", true);
            }
        }
        
        this.getServletContext().getRequestDispatcher("/track_colis.jsp").forward(request, response);
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
