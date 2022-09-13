package com.example.demo.entities;

public class Clients_Register {
	String mobile_number;
	
	String password;
	String first_name;
	String last_name;
	String city;
	String state;
	String user_type;
	int pincode;
	public Clients_Register() {
		super();
	}
	public Clients_Register(String mobile_number, String password, String first_name, String last_name, String city,
			String state, int pincode,String user_type) {
		super();
		this.mobile_number = mobile_number;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.user_type=user_type;
	}
	
public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
public String getMobile_number() {
	return mobile_number;
	}
	public String getPassword() {
		return password;
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
	public String getState() {
		return state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public void setState(String state) {
		this.state = state;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Clients_Register [mobile_number=" + mobile_number + ", password=" + password + ", first_name="
				+ first_name + ", last_name=" + last_name + ", city=" + city + ", state=" + state + ", pincode="
				+ pincode + "]";
	}
	

}
