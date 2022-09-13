package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Clients;
import com.example.demo.entities.Service_Providers;
import com.example.demo.repositories.Service_Providers_Repository;

@Service
public class Service_Provider_Service {

	@Autowired
	Service_Providers_Repository sps;
	
	public Service_Providers add(Service_Providers sp)
	{
		return sps.save(sp);//adding records in Clients table
	}

}
