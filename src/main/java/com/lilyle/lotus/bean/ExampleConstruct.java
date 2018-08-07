package com.lilyle.lotus.bean;

import org.springframework.stereotype.Component;

@Component
public class ExampleConstruct {
    private String message;
    private long numberOfCustomer;
    public void setMessage(String message) {
        this.message = message;
    }
    public void setNumberOfCustomer(long numberOfCustomer) {
        this.numberOfCustomer = numberOfCustomer;
    }
    public void display() {
        int i = 0;
        while(i < numberOfCustomer) {
            i++;
            System.out.println(message + " " + i);
        }
    }
    
    
    public void postConstruct() {
        System.out.println("------------------POST CONSTRUCT------------------");
    }
}
