package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.Services_Repository;

@Service
public class Services_Service {
	@Autowired
	Services_Repository ss;
	

}
