package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.Feedbacks_Service;

@RestController
public class Feedbacks {
	@Autowired
	Feedbacks_Service fc;

}
