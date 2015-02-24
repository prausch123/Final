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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author peter
 */
@Entity
@Table(name = "GameOrder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GameOrder.findAll", query = "SELECT g FROM GameOrder g"),
    @NamedQuery(name = "GameOrder.findByGameorderid", query = "SELECT g FROM GameOrder g WHERE g.gameorderid = :gameorderid"),
    @NamedQuery(name = "GameOrder.findByUser", query = "SELECT g FROM GameOrder g WHERE g.user = :user"),
    @NamedQuery(name = "GameOrder.findByOrdertotal", query = "SELECT g FROM GameOrder g WHERE g.ordertotal = :ordertotal"),
    @NamedQuery(name = "GameOrder.findByFirstname", query = "SELECT g FROM GameOrder g WHERE g.firstname = :firstname"),
    @NamedQuery(name = "GameOrder.findByLastname", query = "SELECT g FROM GameOrder g WHERE g.lastname = :lastname"),
    @NamedQuery(name = "GameOrder.findByAddress", query = "SELECT g FROM GameOrder g WHERE g.address = :address"),
    @NamedQuery(name = "GameOrder.findByCity", query = "SELECT g FROM GameOrder g WHERE g.city = :city"),
    @NamedQuery(name = "GameOrder.findByState", query = "SELECT g FROM GameOrder g WHERE g.state = :state"),
    @NamedQuery(name = "GameOrder.findByZip", query = "SELECT g FROM GameOrder g WHERE g.zip = :zip"),
    @NamedQuery(name = "GameOrder.findByCcNumber", query = "SELECT g FROM GameOrder g WHERE g.ccNumber = :ccNumber"),
    @NamedQuery(name = "GameOrder.findByCcExp", query = "SELECT g FROM GameOrder g WHERE g.ccExp = :ccExp"),
    @NamedQuery(name = "GameOrder.findByCcSecurity", query = "SELECT g FROM GameOrder g WHERE g.ccSecurity = :ccSecurity")})
public class GameOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gameorderid")
    private Integer gameorderid;
    @Size(max = 45)
    @Column(name = "user")
    private String user;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ordertotal")
    private Double ordertotal;
    @Size(max = 45)
    @Column(name = "firstname")
    private String firstname;
    @Size(max = 45)
    @Column(name = "lastname")
    private String lastname;
    @Size(max = 45)
    @Column(name = "address")
    private String address;
    @Size(max = 45)
    @Column(name = "city")
    private String city;
    @Size(max = 45)
    @Column(name = "state")
    private String state;
    @Size(max = 45)
    @Column(name = "zip")
    private String zip;
    @Size(max = 45)
    @Column(name = "ccNumber")
    private String ccNumber;
    @Size(max = 45)
    @Column(name = "ccExp")
    private String ccExp;
    @Size(max = 45)
    @Column(name = "ccSecurity")
    private String ccSecurity;

    public GameOrder() {
    }

    public GameOrder(Integer gameorderid) {
        this.gameorderid = gameorderid;
    }

    public Integer getGameorderid() {
        return gameorderid;
    }

    public void setGameorderid(Integer gameorderid) {
        this.gameorderid = gameorderid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Double getOrdertotal() {
        return ordertotal;
    }

    public void setOrdertotal(Double ordertotal) {
        this.ordertotal = ordertotal;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
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

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getCcExp() {
        return ccExp;
    }

    public void setCcExp(String ccExp) {
        this.ccExp = ccExp;
    }

    public String getCcSecurity() {
        return ccSecurity;
    }

    public void setCcSecurity(String ccSecurity) {
        this.ccSecurity = ccSecurity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gameorderid != null ? gameorderid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameOrder)) {
            return false;
        }
        GameOrder other = (GameOrder) object;
        if ((this.gameorderid == null && other.gameorderid != null) || (this.gameorderid != null && !this.gameorderid.equals(other.gameorderid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.peterrausch.thegamestorefinal.jsf.GameOrder[ gameorderid=" + gameorderid + " ]";
    }
    
}
