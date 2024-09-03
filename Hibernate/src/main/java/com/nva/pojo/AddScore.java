/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author nguye
 */
@Entity
@Table(name = "add_score")
@NamedQueries({
    @NamedQuery(name = "AddScore.findAll", query = "SELECT a FROM AddScore a"),
    @NamedQuery(name = "AddScore.findById", query = "SELECT a FROM AddScore a WHERE a.id = :id"),
    @NamedQuery(name = "AddScore.findByName", query = "SELECT a FROM AddScore a WHERE a.name = :name"),
    @NamedQuery(name = "AddScore.findByAdditionalScore", query = "SELECT a FROM AddScore a WHERE a.additionalScore = :additionalScore")})
public class AddScore implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "additional_score")
    private Double additionalScore;
    @JoinColumn(name = "contscore_id", referencedColumnName = "id")
    @ManyToOne
    private Score contscoreId;

    public AddScore() {
    }

    public AddScore(Integer id) {
        this.id = id;
    }

    public AddScore(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAdditionalScore() {
        return additionalScore;
    }

    public void setAdditionalScore(Double additionalScore) {
        this.additionalScore = additionalScore;
    }

    public Score getContscoreId() {
        return contscoreId;
    }

    public void setContscoreId(Score contscoreId) {
        this.contscoreId = contscoreId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AddScore)) {
            return false;
        }
        AddScore other = (AddScore) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nva.pojo.AddScore[ id=" + id + " ]";
    }
    
}
