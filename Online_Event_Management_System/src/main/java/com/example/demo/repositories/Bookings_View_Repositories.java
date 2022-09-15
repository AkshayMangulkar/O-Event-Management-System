package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Bookings_View;

@Transactional
@Repository
public interface Bookings_View_Repositories extends JpaRepository<Bookings_View, Integer> {

}
