package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Address_Entity;
@Transactional
@Repository
public interface Address_Repository extends JpaRepository<Address_Entity, Integer> {

}
