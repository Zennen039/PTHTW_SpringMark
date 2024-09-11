/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.repository.impl;

import com.nva.pojo.Score;
import com.nva.repository.ScoreRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class ScoreRepositoryImpl implements ScoreRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Score> getScores() {
        Session s = this.factory.getObject().getCurrentSession();

        Query q = s.createNamedQuery("Score.findAll");

        return q.getResultList();
    }

    @Override
    public List<Score> getScoreByVolumeId(int score_vol_Id) {
        Session s = this.factory.getObject().getCurrentSession();
        
        CriteriaBuilder b = s.getCriteriaBuilder();
        
        CriteriaQuery<Score> q = b.createQuery(Score.class);
        
        Root<Score> root = q.from(Score.class);
        
        q.where(b.equal(root.get("volumeId"), score_vol_Id));
        
        return s.createQuery(q).getResultList();
    }
}
