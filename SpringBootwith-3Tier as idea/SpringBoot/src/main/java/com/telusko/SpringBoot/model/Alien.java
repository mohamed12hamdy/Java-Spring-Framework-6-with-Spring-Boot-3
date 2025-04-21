package com.telusko.SpringBoot.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Alien {
    @Value("20")
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }


    private Computer com;

    public Computer getCom() {
        return com;
    }
    @Autowired
    @Qualifier("desktop")
    public void setCom(Computer com) {
        this.com = com;
    }

    public void code(){
        System.out.println("coding");
        com.Compile();
    }

}
