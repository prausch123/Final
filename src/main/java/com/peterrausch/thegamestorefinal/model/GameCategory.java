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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author peter
 */
@Entity
@Table(name = "GameCategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GameCategory.findAll", query = "SELECT g FROM GameCategory g"),
    @NamedQuery(name = "GameCategory.findByCategoryid", query = "SELECT g FROM GameCategory g WHERE g.categoryid = :categoryid"),
    @NamedQuery(name = "GameCategory.findByDescription", query = "SELECT g FROM GameCategory g WHERE g.description = :description")})
public class GameCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "categoryid")
    private Integer categoryid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "description")
    private String description;

    public GameCategory() {
    }

    public GameCategory(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public GameCategory(Integer categoryid, String description) {
        this.categoryid = categoryid;
        this.description = description;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryid != null ? categoryid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameCategory)) {
            return false;
        }
        GameCategory other = (GameCategory) object;
        if ((this.categoryid == null && other.categoryid != null) || (this.categoryid != null && !this.categoryid.equals(other.categoryid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.peterrausch.thegamestorefinal.model.GameCategory[ categoryid=" + categoryid + " ]";
    }
    
}
