package com.example.demo.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	Date booking_date;
	@Column
	String booking_status;
	@Column
	int client_id;
	public Bookings_View() {
		super();
	}
	public Bookings_View(int booking_id, double total_price, Date booking_date, String booking_status, int client_id) {
		super();
		this.booking_id = booking_id;
		this.total_price = total_price;
		this.booking_date = booking_date;
		this.booking_status = booking_status;
		this.client_id = client_id;
	}
	public int getBooking_id() {
		return booking_id;
	}
	public double getTotal_price() {
		return total_price;
	}
	public Date getBooking_date() {
		return booking_date;
	}
	public String getBooking_status() {
		return booking_status;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	public void setBooking_date(Date booking_date) {
		this.booking_date = booking_date;
	}
	public void setBooking_status(String booking_status) {
		this.booking_status = booking_status;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	@Override
	public String toString() {
		return "Bookings_View [booking_id=" + booking_id + ", total_price=" + total_price + ", booking_date="
				+ booking_date + ", booking_status=" + booking_status + ", client_id=" + client_id + "]";
	}
	
	

}
