/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peterrausch.thegamestorefinal.service;

import com.peterrausch.thegamestorefinal.model.Game;
import com.peterrausch.thegamestorefinal.model.GameOrder;
import com.peterrausch.thegamestorefinal.model.GameOrderItems;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author peter
 */
@Stateless
public class GameOrderItemsFacade extends AbstractFacade<GameOrderItems> {
    @PersistenceContext(unitName = "com.peter-rausch_TheGameStoreFinal_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public void enterOrderItems(List<Game> cart, String FirstName, String LastName) {
        em.createQuery("SELECT gameorderid FROM GameOrder WHERE firstname = '" + FirstName + "' AND lastname = '" + LastName + "';");
        
    }
    
    public List<GameOrderItems> getListOfItems(int orderID) {
        
        Query q = this.em.createQuery("SELECT oi FROM GameOrderItems oi WHERE oi.orderid = ?1");
        q.setParameter(1, orderID);
        
        List<GameOrderItems> results = q.getResultList();
        
        return results;
    }

    public GameOrderItemsFacade() {
        super(GameOrderItems.class);
    }
    
}
