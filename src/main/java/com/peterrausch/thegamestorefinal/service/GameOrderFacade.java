/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peterrausch.thegamestorefinal.service;

import com.peterrausch.thegamestorefinal.model.GameOrder;
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
public class GameOrderFacade extends AbstractFacade<GameOrder> {
    @PersistenceContext(unitName = "com.peter-rausch_TheGameStoreFinal_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GameOrderFacade() {
        super(GameOrder.class);
    }
    
    public int getLastId() {
        int id = 0;
        
        Query q = this.em.createQuery("SELECT o FROM GameOrder o ORDER BY o.gameorderid DESC");
        q.setMaxResults(1);
        
        List<GameOrder> results = q.getResultList();
        
        for(GameOrder go : results) {
            id = go.getGameorderid();
        }
        
        return id;
    }
    
}
