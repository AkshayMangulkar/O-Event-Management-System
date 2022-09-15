package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Users;
import com.example.demo.services.Login_Service;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LoginController {
	@Autowired
	Login_Service lservice;
	@PostMapping("/checkLogin")
	public Object checkLogin(@RequestBody Users u)
	{
		return lservice.checkLogin(u.getMobile_number(),u.getPassword());
	}

}
