package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;

@JsonSerializableSchema
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
	
	@OneToOne ( cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	Category category_id;
	
	@JsonIgnoreProperties("users")
	@OneToOne ( cascade = CascadeType.ALL)
	@JoinColumn(name = "service_provider_id")
	Service_Providers service_provider_id;

	public Services() {
		super();
	}

	public Services(String service_name, double cost, String description, Category category_id,
			Service_Providers service_provider_id) {
		super();
		
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

	public Category getCategory_id() {
		return category_id;
	}

	public Service_Providers getService_provider_id() {
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

	public void setCategory_id(Category category_id) {
		this.category_id = category_id;
	}

	public void setService_provider_id(Service_Providers service_provider_id) {
		this.service_provider_id= service_provider_id;
	}

	@Override
	public String toString() {
		return "Services [service_id=" + service_id + ", service_name=" + service_name + ", cost=" + cost
				+ ", description=" + description + ", category_id=" + category_id + ", service_provider_id="
				+ service_provider_id+ "]";
	}

	
	
	
	

}
