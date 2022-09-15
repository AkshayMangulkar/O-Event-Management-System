package com.example.demo.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Clients;
import com.example.demo.entities.Service_Providers;
import com.example.demo.entities.Users;
@Transactional
@Repository
public interface Service_Providers_Repository extends JpaRepository<Service_Providers, Integer> {
	@Query("select c from Service_Providers c where user_id=:userId ")
	public Optional<Service_Providers> getByUserId(Users userId);
}
