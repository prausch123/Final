/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peterrausch.thegamestorefinal.jsf;

import com.peterrausch.thegamestorefinal.model.Game;
import com.peterrausch.thegamestorefinal.model.GameOrder;
import com.peterrausch.thegamestorefinal.model.GameOrderItems;
import com.peterrausch.thegamestorefinal.service.GameOrderFacade;
import com.peterrausch.thegamestorefinal.service.GameOrderItemsFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author peter
 */
@Named("order")
@SessionScoped
public class OrderBean implements Serializable{
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String cc_name;
    private String cc_num;
    private String cc_exp;
    private String cc_security;
    
    private List<GameOrder> allOrders;
    private List<GameOrderItems> orderItemsFromID;
    private List<Game> orderedGames;
    
    private int order_id;
    private GameOrder selectedOrder;
    private Game currentGame;
    
    @Inject
    private GameOrderFacade gof;
    @Inject
    private GameOrderItemsFacade goif;
    @Inject
    private CartBean cart;
    @Inject
    private GameBean gb;
    @Inject
    private LoginBean lb;

    @PostConstruct
    public void getOrderList() {
        allOrders = gof.findAll();
    }
    
    public String refreshAllOrders() {
        allOrders = gof.findAll();
        
        return null;
    }
    
    public String viewOrder(int orderID) {
        getOrderList();
        for(GameOrder o : allOrders) {
            if(o.getGameorderid() == orderID) {
                selectedOrder = o;
                getOrderItemsForOrder(orderID);
                getArrayOfPurchasedGames();
            }
        }
        
        return "vieworder";
    }
    
    public void getGameByID(int id) {
        currentGame = gb.getGameFromID(id);
    }
    
    private void getOrderItemsForOrder(int orderid) {
        orderItemsFromID = goif.getListOfItems(orderid); 
    }
    
    public void getArrayOfPurchasedGames() {
        List<Game> ordered = new ArrayList<Game>();
        for(GameOrderItems items : orderItemsFromID) {
            for(Game g : gb.getAllGames()) {
                if(items.getGameid() == g.getGameid()) {
                    orderedGames.add(g);
                }
            }
        }
        
        this.orderedGames = ordered;
    }
    
    public String processOrder() {
        GameOrder newOrder = new GameOrder();
        
        newOrder.setFirstname(firstName);
        newOrder.setLastname(lastName);
        newOrder.setUser(lb.getUserName());
        newOrder.setAddress(address);
        newOrder.setCity(city);
        newOrder.setState(state);
        newOrder.setZip(zip);
        newOrder.setCcNumber(cc_num);
        newOrder.setCcExp(cc_exp);
        newOrder.setCcSecurity(cc_security);
        newOrder.setOrdertotal(cart.getGrandTotal());
        
        gof.create(newOrder);
        order_id = gof.getLastId();
        
        List<GameOrderItems> items = new ArrayList<GameOrderItems>();
        
        for(Game g : cart.getCartContents()) {
            GameOrderItems goi = new GameOrderItems();
            goi.setGameid(g.getGameid());
            goi.setOrderid(order_id);
            
            items.add(goi);
        }
        
        for(GameOrderItems item : items) {
            goif.create(item);
        }
        
        return null;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<GameOrderItems> getOrderItemsFromID() {
        return orderItemsFromID;
    }

    public void setOrderItemsFromID(List<GameOrderItems> orderItemsFromID) {
        this.orderItemsFromID = orderItemsFromID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<GameOrder> getAllOrders() {
        return allOrders;
    }

    public void setAllOrders(List<GameOrder> allOrders) {
        this.allOrders = allOrders;
    }

    public String getAddress() {
        return address;
    }

    public GameOrder getSelectedOrder() {
        return selectedOrder;
    }

    public void setSelectedOrder(GameOrder selectedOrder) {
        this.selectedOrder = selectedOrder;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public List<Game> getOrderedGames() {
        return orderedGames;
    }

    public void setOrderedGames(List<Game> orderedGames) {
        this.orderedGames = orderedGames;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCc_name() {
        return cc_name;
    }

    public void setCc_name(String cc_name) {
        this.cc_name = cc_name;
    }

    public String getCc_num() {
        return cc_num;
    }

    public void setCc_num(String cc_num) {
        this.cc_num = cc_num;
    }

    public String getCc_exp() {
        return cc_exp;
    }

    public void setCc_exp(String cc_exp) {
        this.cc_exp = cc_exp;
    }

    public String getCc_security() {
        return cc_security;
    }

    public void setCc_security(String cc_security) {
        this.cc_security = cc_security;
    }

    public GameOrderFacade getGof() {
        return gof;
    }

    public void setGof(GameOrderFacade gof) {
        this.gof = gof;
    }

    public GameOrderItemsFacade getGoif() {
        return goif;
    }

    public void setGoif(GameOrderItemsFacade goif) {
        this.goif = goif;
    }

    public CartBean getCart() {
        return cart;
    }

    public void setCart(CartBean cart) {
        this.cart = cart;
    }

    public GameBean getGb() {
        return gb;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }

    public void setGb(GameBean gb) {
        this.gb = gb;
    }
    
    
}
