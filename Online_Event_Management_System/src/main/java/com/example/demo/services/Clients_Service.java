package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Clients;
import com.example.demo.entities.Clients_Register;
import com.example.demo.entities.Service_Providers;
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
	
	public Clients UpdateClient(int id,Clients_Register rClient) {
		Clients result = null;
		Optional<Clients> opClient=cr.findById(id);
		try {
			Clients clientObject=opClient.get();
			clientObject.setFirst_name(rClient.getFirst_name());
			clientObject.setLast_name(rClient.getLast_name());
			clientObject.getUser_id().setMobile_number(rClient.getMobile_number());
			clientObject.setCity(rClient.getCity());
			clientObject.setPincode(rClient.getPincode());
			clientObject.setState(rClient.getState());
			
			result=cr.save(clientObject);
			return result;
		
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	
	}

}
