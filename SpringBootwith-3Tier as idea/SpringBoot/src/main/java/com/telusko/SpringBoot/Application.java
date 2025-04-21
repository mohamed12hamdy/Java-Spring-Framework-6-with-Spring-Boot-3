package com.telusko.SpringBoot;

import com.telusko.SpringBoot.model.Alien;
import com.telusko.SpringBoot.model.Laptop;
import com.telusko.SpringBoot.service.LaptopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext Context = SpringApplication.run(Application.class, args);
		LaptopService service = Context.getBean(LaptopService.class);
		Laptop Lap = Context.getBean(Laptop.class);

		service.addLaptop(Lap);
	}

}
