package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="services")
public class Services {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int service_id;
	
	@Column
	String service_name;
	
	@Column
	double cost;
	
	@Column
	String description;
	
	@Column
	int category_id;
	
	@Column
	int service_provider_id;

	public Services() {
		super();
	}

	public Services(int service_id, String service_name, double cost, String description, int category_id,
			int service_provider_id) {
		super();
		this.service_id = service_id;
		this.service_name = service_name;
		this.cost = cost;
		this.description = description;
		this.category_id = category_id;
		this.service_provider_id = service_provider_id;
	}

	public int getService_id() {
		return service_id;
	}

	public String getService_name() {
		return service_name;
	}

	public double getCost() {
		return cost;
	}

	public String getDescription() {
		return description;
	}

	public int getCategory_id() {
		return category_id;
	}

	public int getService_provider_id() {
		return service_provider_id;
	}

	public void setService_id(int service_id) {
		this.service_id = service_id;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public void setService_provider_id(int service_provider_id) {
		this.service_provider_id = service_provider_id;
	}

	@Override
	public String toString() {
		return "Services [service_id=" + service_id + ", service_name=" + service_name + ", cost=" + cost
				+ ", description=" + description + ", category_id=" + category_id + ", service_provider_id="
				+ service_provider_id + "]";
	}
	
	
	

}
