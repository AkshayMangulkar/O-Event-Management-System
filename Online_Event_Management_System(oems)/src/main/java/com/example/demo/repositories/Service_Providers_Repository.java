package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Service_Providers;
@Transactional
@Repository
public interface Service_Providers_Repository extends JpaRepository<Service_Providers, Integer> {

}
