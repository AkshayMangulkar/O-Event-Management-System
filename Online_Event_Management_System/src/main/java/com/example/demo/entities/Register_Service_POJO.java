package com.example.demo.entities;

public class Register_Service_POJO {
	
	String service_name;
	double cost;
	String description;
	int category_id;
	int service_provider_id;
	public Register_Service_POJO() {
		super();
	}
	public Register_Service_POJO(String service_name, double cost, String description, int category_id,
			int service_provider_id) {
		super();
		this.service_name = service_name;
		this.cost = cost;
		this.description = description;
		this.category_id = category_id;
		this.service_provider_id = service_provider_id;
	}
	public String getService_name() {
		return service_name;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getService_provider_id() {
		return service_provider_id;
	}
	public void setService_provider_id(int service_provider_id) {
		this.service_provider_id = service_provider_id;
	}
	@Override
	public String toString() {
		return "Register_Service_POJO [service_name=" + service_name + ", cost=" + cost + ", description=" + description
				+ ", category_id=" + category_id + ", service_provider_id=" + service_provider_id + "]";
	}
	

}
