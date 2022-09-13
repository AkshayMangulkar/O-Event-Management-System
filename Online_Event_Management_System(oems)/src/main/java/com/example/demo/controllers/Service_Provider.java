package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.ServiceProviderRegister;
import com.example.demo.entities.Service_Providers;
import com.example.demo.entities.Users;
import com.example.demo.services.Service_Provider_Service;
import com.example.demo.services.Users_Service;
@CrossOrigin(origins = "http://localhost:3001")
@RestController
public class Service_Provider {
	@Autowired
	Service_Provider_Service spc;
	
	@Autowired
	Users_Service uc;
	
	@PostMapping("/serviceProvider")
	public Service_Providers registerServiceProvider(@RequestBody ServiceProviderRegister sr )
	{
		Users user=new Users(sr.getMobile_number(),sr.getPassword(),"service provider");
		Users inserted=uc.add(user);
		Service_Providers sprovider=new Service_Providers();
		sprovider.setFirst_name(sr.getFirst_name());
		sprovider.setLast_name(sr.getLast_name());
		sprovider.setBusiness_name(sr.getBusiness_name());
		sprovider.setUser_id(inserted);
		return spc.add(sprovider);
	}

}
