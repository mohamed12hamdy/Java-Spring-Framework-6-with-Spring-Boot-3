package com.telusko.spring_data_jpa_ex.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Entity
@Scope("prototype")
@Component
public class Student {
    @Id
    private int rollNo;
    private String Name;
    private int Marks;

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return Name;
    }

    public int getMarks() {
        return Marks;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setMarks(int marks) {
        Marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", Name='" + Name + '\'' +
                ", Marks=" + Marks +
                '}';
    }


}