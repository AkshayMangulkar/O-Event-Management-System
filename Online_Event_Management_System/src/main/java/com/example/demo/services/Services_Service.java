package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Category;
import com.example.demo.entities.Register_Service_POJO;
import com.example.demo.entities.Service_Providers;
import com.example.demo.entities.Services;
import com.example.demo.repositories.Category_Repository;
import com.example.demo.repositories.Service_Providers_Repository;
import com.example.demo.repositories.Services_Repository;

@Service
public class Services_Service {
	@Autowired
	Services_Repository ss;
	
	@Autowired
	Category_Repository cr;
	
	@Autowired
	Service_Providers_Repository spr;
	
	public List<Services> getAll(){
		List<Services> ls =ss.getAll();
		System.out.println(ls.size());
		return ls;
	}
	
	public Services SaveService(Register_Service_POJO ser) {
		Services s=null;
		List<Category> ct=cr.getByCatId(ser.getCategory_id());
		System.out.println(ct.size());
		if(ct.size()!=0) {
			Optional<Service_Providers> st=spr.findById(ser.getService_provider_id());
			System.out.println(st);
			if(st.get()!=null)
			{
				s=new Services(ser.getService_name(), ser.getCost(), ser.getDescription(),ct.get(0), st.get());
			}
			ss.save(s);
		}
		return s;
	}

	

}
