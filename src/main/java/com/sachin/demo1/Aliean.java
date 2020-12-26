package com.sachin.demo1;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Table(name="table_name")
//@Column(name="column_name")
//@Transient
//@Embeddable
@Entity
public class Aliean {
	@Id
	private int id;
	private FullName fullName;
	private String color;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public FullName getFullName() {
		return fullName;
	}
	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Aliean [id=" + id + ", fullName=" + fullName + ", color=" + color + "]";
	}
	
	
}
