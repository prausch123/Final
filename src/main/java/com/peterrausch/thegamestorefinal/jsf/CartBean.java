/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peterrausch.thegamestorefinal.jsf;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import com.peterrausch.thegamestorefinal.model.Game;
import com.peterrausch.thegamestorefinal.service.GameFacade;
import java.text.DecimalFormat;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author peter
 */
@Named("cart")
@SessionScoped
public class CartBean implements Serializable{
    private List<Game> cartContents = new ArrayList<Game>();
    private List<Game> availableGames = new ArrayList<Game>();
    DecimalFormat twoDForm = new DecimalFormat("#.##");

    private String ERR_GAME_NULL = "The game you tried to pass, was null!";
    private String ERR_GAME_NONEXISTANT = "The game you tried to pass doesn't exist!";
    private double TAX_RATE = 0.056;
    
//    private int gameId;
    @Inject
    GameBean gameBean;

//    public int getGameId() {
//        return gameId;
//    }
//
//    public void setGameId(int gameId) {
//        this.gameId = gameId;
//    }
    
    public String addGameToCart() {
        if(gameBean.getSelectedGame().getGameid() < 0 ) {
            throw new IllegalArgumentException(ERR_GAME_NULL);
        } else {
            Game g = null;
            for(Game game : availableGames) {
                if(game.getGameid() == gameBean.getSelectedGame().getGameid()) {
                    g = game;
                }
            }
            
            if(g != null) {
                cartContents.add(g);
            } else {
                throw new IllegalArgumentException(ERR_GAME_NONEXISTANT);
            }
        }
        
        return null;
    }
    
    @Inject
    private GameFacade gameDAO;

    @PostConstruct
    public void preloadList() {
        availableGames = gameDAO.findAll();
    }
    
    public String goCart() {
        return "checkout";
    }
    
    public List<Game> getCartContents() {
        return cartContents;
    }
    
    public double getGrandTotal() {
        double total = 0;
        
        for (Game g : cartContents) {
            total += g.getPrice();
        }
        
        return Double.valueOf(twoDForm.format((total * TAX_RATE) + total));
       
    }
    
    public double getJustTax() {
        return Double.valueOf(twoDForm.format(getSubTotal() * TAX_RATE));
    }
    
    public double getSubTotal() {
        double total = 0;
        
        for (Game g : cartContents) {
            total += g.getPrice();
        }
        
        return Double.valueOf(twoDForm.format(total));
    }

    public void setCartContents(List<Game> cartContents) {
        this.cartContents = cartContents;
    }

    
    
}
