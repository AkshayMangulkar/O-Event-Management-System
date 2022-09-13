package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address_Entity {

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
	int service_provider_id;

	public Address_Entity() {
		super();
	}

	public Address_Entity(String area, String city, int pincode, int service_provider_id) {
		super();
		this.area = area;
		this.city = city;
		this.pincode = pincode;
		this.service_provider_id = service_provider_id;
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

	public int getService_provider_id() {
		return service_provider_id;
	}

	public void setService_provider_id(int service_provider_id) {
		this.service_provider_id = service_provider_id;
	}

	@Override
	public String toString() {
		return "Address_Entity [address_id=" + address_id + ", area=" + area + ", city=" + city + ", pincode=" + pincode
				+ ", service_provider_id=" + service_provider_id + "]";
	}
	
}
