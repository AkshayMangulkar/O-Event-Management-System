package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Clients {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int client_id;
	
	@Column
	String first_name;
	@Column
	String last_name;
	@Column
	String city;
	@Column
	int user_id;
	@Column
	String state;
	@Column
	int pincode;
	public Clients() {
		super();
	}
	public Clients(int client_id, String first_name, String last_name, String city, int user_id, String state,
			int pincode) {
		super();
		this.client_id = client_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.city = city;
		this.user_id = user_id;
		this.state = state;
		this.pincode = pincode;
	}
	public int getClient_id() {
		return client_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public String getCity() {
		return city;
	}
	public int getUser_id() {
		return user_id;
	}
	public String getState() {
		return state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Clients [client_id=" + client_id + ", first_name=" + first_name + ", last_name=" + last_name + ", city="
				+ city + ", user_id=" + user_id + ", state=" + state + ", pincode=" + pincode + "]";
	}
	
	

}
