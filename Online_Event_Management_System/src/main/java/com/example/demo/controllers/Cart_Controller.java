package com.example.demo.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Services;
import com.example.demo.services.Cart_Service;
import com.example.demo.services.Services_Service;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Cart_Controller {
	@Autowired
	Cart_Service cs;
	
	@Autowired
	Services_Service srs;
	
	@GetMapping("/addSerivceinCart")
	public Set<Services> AddServiceinCart(@RequestParam int cart_id, int s_id )
	{
		Services s= srs.getService(s_id);
		return cs.AddServ(cart_id, s);
	}
}
