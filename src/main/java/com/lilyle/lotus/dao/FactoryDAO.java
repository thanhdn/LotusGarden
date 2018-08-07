package com.lilyle.lotus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lilyle.lotus.model.Factory;

@Repository
public class FactoryDAO implements BasicDAO<Factory>{

    @Autowired
    private SessionFactory sessionFactory;
    
    public void add(Factory[] factories) {
        Session session = sessionFactory.getCurrentSession();
        int batchsize = 15;
        int count = 1;
        for(Factory fatory: factories) {
            session.save(fatory);
            count++;
            if(count % batchsize == 0) {
                session.flush();
                session.clear();
            }
        }
        
    }

    public void update(Factory factory) {
        // TODO Auto-generated method stub
        
    }

    public Factory get() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Factory> findAll() {
        // TODO Auto-generated method stub
        return null;
    }
}
