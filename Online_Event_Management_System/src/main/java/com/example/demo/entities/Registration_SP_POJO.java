package com.example.demo.entities;


public class Registration_SP_POJO {

	String first_name;
	String last_name;
	String business_name;
	String mobile_number;
	String password;
	String area;
	String city;
	int pincode;
	String state;
	
	public Registration_SP_POJO() {
		super();
	}
	public Registration_SP_POJO(String first_name, String last_name, String business_name, String mobile_number,
			String password, String area, String city, int pincode, String state) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.business_name = business_name;
		this.mobile_number = mobile_number;
		this.password = password;
		this.area = area;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
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
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
		return "Registration_SP_POJO [first_name=" + first_name + ", last_name=" + last_name + ", business_name="
				+ business_name + ", mobile_number=" + mobile_number + ", password=" + password + ", area=" + area
				+ ", city=" + city + ", pincode=" + pincode + ", state=" + state + "]";
	}
	
	
}
