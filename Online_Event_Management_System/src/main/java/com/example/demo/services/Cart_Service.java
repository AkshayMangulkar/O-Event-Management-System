package com.example.demo.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Cart;
import com.example.demo.entities.Services;
import com.example.demo.repositories.Cart_Repo;

@Service
public class Cart_Service {
	@Autowired
	Cart_Repo cr;
	
	public Set<Services> AddServ(int cart_id,Services s){
		Optional<Cart> c=cr.findById(cart_id);
		if(!c.isEmpty()) {
			c.get().AddService(s);
			
		}
		return c.get().getServiceList();
	}
}
