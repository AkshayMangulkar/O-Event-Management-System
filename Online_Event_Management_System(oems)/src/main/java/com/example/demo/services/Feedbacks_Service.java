package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.Feedbacks_Repository;

@Service
public class Feedbacks_Service {

	@Autowired
	Feedbacks_Repository fr;
}
