package com.example.demo.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Clients;
import com.example.demo.entities.Users;
import com.example.demo.repositories.Clients_Repository;
import com.example.demo.repositories.Users_repository;

@Service
public class Users_Service {
	@Autowired
	Users_repository us;
	
	@Autowired
	Clients_Repository cr;
	
	public Users getByMobileNumber(String mob_num)
	{
		List<Users> u=us.getByMobileNumber(mob_num);
		Users user=null;
		if(u.size()>0)
		{
			 user=u.get(0);
		}
		
		System.out.println(user);
		return user  ;
	}
	public Users add(Users u)
	{
		return us.save(u);//adding records in users table
	}
	
	public Clients getUserById(int id)
	{
		Optional<Users> u1=us.findById(id);
		if(u1.isEmpty())return null;
			
		Optional<Clients> c1=cr.getByUserId(u1.get());
		return c1.get()  ;//adding records in users table
	}

}
