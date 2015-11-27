package fr.INFO921;

import javax.ejb.Local;

/**
 *
 * @author francoiscaillet
 */
@Local
public interface PositionSessionBeanLocal {
    
    void enregistrementPosition(Position position);
}
