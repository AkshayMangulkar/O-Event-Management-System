package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.Contacts_Repository;

@Service
public class Contacts_Service {
	@Autowired
	Contacts_Repository co_r;

}
