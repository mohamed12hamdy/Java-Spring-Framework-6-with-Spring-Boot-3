package com.telusko.SpringBoot.repo;

import com.telusko.SpringBoot.model.Laptop;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepository {
    public void Save(Laptop Lap){
        System.out.println("Saved in DB");
    }
}
