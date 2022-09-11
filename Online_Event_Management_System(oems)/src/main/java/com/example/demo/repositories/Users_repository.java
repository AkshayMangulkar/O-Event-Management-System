package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Users;
@Repository
public interface Users_repository extends JpaRepository<Users, Integer> {
	
	
	/*@Query("select u from Users u where mobile_number=?1")
	public Users getByMobileNumber(String mob_num);
	*/

}
