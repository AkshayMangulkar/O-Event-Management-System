package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category_Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int category_id;
	@Column
	String category_name;
	public Category_Entity() {
		super();
	}
	public Category_Entity(String category_name) {
		super();
		this.category_name = category_name;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	@Override
	public String toString() {
		return "Category_Entity [category_id=" + category_id + ", category_name=" + category_name + "]";
	}
	
}
