package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Booking_POJO;
import com.example.demo.entities.Bookings_View;
import com.example.demo.entities.Clients;
import com.example.demo.entities.Service_Providers;
import com.example.demo.entities.Users;
import com.example.demo.repositories.Clients_Repository;
import com.example.demo.repositories.Users_repository;
import com.example.demo.services.Booking_View_Service;
import com.example.demo.services.Service_Provider_Service;
import com.example.demo.services.Users_Service;

@CrossOrigin(value = "http://localhost:3000")
@RestController
public class Booking_controller {
	@Autowired
	Booking_View_Service bvc;
	
	@Autowired
	Users_Service US;
	
	@Autowired
	Clients_Repository cr;
	
	@Autowired
	Users_repository Urepo;
	
	
	@Autowired
	Service_Provider_Service SPS;
	
	@PostMapping("/saveBooking")
	public Bookings_View saveBooking(@RequestBody Booking_POJO bkpojo) {
		if(bkpojo.getService_id().length==0)return null;
		
		return bvc.saveBooking(bkpojo);
	}
	
	@GetMapping("/getAllBookings")
	public List<Bookings_View> getAllBookings(){
		return bvc.getAllBookings();
	}
	
	@GetMapping("/getAllBookingsByClient_id")
	public List<Bookings_View> getAllBookingsByClientId(@RequestParam int Client_id){
		Clients c1=US.getUserById(Client_id);
		
		return bvc.getAllBookingsByClientId(c1.getClient_id());
	}
	
	@PatchMapping("/acceptBooking")
	public int acceptbooking(@RequestParam int id) {
		System.out.println(id);
	    return	bvc.AcceptBooking(id);
	}
	
	@GetMapping("/getAllBookingsByService_Provider_id")
	public List<Bookings_View> getAllBookingsByServiceProvider_id(@RequestParam int u_id){
		
		Optional<Users> u= Urepo.findById(u_id);
		
		Service_Providers serv_Pro= SPS.getServ_ProviderByUser_Id(u.get());
		
		return bvc.getAllBookingsByServiceProvider_id(serv_Pro.getService_provider_id());
	}
}
