package com.globallogic.demojpa.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="employee")
public class MerchantEntity {
	
	

	@Override
	public String toString() {
		return "MerchantEntity [id=" + id + ", name=" + name + ", pincode=" + pincode + ", GSTnum=" + GSTnum+", location= " + location +"]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column
	String name;
	
	@Column
	int pincode;
	

	@Column
	int GSTnum;
	
	@Column
	String location;
	
	
	

	

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
	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public int getGSTnum() {
		return GSTnum;
	}

	public void setGSTnum(int GSTnum) {
		this.GSTnum = GSTnum;
	}
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


}
