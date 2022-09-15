package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Clients;
import com.example.demo.entities.Users;
@Transactional
@Repository
public interface Clients_Repository extends JpaRepository<Clients, Integer> {
	
	@Query("select c from Clients c where user_id=:userId ")
	public Optional<Clients> getByUserId(Users userId);

}
