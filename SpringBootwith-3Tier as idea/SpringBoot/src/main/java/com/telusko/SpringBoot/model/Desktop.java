package com.telusko.SpringBoot.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;



    @Component
    @Qualifier("desktop")
    public class Desktop implements Computer {
        public void Compile(){
            System.out.println("Compile from Desktop");
        }
    }


