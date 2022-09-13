package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Contacts_Entity;
@Transactional
@Repository
public interface Contacts_Repository extends JpaRepository<Contacts_Entity, Integer> {

}
