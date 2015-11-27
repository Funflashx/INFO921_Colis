package fr.INFO921;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author francoiscaillet
 */
@Stateless
public class PositionSessionBean implements PositionSessionBeanLocal {
    
      
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void enregistrementPosition(Position position) {
        if (position.getId() == null) {
            entityManager.persist(position);
        }else {
            entityManager.merge(position);
        }
    }
}
