package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Clients;
@Transactional
@Repository
public interface Clients_Repository extends JpaRepository<Clients, Integer> {

}
