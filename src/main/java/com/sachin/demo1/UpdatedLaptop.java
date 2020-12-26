package com.sachin.demo1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UpdatedLaptop {

	@Id
	private int id;
	private String name;
	private int price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "UpdatedLaptop [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
}
