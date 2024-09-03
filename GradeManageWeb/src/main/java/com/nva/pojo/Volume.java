/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author nguye
 */
@Entity
@Table(name = "volume")
@NamedQueries({
    @NamedQuery(name = "Volume.findAll", query = "SELECT v FROM Volume v"),
    @NamedQuery(name = "Volume.findById", query = "SELECT v FROM Volume v WHERE v.id = :id"),
    @NamedQuery(name = "Volume.findByName", query = "SELECT v FROM Volume v WHERE v.name = :name")})
public class Volume implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "volumeId")
    @JsonIgnore
    private Set<Forum> forumSet;
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private Subject subjectId;
    @OneToMany(mappedBy = "volumeId")
    @JsonIgnore
    private Set<Score> scoreSet;
    @OneToMany(mappedBy = "volumeId")
    @JsonIgnore
    private Set<Enrollment> enrollmentSet;

    public Volume() {
    }

    public Volume(Integer id) {
        this.id = id;
    }

    public Volume(Integer id, String name) {
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

    public Set<Forum> getForumSet() {
        return forumSet;
    }

    public void setForumSet(Set<Forum> forumSet) {
        this.forumSet = forumSet;
    }

    public Subject getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Subject subjectId) {
        this.subjectId = subjectId;
    }

    public Set<Score> getScoreSet() {
        return scoreSet;
    }

    public void setScoreSet(Set<Score> scoreSet) {
        this.scoreSet = scoreSet;
    }

    public Set<Enrollment> getEnrollmentSet() {
        return enrollmentSet;
    }

    public void setEnrollmentSet(Set<Enrollment> enrollmentSet) {
        this.enrollmentSet = enrollmentSet;
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
        if (!(object instanceof Volume)) {
            return false;
        }
        Volume other = (Volume) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nva.pojo.Volume[ id=" + id + " ]";
    }
    
}
