package com.carwash.cardetails.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="Car")
public class Car {
	
	@Id
	private int id;
	private String owner;
	private String type;
	private String model;
	
	public Car() {}

	public Car(int id, String owner, String type, String model) {
		super();
		this.id = id;
		this.owner = owner;
		this.type = type;
		this.model = model;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
    
	
	
	

}
