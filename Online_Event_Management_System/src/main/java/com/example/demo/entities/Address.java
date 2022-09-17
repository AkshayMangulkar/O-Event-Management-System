package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int address_id;
	
	@Column
	String area;
	
	@Column
	String city;
	
	@Column
	int pincode;
	
	@Column
	String state;

	public Address() {
		super();
	}

	public Address( String area, String city, int pincode, String state) {
		super();
		
		this.area = area;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", area=" + area + ", city=" + city + ", pincode=" + pincode
				+ ", state=" + state + "]";
	}
	
	
}
