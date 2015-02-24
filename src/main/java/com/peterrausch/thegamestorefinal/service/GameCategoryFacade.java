/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peterrausch.thegamestorefinal.service;

import com.peterrausch.thegamestorefinal.model.GameCategory;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author peter
 */
@Stateless
public class GameCategoryFacade extends AbstractFacade<GameCategory> {
    @PersistenceContext(unitName = "com.peter-rausch_TheGameStoreFinal_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GameCategoryFacade() {
        super(GameCategory.class);
    }
    
}
