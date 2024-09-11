/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.repository.impl;

import com.nva.pojo.User;
import com.nva.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nguye
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private BCryptPasswordEncoder passEncoder;

    @Override
    public User getUserByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();

        Query q = s.createNamedQuery("User.findByUsername");

        q.setParameter("username", username);

        return (User) q.getSingleResult();

    }
    
    @Override
    public User getUserById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        
        return s.get(User.class, id);
    }

    @Override
    public List<User> getUser() {
        Session s = this.factory.getObject().getCurrentSession();

        Query q = s.createNamedQuery("User.findAll");

        return q.getResultList();
    }

    @Override
    public List<User> getUser(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();

        CriteriaBuilder b = s.getCriteriaBuilder();

        CriteriaQuery<User> q = b.createQuery(User.class);

        Root r = q.from(User.class);

        q.select(r);

        List<Predicate> predicates = new ArrayList<>();

        String kw = params.get("kw");

        if (kw != null && !kw.isEmpty()) {
            predicates.add(b.like(r.get("ten"), String.format("%%%s%%", kw)));
        }

        String userId = params.get("userId");

        if (userId != null && !userId.isEmpty()) {
            predicates.add(b.equal(r.get("ten"), Integer.parseInt(userId)));
        }

        q.where(predicates.toArray(Predicate[]::new));

        q.orderBy(b.desc(r.get("id")));

        Query query = s.createQuery(q);

        List<User> user = query.getResultList();

        return user;
    }
    
    @Override
    public List<User> findByUserRole(String userRole) {
        Session s = this.factory.getObject().getCurrentSession();
        
        Query q = s.createNamedQuery("User.findByUserRole");
        
        q.setParameter("userRole", userRole);

        return q.getResultList();
    }
    
    public Optional<User> findByUserId(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        
        User us = s.get(User.class, id);
        
        return Optional.ofNullable(us);
    }
    
    @Override
    public void deleteUser(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        
        User us = this.getUserById(id);
        
        s.delete(us);
    }
    
    @Override
    public boolean authUser(String username, String password) {
        User  u = this.getUserByUsername(username);
        
        return this.passEncoder.matches(password, u.getPassword());
    }

    @Override
    public User addUser(User u) {
        Session s = this.factory.getObject().getCurrentSession();

        s.save(u);

        return u;
    }
}
