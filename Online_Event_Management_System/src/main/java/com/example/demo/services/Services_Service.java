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
		
		return ls;
	}
	
	public List<Services> getAllByServPro(int serv_Pro_id){
		List<Services> ls =ss.getAll();
		List<Services> result=ls.stream().filter(s->s.getService_provider_id().getService_provider_id()==serv_Pro_id).toList();
		return result;
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
	public Services getService(int id) {
		
		Optional<Services> os=ss.findById(id);
		if(os.isEmpty())return null;
		else {
			return os.get();
		}
		
	}
	
	public int UpdateService(int id,Register_Service_POJO serv) {
		Optional<Services> service=ss.findById(id);
		try {
			Services s= service.get();
			s.setService_name(serv.getService_name());
			s.setCost(serv.getCost());
			s.setDescription(serv.getDescription());
			ss.save(s);
			return 1;
		}
		catch(Exception e) {
			System.out.println(e);
			return 0;
		}
	}

	

}
