package com.lilyle.lotus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lilyle.lotus.dao.CustomerDAO;
import com.lilyle.lotus.model.Customers;

@Service
@Transactional(rollbackFor = Exception.class)
public class CustomerService {
    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<Customers> findAll() {
        return customerDAO.findAll();
    }

    public Customers findById(long id) {
        return customerDAO.findById(id);
    }

    public void save(Customers customer) {
        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        // validate business
        customerDAO.save(customer);
    }

    public void update(Customers customer) {
        // validate business
        customerDAO.update(customer);
    }

    public void delete(Customers cus) {
        // validate business
        customerDAO.delete(cus);
    }
}
