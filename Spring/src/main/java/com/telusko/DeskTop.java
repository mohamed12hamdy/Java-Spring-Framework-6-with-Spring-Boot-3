package com.telusko;

import org.springframework.stereotype.Component;


public class DeskTop implements  Computer{
    public DeskTop() {
        System.out.println("Desktop Object is Created");
    }

    @Override
    public void Complie() {
        System.out.println("Compiling using Desktop");
    }
}
