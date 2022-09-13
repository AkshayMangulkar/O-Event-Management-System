package com.example.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;
import com.example.demo.repositories.Users_repository;

@Service
public class Users_Service {
	@Autowired
	Users_repository us;
	
	/*public Users getByMobileNumber(String mob_num)
	{
		return us.getByMobileNumber(mob_num) ;
	}*/
	public Users add(Users u)
	{
		return us.save(u);//adding records in users table
	}
	


}
