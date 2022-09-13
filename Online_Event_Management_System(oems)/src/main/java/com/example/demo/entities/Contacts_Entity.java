package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="contacts")
public class Contacts_Entity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int service_provider_id;
	
	@Column
	String business_name;
	@Column
	String first_name;
	@Column
	String last_name;
	@Column
	int user_id;
	public Contacts_Entity() {
		super();
	}
	public Contacts_Entity(String business_name, String first_name, String last_name, int user_id) {
		super();
		this.business_name = business_name;
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_id = user_id;
	}
	public int getService_provider_id() {
		return service_provider_id;
	}
	public void setService_provider_id(int service_provider_id) {
		this.service_provider_id = service_provider_id;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Contacts_Entity [service_provider_id=" + service_provider_id + ", business_name=" + business_name
				+ ", first_name=" + first_name + ", last_name=" + last_name + ", user_id=" + user_id + "]";
	}
	
	

}
