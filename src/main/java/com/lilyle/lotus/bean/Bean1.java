package com.lilyle.lotus.bean;

import org.springframework.stereotype.Component;

@Component
public class Bean1 {
    
    private  Bean2 bean2;
    
    public Bean1(Bean2 b2) {
        bean2 = b2;
    }
    
    public void display() {
        System.out.println(bean2.getHello());
    }
}
