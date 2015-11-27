package fr.INFO921;

import java.io.IOException;
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
@WebServlet(name = "ColisSelvet")
public class SaveColisServlet extends HttpServlet {
    
    @EJB
    private ColisSessionBeanLocal colisDao;

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
        
        if(action != null){
            if (action.equalsIgnoreCase("Valider")) {
                float poids = Float.parseFloat(request.getParameter("poids"));
                int valeur = Integer.parseInt(request.getParameter("valeur"));
                String origine = request.getParameter("origine");
                String destination = request.getParameter("destination");
                Colis colis = new Colis(poids, valeur, origine, destination);
                colisDao.enregistrementColis(colis);
                request.setAttribute("isValid", true);
            }
        }
        
        request.getRequestDispatcher("save_colis.jsp").forward(request, response);

    }
}
