/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.repository.impl;

import com.nva.pojo.Subject;
import com.nva.repository.SubjectRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
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
public class SubjectRepositoryImpl implements SubjectRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Subject> getSubjects(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();

        CriteriaBuilder b = s.getCriteriaBuilder();

        CriteriaQuery<Subject> q = b.createQuery(Subject.class);

        Root r = q.from(Subject.class);

        q.select(r);

        List<Predicate> predicates = new ArrayList<>();

        String kw = params.get("kw");

        if (kw != null && !kw.isEmpty()) {
            predicates.add(b.like(r.get("name"), String.format("%%%s%%", kw)));
        }

        String subjectId = params.get("subjectId");

        if (subjectId != null && !subjectId.isEmpty()) {
            predicates.add(b.equal(r.get("cateId"), Integer.parseInt(subjectId)));
        }

        q.where(predicates.toArray(Predicate[]::new));

        q.orderBy(b.desc(r.get("id")));

        Query que = s.createQuery(q);

        List<Subject> sj = que.getResultList();

        return sj;
    }

    @Override
    public void addOrUpdate(Subject sj) {
        Session s = this.factory.getObject().getCurrentSession();
        if (sj.getId() != null && sj.getId() > 0) {
            s.update(sj);
        } else {
            s.save(sj);
        }
    }

    @Override
    public Subject getSubjectById(int id) {
        Session s = this.factory.getObject().getCurrentSession();

        return s.get(Subject.class, id);
    }

    @Override
    public void deleteSubject(int id) {
        Session s = this.factory.getObject().getCurrentSession();

        Subject sj = this.getSubjectById(id);

        s.delete(sj);
    }
}
