package fr.INFO921;

import java.io.IOException;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author francoiscaillet
 */
public class AllColisServlet extends HttpServlet {
    
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
        Collection<Colis> colis = colisDao.getAllColis();
        request.setAttribute("colisList", colis);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

}
