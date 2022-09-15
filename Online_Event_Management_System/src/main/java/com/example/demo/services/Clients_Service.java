package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Clients;
import com.example.demo.repositories.Clients_Repository;

@Service
public class Clients_Service {
	@Autowired
	Clients_Repository cr;
	//this is my logic
	/*public List<Clients> getClients()
	{
		return cr.findAll();
	}*/
	
	public Clients add(Clients c)
	{
		return cr.save(c);//adding records in Clients table
	}
	
	public List<Clients> getAll(){
		return cr.findAll();
	}

}
