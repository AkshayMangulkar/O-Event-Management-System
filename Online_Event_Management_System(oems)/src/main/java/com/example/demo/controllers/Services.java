package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.Service_Provider_Service;
import com.example.demo.services.Services_Service;

@RestController
public class Services {
	@Autowired
	Services_Service sc;

}
