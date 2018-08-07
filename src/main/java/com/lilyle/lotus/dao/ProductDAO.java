package com.lilyle.lotus.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lilyle.lotus.model.Products;
import com.lilyle.lotus.model.Stocks;

@Repository(value = "productDAO")
public class ProductDAO {
    @Autowired
    private SessionFactory sessionFactory;
    
    public List<Products> findByProductName(String productName) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Products p where p.productName like :productName");
        query.setParameter("productName", '%'+productName+'%');
        List<Products>  list = query.list();
        return list;
    }
    
    public void saveManyProducts(Products[] products) {
        int batchSize = 15;
        int i = 1;
        Session session = this.sessionFactory.getCurrentSession();
        for(Products product : products) {
            session.save(product);
            /*if(i % batchSize == 0) {
                session.flush();
                session.clear();
            }*/
        }
    }
    
    
    @SuppressWarnings({ "unused", "unchecked" })
    public List<Products> findAllProducts() {
        Session session = this.sessionFactory.getCurrentSession();
        System.out.println("THIS IS GET METHOD-----------------------------------------------------");
        //Products p2 = session.get(Products.class, 1L);
        //Products p3 = session.get(Products.class, 1L);
        List<Products> list1 = session.createQuery("from Products").list();
        List<Products> list2 = session.createQuery("from Products").list();
        List<Products> list3 = session.createNativeQuery("select * from Products").list();
        List<Products> list4 = session.createNativeQuery("select * from Products").list();
        System.out.println("THIS IS FIND METHOD-----------------------------------------------------");
        //Products p4 = session.find(Products.class, 1L);
        //List<Products> list = new ArrayList<Products>();
       //list.add(p4);
        return list4;
    }
    public void saveProductrByNativeQuery(Products product) {
        Session session = this.sessionFactory.getCurrentSession();
        NativeQuery nQuery = session.createNativeQuery("INSERT INTO Customers values (':productName', ':productPrice', ':productDescription'");
        nQuery.setParameter("productName", product.getProductName());
        nQuery.setParameter("productPrice", product.getProductPrice());
        nQuery.setParameter("productDescription", product.getProductDescription());
        nQuery.executeUpdate();
        
    }
    
    public void saveProducts(Products product, Stocks stock) {
        Session session = this.sessionFactory.getCurrentSession();
        //product.getStocks().add(stock);
        session.save(product);
    }
    
    
    public void updateProducts(Products product, Stocks stock) {
        Session session = this.sessionFactory.getCurrentSession();
        //product.getStocks().add(stock);
        session.saveOrUpdate(product);
    }
}
