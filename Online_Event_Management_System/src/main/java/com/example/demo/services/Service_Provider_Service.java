package com.example.demo.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Address;
import com.example.demo.entities.Registration_SP_POJO;
import com.example.demo.entities.Security;
import com.example.demo.entities.Service_Providers;
import com.example.demo.entities.Users;
import com.example.demo.repositories.Address_Repository;
import com.example.demo.repositories.Service_Providers_Repository;
import com.example.demo.repositories.Users_repository;

@Service
public class Service_Provider_Service {

	@Autowired
	Service_Providers_Repository sps;
	
	@Autowired
	Users_repository urepo;
	
	@Autowired
	Address_Repository adRepo;
	
	public Service_Providers saveSP(Registration_SP_POJO rSp) {
		Address ad=new Address(rSp.getArea(), rSp.getCity(), rSp.getPincode(), rSp.getState());
		
		Users u=new Users(rSp.getMobile_number(), Security.PasswordEncription(rSp.getPassword()), "Service_Provider");
		
		Service_Providers sp=new Service_Providers(rSp.getFirst_name(), rSp.getLast_name(),rSp.getBusiness_name(), u, ad);
		
		return sps.save(sp);
		
	}
	public Service_Providers getServ_ProviderByUser_Id(Users u ) {
	    Optional<Service_Providers> s=	sps.getByUserId(u);
	    Service_Providers result;
	    try {
	    	result=s.get();
	    }
	    catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return result;
		
	}
	
	public List<Service_Providers> getAll(){
		return sps.findAll();
	}
	
	public int UpdateServPro(int id,Registration_SP_POJO svpojo) {
		int result=0;
		Optional<Service_Providers> ops=sps.findById(id);
		try {
			Service_Providers servPro=ops.get();
			servPro.setFirst_name(svpojo.getFirst_name());
			servPro.setLast_name(svpojo.getLast_name());
			servPro.getUser_id().setMobile_number(svpojo.getMobile_number());
			servPro.setBusiness_name(svpojo.getBusiness_name());
			servPro.getAddress_id().setArea(svpojo.getArea());
			servPro.getAddress_id().setCity(svpojo.getCity());
			servPro.getAddress_id().setPincode(svpojo.getPincode());
			servPro.getAddress_id().setState(svpojo.getState());
			
			sps.save(servPro);
			result=1;
		
		} catch (Exception e) {
			System.out.println(e);
			result=0;
		}
		return result;
	}
}
