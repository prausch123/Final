/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peterrausch.thegamestorefinal.service;

import com.peterrausch.thegamestorefinal.model.GameClient;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author peter
 */
@Stateless
public class GameClientFacade extends AbstractFacade<GameClient> {
    @PersistenceContext(unitName = "com.peter-rausch_TheGameStoreFinal_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GameClientFacade() {
        super(GameClient.class);
    }
    
}
