package com.example.demo.entities;

import java.util.Arrays;

public class Booking_POJO {
	String event_date;
	
	String b_status;
	
	int c_id;
	
	int []service_id;

	
	public Booking_POJO() {
		super();
	}

	public Booking_POJO(String event_date, String b_status,  int c_id, int[] service_id) {
		super();
		this.event_date = event_date;
		this.b_status = b_status;
		this.c_id = c_id;
		this.service_id = service_id;
	}

	

	public String getB_status() {
		return b_status;
	}

	public void setB_status(String b_status) {
		this.b_status = b_status;
	}

	

	public String getEvent_date() {
		return event_date;
	}

	public void setEvent_date(String event_date) {
		this.event_date = event_date;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public int[] getService_id() {
		return service_id;
	}

	public void setService_id(int[] service_id) {
		this.service_id = service_id;
	}

	@Override
	public String toString() {
		return "Booking_POJO [bdate=" + event_date + ", b_status=" + b_status + ", c_id="
				+ c_id + ", service_id=" + Arrays.toString(service_id) + "]";
	}
	
	

}
