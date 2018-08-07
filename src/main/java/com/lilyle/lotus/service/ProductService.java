package com.lilyle.lotus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lilyle.lotus.dao.ProductDAO;
import com.lilyle.lotus.model.Products;
import com.lilyle.lotus.model.Stocks;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductService {
    @Autowired
    private ProductDAO productDAO;
    
    public List<Products> retrieveProductByName(String productName) {
        return productDAO.findByProductName(productName);
    }
    
    public List<Products> retrieveAllProduct() {
        return productDAO.findAllProducts();
    }
    
    public void saveProductBySQL(Products product) {
        productDAO.saveProductrByNativeQuery(product);
    }
    
    public void saveProduct(Products product, Stocks stock) {
        productDAO.saveProducts(product, stock);;
    }
    
    public void updateProduct(Products product, Stocks stock) {
        productDAO.updateProducts(product, stock);;
    }
    
    public void saveManyProducts(Products[] products) {
        productDAO.saveManyProducts(products);
    }
}
