package com.lilyle.lotus.bean;

import org.springframework.stereotype.Component;

@Component
public class Bean2 {
    private String hello;

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
    
}
