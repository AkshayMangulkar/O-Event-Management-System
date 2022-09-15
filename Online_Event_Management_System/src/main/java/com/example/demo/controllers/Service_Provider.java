package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.Service_Provider_Service;

@RestController
public class Service_Provider {
	@Autowired
	Service_Provider_Service spc;

}
