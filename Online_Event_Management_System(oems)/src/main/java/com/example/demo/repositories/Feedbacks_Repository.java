package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Feedbacks;
@Transactional
@Repository
public interface Feedbacks_Repository extends JpaRepository<Feedbacks, Integer> {

}
