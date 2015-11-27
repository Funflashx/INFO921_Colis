/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.INFO921;

import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author francoiscaillet
 */
@Local
public interface ColisSessionBeanLocal {
    
    public void myTimer();
    void enregistrementColis(Colis colis);
    void supprimerColis(Colis colis);
    void updateColis(Colis colis);
    Colis findColisById(Integer id);
    Collection<Colis> findByEtat(Etat etat);
    Collection<Colis>  getAllColis();
}
