package com.sachin.demo1;

import javax.persistence.Embeddable;

@Embeddable
public class FullName {

	private String fname,lname,mname;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	@Override
	public String toString() {
		return "FullName [fname=" + fname + ", lname=" + lname + ", mname=" + mname + "]";
	}
	
}
