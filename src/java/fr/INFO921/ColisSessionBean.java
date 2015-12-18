package fr.INFO921;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author francoiscaillet
 */
@Stateless
public class ColisSessionBean implements ColisSessionBeanLocal {
    
    
    private Logger logger = Logger.getLogger(getClass().getName());
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void enregistrementColis(Colis colis) {
        logger.log(Level.INFO, "Enregitrement du colis : {0}", colis.toString());
        if (colis.getId() == null) {
            logger.info("In save new colis");
            Position p = new Position(new BigDecimal(5.55), new BigDecimal(45.989));
            colis.addPosition(p);
            entityManager.persist(p);
            
            entityManager.persist(colis);
        }else {
            logger.info("In update colis");
            entityManager.merge(colis);
        }

    }

    @Override
    public void supprimerColis(Colis colis) {
       entityManager.remove(colis);
    }

    @Override
    public void updateColis(Colis colis) {
        Colis oldColis = findColisById(colis.getId());

        oldColis.setDestination(colis.getDestination());
        oldColis.setOrigine(colis.getOrigine());
        oldColis.setPoids(colis.getPoids());
        oldColis.setPositions(colis.getPositions());
        oldColis.setValeur(colis.getValeur());
        oldColis.setEtatCourant(colis.getEtatCourant());

        entityManager.persist(colis);
        entityManager.flush();
    }

    @Override
    public Collection<Colis> findByEtat(Etat etat) {
        Collection<Colis> colisList = null;
        try {
            colisList = entityManager.createNamedQuery(Colis.findByEtatCourant).getResultList();
        } catch (Exception e) {
            logger.info(e.toString());
            e.printStackTrace();
        }
        return colisList;
    }

    @Override
    public Collection<Colis> getAllColis() {
        Collection<Colis> colisList = null;
        try {
            colisList = entityManager.createNamedQuery(Colis.FIND_ALL_COLIS, Colis.class).getResultList();
        } catch (Exception e) {
            logger.info(e.toString());
            e.printStackTrace();
        }
        return colisList;
    }

    @Override
    public Colis findColisById(Integer id) {
        return entityManager.find(Colis.class, id);
    }
    
}
