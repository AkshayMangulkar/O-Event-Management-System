package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Photos_Entity;
@Transactional
@Repository
public interface Photo_Repository extends JpaRepository<Photos_Entity, Integer> {

}
