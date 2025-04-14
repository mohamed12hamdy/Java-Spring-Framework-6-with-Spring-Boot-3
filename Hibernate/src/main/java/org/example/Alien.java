package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Alien {
    @Id
    private int AId;
    private String Tech;
    private String Name;
    @OneToOne
    private Laptop Lap;

    public Laptop getLap() {
        return Lap;
    }

    public void setLap(Laptop lap) {
        Lap = lap;
    }

    public int getAId() {
        return AId;
    }

    public String getTech() {
        return Tech;
    }

    public String getName() {
        return Name;
    }

    public void setAId(int AId) {
        this.AId = AId;
    }

    public void setTech(String tech) {
        Tech = tech;
    }

    public void setName(String name) {
        Name = name;
    }
}
