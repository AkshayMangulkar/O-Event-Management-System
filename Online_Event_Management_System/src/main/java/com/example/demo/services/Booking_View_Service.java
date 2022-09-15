package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.Bookings_View_Repositories;

@Service
public class Booking_View_Service {
	@Autowired
	Bookings_View_Repositories bvr;

}
