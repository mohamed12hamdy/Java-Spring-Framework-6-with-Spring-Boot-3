package com.telusko.SpringBoot.service;

import com.telusko.SpringBoot.model.Laptop;

import com.telusko.SpringBoot.repo.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {
    @Autowired
   private LaptopRepository repo;
    public  void addLaptop(Laptop lap){
        repo.Save(lap);
    }
    public Boolean isGoodForProgramming(Laptop lap){
        return true;
    }
}
