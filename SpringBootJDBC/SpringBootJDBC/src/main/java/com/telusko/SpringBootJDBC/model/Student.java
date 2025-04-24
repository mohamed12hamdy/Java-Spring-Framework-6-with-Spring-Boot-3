package com.telusko.SpringBootJDBC.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Scope("prototype")
@Component
public class Student {
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
