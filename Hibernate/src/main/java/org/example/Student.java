package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private int rollNum;
    private String Name;
    private int Age;
    private Address address;
    public void setName(String name) {
        this.Name = name;
    }

    public void setAge(int age) {
        this.Age = age;
    }
    public void setRollNum(int rollNum){
        this.rollNum = rollNum;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNum=" + rollNum +
                ", Name='" + Name + '\'' +
                ", Age=" + Age +
                '}';
    }

    public int getRollNum() {
        return rollNum;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }
}