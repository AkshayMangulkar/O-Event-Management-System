package com.example.demo.entities;

import javax.persistence.Column;

public class ServiceProviderRegister {
	
	
	String mobile_number;
	
	
	String password;
	
	String user_type;
	
	String first_name;
	
	String last_name;
	
	String business_name;

	public ServiceProviderRegister() {
		super();
	}

	public ServiceProviderRegister(String mobile_number, String password,String user_type, String first_name, String last_name,
			String business_name) {
		super();
		this.mobile_number = mobile_number;
		this.password = password;
		this.user_type=user_type;
		this.first_name = first_name;
		this.last_name = last_name;
		this.business_name = business_name;
	}

	

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
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

	public String getBusiness_name() {
		return business_name;
	}
	public String getMobile_number() {
		// TODO Auto-generated method stub
		return mobile_number;
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

	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}

	@Override
	public String toString() {
		return "ServiceProviderRegister [mobile_number=" + mobile_number + ", password=" + password + ", first_name="
				+ first_name + ", last_name=" + last_name + ", business_name=" + business_name + "]";
	}

	
	

}
