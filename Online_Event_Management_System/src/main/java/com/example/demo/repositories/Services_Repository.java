package com.example.demo.repositories;

import java.util.List;

import javax.persistence.NamedNativeQueries;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Services;
@Transactional
@Repository
public interface Services_Repository extends JpaRepository<Services, Integer> {
	
	@Query("select s from Services s")
	public List<Services> getAll();
	
	
	
}
