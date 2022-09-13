package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.Category_Repository;

@Service
public class Category_Service {
	@Autowired
	Category_Repository cr;

}
