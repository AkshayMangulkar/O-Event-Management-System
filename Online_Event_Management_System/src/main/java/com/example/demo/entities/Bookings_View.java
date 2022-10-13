package com.example.demo.entities;

import java.sql.Date;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bookings")
public class Bookings_View {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int booking_id;
	
	@Column
	double total_price;
	
	@Column
	Date event_date;
	
	@Column
	Date booking_date;
	
	@Column
	String booking_status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id")
	Clients client;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name="booking_services",joinColumns= @JoinColumn(name="booking_id") ,inverseJoinColumns=@JoinColumn(name="service_id"))
	List<Services> booked_services;
	
	public Bookings_View() {
		super();
	}

	

	public Bookings_View(double total_price, Date event_date, Date booking_date, String booking_status, Clients client,
			List<Services> booked_services) {
		super();
		this.total_price = total_price;
		this.event_date = event_date;
		this.booking_date = booking_date;
		this.booking_status = booking_status;
		this.client = client;
		this.booked_services = booked_services;
	}



	public int getBooking_id() {
		return booking_id;
	}

	
	public Date getEvent_date() {
		return event_date;
	}



	public void setEvent_date(Date event_date) {
		this.event_date = event_date;
	}



	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public Date getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(Date booking_date) {
		this.booking_date = booking_date;
	}

	public String getBooking_status() {
		return booking_status;
	}

	public void setBooking_status(String booking_status) {
		this.booking_status = booking_status;
	}

	public Clients getClient() {
		return client;
	}

	public void setClient(Clients client) {
		this.client = client;
	}

	public List<Services> getBooked_services() {
		return booked_services;
	}

	public void setBooked_services(List<Services> booked_services) {
		this.booked_services = booked_services;
	}



	@Override
	public String toString() {
		return "Bookings_View [booking_id=" + booking_id + ", total_price=" + total_price + ", event_date=" + event_date
				+ ", booking_date=" + booking_date + ", booking_status=" + booking_status + ", client=" + client
				+ ", booked_services=" + booked_services + "]";
	}

	
	
	
	

}
