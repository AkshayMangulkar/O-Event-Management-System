package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="photos")
public class Photos_Entity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int photo_id;
	@Column
	String photo_path;
	@Column
	int service_id;
	public Photos_Entity() {
		super();
	}
	public Photos_Entity(String photo_path, int service_id) {
		super();
		this.photo_path = photo_path;
		this.service_id = service_id;
	}
	public int getPhoto_id() {
		return photo_id;
	}
	public void setPhoto_id(int photo_id) {
		this.photo_id = photo_id;
	}
	public String getPhoto_path() {
		return photo_path;
	}
	public void setPhoto_path(String photo_path) {
		this.photo_path = photo_path;
	}
	public int getService_id() {
		return service_id;
	}
	public void setService_id(int service_id) {
		this.service_id = service_id;
	}
	@Override
	public String toString() {
		return "Photos_Entity [photo_id=" + photo_id + ", photo_path=" + photo_path + ", service_id=" + service_id
				+ "]";
	}
	
	

}
