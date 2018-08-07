package com.lilyle.lotus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lilyle.lotus.dao.FactoryDAO;
import com.lilyle.lotus.model.Factory;

@Service
public class FactoryService {
    @Autowired
    @Qualifier(value="factoryDAO")
    private FactoryDAO repository;
    
    public void add(Factory[] factories) {
        repository.add(factories);
    }
    
}
