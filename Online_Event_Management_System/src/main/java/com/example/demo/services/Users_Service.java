package com.example.demo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;
import com.example.demo.repositories.Users_repository;

@Service
public class Users_Service {
	@Autowired
	Users_repository us;
	
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

}
