package com.example.demo.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cart_id;
	
	
	@OneToMany( cascade = CascadeType.ALL)
	//@Column - not associated
	Set<Services> serviceList;

	public Cart() {
		super();
	}

	public Cart(Set<Services> serviceList) {
		super();
		
		this.serviceList = serviceList;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public Set<Services> getServiceList() {
		System.out.println(serviceList);
		return serviceList;
		
	}

	public void setServiceList(Set<Services> serviceList) {
		this.serviceList = serviceList;
	}
	
	public boolean AddService(Services s) {
		return this.serviceList.add(s);
	}

	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", serviceList=" + serviceList + "]";
	} 
	
	
}
