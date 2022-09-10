package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Clients;
import com.example.demo.repositories.Clients_Repository;
import com.example.demo.services.Clients_Service;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Clients1 {
	@Autowired
	Clients_Service cc;
	@GetMapping("/clients")
	public List<Clients> getClients()
	{
		return cc.getClients();
}

	
}
