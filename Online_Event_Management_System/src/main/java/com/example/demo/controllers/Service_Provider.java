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

import com.example.demo.entities.Registration_SP_POJO;
import com.example.demo.entities.Service_Providers;
import com.example.demo.services.Service_Provider_Service;
@CrossOrigin(value = "http://localhost:3000")

@RestController
public class Service_Provider {
	@Autowired
	Service_Provider_Service spc;
	
	@PostMapping("/saveServiceProvider")
	public Service_Providers saveServiceProvider(@RequestBody Registration_SP_POJO rSp) {
		System.out.println(rSp.toString());
		return spc.saveSP(rSp);
	}
	
	@GetMapping("/getAllServiceProviders")
	public List<Service_Providers> getAllSP(){
		return spc.getAll();
	}
	
	@PutMapping("/updateServiceProvider/{id}")
	public int UpdateServiceProvider(@PathVariable int id,@RequestBody Registration_SP_POJO rSp) {
		System.out.println(rSp.toString());
		return spc.UpdateServPro(id, rSp);
	}
}
