package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.Address_Service;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Address_Controller {
	@Autowired
	Address_Service as;

}
