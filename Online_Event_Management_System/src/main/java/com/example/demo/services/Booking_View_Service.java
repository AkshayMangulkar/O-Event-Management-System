package com.example.demo.services;



import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entities.Booking_POJO;
import com.example.demo.entities.Bookings_View;
import com.example.demo.entities.Clients;
import com.example.demo.entities.Services;
import com.example.demo.repositories.Bookings_View_Repositories;
import com.example.demo.repositories.Clients_Repository;
import com.example.demo.repositories.Services_Repository;

import net.bytebuddy.agent.builder.AgentBuilder.FallbackStrategy.Simple;

@Service
public class Booking_View_Service {
	@Autowired
	Bookings_View_Repositories bvr;
	
	@Autowired
	Clients_Repository crepo;
	
	@Autowired
	Services_Repository serv;
	
	
	public Bookings_View saveBooking(Booking_POJO bkpojo) {
		java.util.Date curdate=new java.util.Date();

		java.util.Date sdf=null;
		
		try {
			sdf=new SimpleDateFormat("yyyy-MM-dd").parse(bkpojo.getEvent_date());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date dt=new Date(curdate.getTime());

		Date evdt=new Date(sdf.getTime());
		System.out.println(evdt);
		double total=0;
		Optional<Clients> c=crepo.findById(bkpojo.getC_id());
		List<Services> servlist=new ArrayList<Services>();
		int [] arr=bkpojo.getService_id();
		for(int i=0;i<arr.length;i++) {
			Optional<Services> op=serv.findById(arr[i]);
			servlist.add(op.get());
			total+=op.get().getCost();
		}
		
		Bookings_View bkv=new Bookings_View();
		bkv.setBooked_services(servlist);
		bkv.setBooking_date(dt);
		bkv.setBooking_status("pending");
		bkv.setClient(c.get());
		bkv.setTotal_price(total);
		bkv.setEvent_date(evdt);
		return bvr.save(bkv);
	}
	
	public List<Bookings_View> getAllBookings(){
		return bvr.findAll();
	}
	
	public int AcceptBooking(int id) {
		Bookings_View breturn=null;
	    Optional<Bookings_View> opb=bvr.findById(id);
	    if(!opb.isEmpty()) {
	    	Bookings_View b1=opb.get();
	    	b1.setBooking_status("Accepted");
	    	breturn =bvr.save(b1);
	    	return 1;
	    }
	    return 0;
	}
	
	public List<Bookings_View> getAllBookingsByClientId(int id){
		List<Bookings_View> list=bvr.findAll();
		List<Bookings_View> list_Cid=list.stream().filter(t -> t.getClient().getClient_id()==id).toList();
		return list_Cid;
	}
	
	public List<Bookings_View> getAllBookingsByServiceProvider_id(int s1){
		List<Bookings_View> list=bvr.findAll();
		List<Services> list_services=serv.findAll();
		List<Bookings_View> result=new ArrayList<Bookings_View>();
		for (Bookings_View b : list) {
			List<Services>l=b.getBooked_services();
			for (Services s : l) {
				if(s.getService_provider_id().getService_provider_id()== s1) {
					result.add(b);
				}
			}
		}
		
		return result;
	}

}
