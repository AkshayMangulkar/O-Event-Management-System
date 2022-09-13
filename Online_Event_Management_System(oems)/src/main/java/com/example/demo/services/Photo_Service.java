package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.Photo_Repository;

@Service
public class Photo_Service {
	@Autowired
	Photo_Repository pr;

}
