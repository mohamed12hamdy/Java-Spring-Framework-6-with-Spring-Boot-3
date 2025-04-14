package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Laptop {
    @Id
    private int Lid;
    private String Brand;
    private String Model;
    private int Ram;

    public void setLid(int lid) {
        Lid = lid;
    }

    public int getLid() {
        return Lid;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public void setModel(String model) {
        Model = model;
    }

    public void setRam(int ram) {
        Ram = ram;
    }

    public String getBrand() {
        return Brand;
    }

    public String getModel() {
        return Model;
    }

    public int getRam() {
        return Ram;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "Lid=" + Lid +
                ", Brand='" + Brand + '\'' +
                ", Model='" + Model + '\'' +
                ", Ram=" + Ram +
                '}';
    }
}
