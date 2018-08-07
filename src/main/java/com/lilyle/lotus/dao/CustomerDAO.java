package com.lilyle.lotus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lilyle.lotus.model.Customers;



@Component(value = "customerDAO")
public class CustomerDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    public void save(final Customers customer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(customer);
    }

    public void update(final Customers customer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(customer);
    }

    public Customers findById(final long id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Customers.class, id);
    }

    public void delete(final Customers customer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.remove(customer);
    }

    public List<Customers> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("FROM Customers", Customers.class).getResultList();
    }
}
