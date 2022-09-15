package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Users;
@Repository
public interface Users_repository extends JpaRepository<Users, Integer> {
	
	
	@Query("select u from Users u where mobile_number=?1")
	public List<Users> getByMobileNumber(String mob_num);
	
	@Query("select u from Users u where mobile_number=:mobno and password=:pass ")
	public List<Users> checkLogin(String mobno,String pass);
	

}
