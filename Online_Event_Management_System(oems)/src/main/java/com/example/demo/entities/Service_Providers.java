package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contacts")
public class Service_Providers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int service_provider_id;
	@Column
	String first_name;
	@Column
	String last_name;
	@Column
	String business_name;
	@Column
	int user_id;
	public Service_Providers() {
		super();
	}
	public Service_Providers(int service_provider_id, String first_name, String last_name, String business_name,
			int user_id) {
		super();
		this.service_provider_id = service_provider_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.business_name = business_name;
		this.user_id = user_id;
	}
	public int getService_provider_id() {
		return service_provider_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setService_provider_id(int service_provider_id) {
		this.service_provider_id = service_provider_id;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Service_Providers [service_provider_id=" + service_provider_id + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", business_name=" + business_name + ", user_id=" + user_id + "]";
	}
	
	

}
