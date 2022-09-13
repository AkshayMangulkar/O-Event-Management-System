package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Category_Entity;
@Transactional
@Repository
public interface Category_Repository extends JpaRepository<Category_Entity, Integer> {

}
