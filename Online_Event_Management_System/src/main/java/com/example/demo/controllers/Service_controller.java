package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.Service_Provider_Service;
import com.example.demo.services.Services_Service;
import com.example.demo.entities.*;
import com.example.demo.repositories.Category_Repository;
import com.example.demo.repositories.Service_Providers_Repository;

@CrossOrigin(value = "http://localhost:3000")
@RestController
public class Service_controller {
	@Autowired
	Services_Service sc;
	
	@Autowired
	Category_Repository cr;
	
	@
	Autowired
	Service_Providers_Repository spr;
	@GetMapping("/getAllServices")
	public List<Services> getAll(){
		return sc.getAll();
	}
	
	@PostMapping("/saveService")
	public Services saveService(@RequestBody Register_Service_POJO serv) {
	
		
		return sc.SaveService(serv);
		
	}
	
}
