package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Services;
@Transactional
@Repository
public interface Services_Repository extends JpaRepository<Services, Integer> {

}
