package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Clients;
import com.example.demo.entities.Service_Providers;
import com.example.demo.entities.Users;
import com.example.demo.repositories.Clients_Repository;

import com.example.demo.repositories.Service_Providers_Repository;
import com.example.demo.repositories.Users_repository;

@Service
public class Login_Service {
	
	@Autowired
	Users_repository lr;
	
	@Autowired
	Clients_Repository cr;
	
	@Autowired
	Service_Providers_Repository sp;
	
	public Object checkLogin(String mobno,String pass)
	{
		List<Users> l=lr.checkLogin(mobno, pass);
		
		if(l.size()==1)
		{
			Clients c=null;
			if(l.get(0).getUser_type().equals("Clients"))//getting type
			{
				System.out.println((l.get(0)));
				Optional<Clients> op=cr.getByUserId(l.get(0));//getting id
				try {
					c=op.get();
					System.out.println(op.get());
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			else if(l.get(0).getUser_type().equals("Service_Provider"))
			{
				Service_Providers ps=null;
			Optional<Service_Providers> op=sp.getByUserId(l.get(0));//getting id
				try {
					ps=op.get();
					System.out.println(op.get());
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				return ps;
			}
			System.out.println(c);
			return c;
			
		}	
		
		
			else
			{
				return null;
			}
	
		}
}
	
	
	



