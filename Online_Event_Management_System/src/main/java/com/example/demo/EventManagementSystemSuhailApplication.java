package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.entities.Cart;
@ComponentScan(basePackages = "com.example.demo.*")
@SpringBootApplication
public class EventManagementSystemSuhailApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventManagementSystemSuhailApplication.class, args);
		
		
	}

}
