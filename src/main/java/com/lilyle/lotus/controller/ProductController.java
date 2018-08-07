package com.lilyle.lotus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.lilyle.lotus.bean.Bean1;
import com.lilyle.lotus.model.Factory;
import com.lilyle.lotus.model.Products;
import com.lilyle.lotus.model.Stocks;
import com.lilyle.lotus.service.FactoryService;
import com.lilyle.lotus.service.ProductService;

@RestController
public class ProductController {
    
    @Autowired
    protected FactoryService factoryService;
    
    @Autowired
    protected Bean1 bean1;
    
    
    @Autowired
    ProductService productService;
    
    @RequestMapping(value="/api/retrieve-product/{productName}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<?> retrieveProductsByName(@PathVariable("productName") String productName) {
        List<Products> products = productService.retrieveProductByName(productName);
        if(products == null || products.size() == 0) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        bean1.display();
        //return new ResponseEntity<Products>(products.get(0), HttpStatus.OK); 
        return ResponseEntity.ok().body(products);
    }
    
    @GetMapping(value="/api/retrieve-all-product/")
    public @ResponseBody ResponseEntity<?> retrieveAllProducts() {
        List<Products> products = productService.retrieveAllProduct();
        if(products == null || products.size() == 0) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
      //return new ResponseEntity<Products>(products.get(0), HttpStatus.OK); 
        return ResponseEntity.ok().body(products);
    }
    
    @RequestMapping(value = "/api/add-product/", method = RequestMethod.POST)
    public ResponseEntity<?> saveProduct(@RequestBody Products product, UriComponentsBuilder ucBuilder) {
        Stocks s = new Stocks();
        s.setNumberInStock(15);
        productService.saveProduct(product, s);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/retrieve-product/{productName}").buildAndExpand(product.getProductName()).toUri());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/api/add-factory/", method = RequestMethod.POST)
    public ResponseEntity<?> saveFactory(@RequestBody Factory[] factories) {
        /*Stocks s = new Stocks();
        s.setNumberInStock(15);
        productService.saveProduct(product, s);*/
        factoryService.add(factories);
        HttpHeaders headers = new HttpHeaders();
       // headers.setLocation(ucBuilder.path("/api/retrieve-product/{productName}").buildAndExpand(product.getProductName()).toUri());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/api/save-many-products/", method = RequestMethod.POST)
    public ResponseEntity<?> saveProduct(@RequestBody Products[] products, UriComponentsBuilder ucBuilder) {
        productService.saveManyProducts(products);
        HttpHeaders headers = new HttpHeaders();
        //headers.setLocation(ucBuilder.path("/api/retrieve-product/{productName}").buildAndExpand(product.getProductName()).toUri());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }
    
    /*@RequestMapping(value = "/api/add-product2/", method = RequestMethod.GET) 
    public ResponseEntity<String> displayProduct(){
        return new ResponseEntity<String>("anc", HttpStatus.OK);
    }*/
    @RequestMapping(value = "/api/update-product/", method = RequestMethod.PUT)
    public ResponseEntity<Void> createUser(@RequestBody Products product,    UriComponentsBuilder ucBuilder) {
       // System.out.println("Creating User " + user.getName());
 
        /*if (userService.isUserExist(user)) {
            System.out.println("A User with name " + user.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
        Stocks s = new Stocks();
        s.setNumberInStock(15);
        productService.updateProduct(product, s);
 
        HttpHeaders headers = new HttpHeaders();
        //headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
}
