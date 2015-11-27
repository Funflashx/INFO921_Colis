/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.INFO921;

import java.util.Date;
import javax.ejb.Schedule;
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
            //Position p = new Position(new BigDecimal(5.55), new BigDecimal(45.989));
            //entityManager.persist(p);
            //entityManager.flush();
        }else {
            entityManager.merge(position);
        }
    }


    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
