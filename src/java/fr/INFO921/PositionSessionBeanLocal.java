/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
