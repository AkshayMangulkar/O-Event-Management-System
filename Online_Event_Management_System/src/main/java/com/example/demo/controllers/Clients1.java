package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Cart;
import com.example.demo.entities.Clients;
import com.example.demo.entities.Clients_Register;
import com.example.demo.entities.Registration_SP_POJO;
import com.example.demo.entities.Security;
import com.example.demo.entities.Users;
import com.example.demo.repositories.Clients_Repository;
import com.example.demo.services.Cart_Service;
import com.example.demo.services.Clients_Service;
import com.example.demo.services.Users_Service;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Clients1 {
	@Autowired
	Clients_Service cc;
	
	@Autowired
	Users_Service uc;
	
	@Autowired
	Cart_Service cs;
	
	@PostMapping("/clients")
	public Clients registerClient(@RequestBody Clients_Register cr )
	{
		Users user=new Users(cr.getMobile_number(),Security.PasswordEncription(cr.getPassword()),"Clients");
		
		Users inserted=uc.add(user);
		Clients client=new Clients();
		client.setFirst_name(cr.getFirst_name());
		client.setLast_name(cr.getLast_name());
		client.setCity(cr.getCity());
		client.setPincode(cr.getPincode());
		client.setState(cr.getState());
		
		client.setUser_id(inserted);
		
		return cc.add(client);
	}
	
	@GetMapping("/allClients")
	public List<Clients> getAll(){
		return cc.getAll();
	}
	
	@PutMapping("/updateClient/{id}")
	public Clients UpdateServiceProvider(@PathVariable int id,@RequestBody Clients_Register rClient) {
		System.out.println(rClient.toString());
		return cc.UpdateClient(id, rClient);
	}
	
}
