package fr.INFO921;

import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author francoiscaillet
 */
@Local
public interface ColisSessionBeanLocal {

    void enregistrementColis(Colis colis);
    void supprimerColis(Colis colis);
    void updateColis(Colis colis);
    Colis findColisById(Integer id);
    Collection<Colis> findByEtat(Etat etat);
    Collection<Colis>  getAllColis();
}
