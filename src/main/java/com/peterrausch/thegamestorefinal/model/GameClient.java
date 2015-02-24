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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author peter
 */
@Entity
@Table(name = "GameClient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GameClient.findAll", query = "SELECT g FROM GameClient g"),
    @NamedQuery(name = "GameClient.findByClientid", query = "SELECT g FROM GameClient g WHERE g.clientid = :clientid"),
    @NamedQuery(name = "GameClient.findByUsername", query = "SELECT g FROM GameClient g WHERE g.username = :username"),
    @NamedQuery(name = "GameClient.findByPassword", query = "SELECT g FROM GameClient g WHERE g.password = :password"),
    @NamedQuery(name = "GameClient.findByRank", query = "SELECT g FROM GameClient g WHERE g.rank = :rank")})
public class GameClient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "clientid")
    private Integer clientid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rank")
    private int rank;

    public GameClient() {
    }

    public GameClient(Integer clientid) {
        this.clientid = clientid;
    }

    public GameClient(Integer clientid, String username, String password, int rank) {
        this.clientid = clientid;
        this.username = username;
        this.password = password;
        this.rank = rank;
    }

    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientid != null ? clientid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameClient)) {
            return false;
        }
        GameClient other = (GameClient) object;
        if ((this.clientid == null && other.clientid != null) || (this.clientid != null && !this.clientid.equals(other.clientid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.peterrausch.thegamestorefinal.model.GameClient[ clientid=" + clientid + " ]";
    }
    
}
