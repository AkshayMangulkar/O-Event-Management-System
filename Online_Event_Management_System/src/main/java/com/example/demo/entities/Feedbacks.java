package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feedbacks")

public class Feedbacks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int feedback_id;
	
	@Column
	int rating;
	
	@Column
	String comments;
	
	@Column
	int client_id;
	
	@Column
	int service_id;

	public Feedbacks() {
		super();
	}

	public Feedbacks(int feedback_id, int rating, String comments, int client_id, int service_id) {
		super();
		this.feedback_id = feedback_id;
		this.rating = rating;
		this.comments = comments;
		this.client_id = client_id;
		this.service_id = service_id;
	}

	public int getFeedback_id() {
		return feedback_id;
	}

	public int getRating() {
		return rating;
	}

	public String getComments() {
		return comments;
	}

	public int getClient_id() {
		return client_id;
	}

	public int getService_id() {
		return service_id;
	}

	public void setFeedback_id(int feedback_id) {
		this.feedback_id = feedback_id;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public void setService_id(int service_id) {
		this.service_id = service_id;
	}

	@Override
	public String toString() {
		return "Feedbacks [feedback_id=" + feedback_id + ", rating=" + rating + ", comments=" + comments
				+ ", client_id=" + client_id + ", service_id=" + service_id + "]";
	}
	
	

}
