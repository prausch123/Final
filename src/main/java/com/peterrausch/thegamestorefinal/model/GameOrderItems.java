/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peterrausch.thegamestorefinal.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author peter
 */
@Entity
@Table(name = "GameOrderItems")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GameOrderItems.findAll", query = "SELECT g FROM GameOrderItems g"),
    @NamedQuery(name = "GameOrderItems.findByOrderitemid", query = "SELECT g FROM GameOrderItems g WHERE g.orderitemid = :orderitemid"),
    @NamedQuery(name = "GameOrderItems.findByOrderid", query = "SELECT g FROM GameOrderItems g WHERE g.orderid = :orderid"),
    @NamedQuery(name = "GameOrderItems.findByGameid", query = "SELECT g FROM GameOrderItems g WHERE g.gameid = :gameid")})
public class GameOrderItems implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "orderitemid")
    private Integer orderitemid;
    @Column(name = "orderid")
    private Integer orderid;
    @Column(name = "gameid")
    private Integer gameid;

    public GameOrderItems() {
    }

    public GameOrderItems(Integer orderitemid) {
        this.orderitemid = orderitemid;
    }

    public Integer getOrderitemid() {
        return orderitemid;
    }

    public void setOrderitemid(Integer orderitemid) {
        this.orderitemid = orderitemid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getGameid() {
        return gameid;
    }

    public void setGameid(Integer gameid) {
        this.gameid = gameid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderitemid != null ? orderitemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameOrderItems)) {
            return false;
        }
        GameOrderItems other = (GameOrderItems) object;
        if ((this.orderitemid == null && other.orderitemid != null) || (this.orderitemid != null && !this.orderitemid.equals(other.orderitemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.peterrausch.thegamestorefinal.jsf.GameOrderItems[ orderitemid=" + orderitemid + " ]";
    }
    
}
