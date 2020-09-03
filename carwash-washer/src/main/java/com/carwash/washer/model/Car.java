package com.carwash.washer.model;




public class Car {

	private String id;
	private String owner;
	private String type;
	private String model;
	
	public Car() {}

	public Car(String id, String owner, String type, String model) {
		super();
		this.id = id;
		this.owner = owner;
		this.type = type;
		this.model = model;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
