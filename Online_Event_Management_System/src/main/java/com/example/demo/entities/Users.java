package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int user_id;
	
	@Column
	String mobile_number;
	
	@Column
	String password;
	
	@Column
	String user_type;
	
	public Users() {
		super();
	}
	public Users( String mobile_number, String password, String user_type) {
		super();
		
		this.mobile_number = mobile_number;
		this.password = password;
		this.user_type = user_type;
	}
	public int getUser_id() {
		return user_id;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public String getPassword() {
		return password;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", mobile_number=" + mobile_number + ", password=" + password
				+ ", user_type=" + user_type + "]";
	}
	
	
	

}
