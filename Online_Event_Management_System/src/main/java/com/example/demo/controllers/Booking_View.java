package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.Booking_View_Service;

@RestController
public class Booking_View {
	@Autowired
	Booking_View_Service bvc;

}
