package com.telusko;

public class Alien {
    private int age;
    private Computer com;


    public Computer getCom() {
        return com;
    }

    public void setCom(Computer com) {
        this.com = com;
    }

    public void setAge(int age) {
        System.out.println("Age has been set now");
        this.age = age;
    }

    public void code(){
        System.out.println("Coding");
        com.Complie();
    }

    public int getAge() {
        return age;
    }
}
