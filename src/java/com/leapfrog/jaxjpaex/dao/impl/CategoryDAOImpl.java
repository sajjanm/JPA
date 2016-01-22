/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jaxjpaex.dao.impl;

import com.leapfrog.jaxjpaex.dao.CategoryDAO;
import com.leapfrog.jaxjpaex.entity.Category;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author sajjan
 */
public class CategoryDAOImpl implements CategoryDAO{

    private EntityManagerFactory emf;
    private EntityManager em;
    
    public CategoryDAOImpl(){
        emf=Persistence.createEntityManagerFactory("JAX_JAP_ExamplePU");
        em=emf.createEntityManager();
    }
    
    @Override
    public List<Category> getAll() {
        return (List<Category>) em.createQuery("SELECT c FROM Category c").getResultList();
    }

    @Override
    public int insert(Category c) {
        EntityTransaction transaction=em.getTransaction();
        transaction.begin();
        em.persist(c);
        int id=c.getId();
        transaction.commit();
        return id;
    }

    @Override
    public Category getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Category c) {
        EntityTransaction transaction=em.getTransaction();
        transaction.begin();
        em.merge(c);
        transaction.commit();
        
    }

    @Override
    public void delete(int id) {
        EntityTransaction transaction=em.getTransaction();
        transaction.begin();
        Category c =em.find(Category.class, id);
        if(c!=null){
            em.remove(c);
        }
        transaction.commit();
    }
    
}
