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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author nguye
 */
@Entity
@Table(name = "subject")
@NamedQueries({
    @NamedQuery(name = "Subject.findAll", query = "SELECT s FROM Subject s"),
    @NamedQuery(name = "Subject.findById", query = "SELECT s FROM Subject s WHERE s.id = :id"),
    @NamedQuery(name = "Subject.findByName", query = "SELECT s FROM Subject s WHERE s.name = :name"),
    @NamedQuery(name = "Subject.findByLecturerName", query = "SELECT s FROM Subject s WHERE s.lecturerName = :lecturerName")})
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    @Size(min = 1, max = 255, message = "{subject.name.errMsg}")
    private String name;
    @Basic(optional = false)
    @Lob
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "lecturer_name")
    private String lecturerName;
    @OneToMany(mappedBy = "subjectId")
    @JsonIgnore
    private Set<Volume> volumeSet;
    @JoinColumn(name = "cate_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private Category cateId;
    @JoinColumn(name = "lecturer_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private User lecturerId;

    public Subject() {
    }

    public Subject(Integer id) {
        this.id = id;
    }

    public Subject(Integer id, String name, String description, String lecturerName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.lecturerName = lecturerName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public Set<Volume> getVolumeSet() {
        return volumeSet;
    }

    public void setVolumeSet(Set<Volume> volumeSet) {
        this.volumeSet = volumeSet;
    }

    public Category getCateId() {
        return cateId;
    }

    public void setCateId(Category cateId) {
        this.cateId = cateId;
    }

    public User getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(User lecturerId) {
        this.lecturerId = lecturerId;
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
        if (!(object instanceof Subject)) {
            return false;
        }
        Subject other = (Subject) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nva.pojo.Subject[ id=" + id + " ]";
    }

}
