package com.telusko.SpringBoot.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Laptop implements Computer {
    public void Compile(){
        System.out.println("Compile from Laptop");
    }
}
