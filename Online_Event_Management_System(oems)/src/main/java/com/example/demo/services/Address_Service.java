package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.Address_Repository;

@Service
public class Address_Service {
	@Autowired
	Address_Repository ar;

}
