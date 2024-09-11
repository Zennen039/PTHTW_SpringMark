/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.repository.impl;

import com.nva.pojo.Subject;
import com.nva.pojo.Volume;
import com.nva.repository.VolumeRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nguye
 */
@Repository
@Transactional
public class VolumeRepositoryImpl implements VolumeRepository {
    
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Volume> getVolumes() {
        Session s = this.factory.getObject().getCurrentSession();
        
        Query q = s.createNamedQuery("Volume.findAll");
        
        return q.getResultList();
    }
    
    @Override
    public Volume getVolumeById(int id) {
        Session s = this.factory.getObject().getCurrentSession();

        return s.get(Volume.class, id);
    }
}
