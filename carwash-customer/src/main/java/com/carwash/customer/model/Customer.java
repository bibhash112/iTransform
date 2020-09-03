package com.carwash.customer.model;

public class Customer {
	
	private String customerId;
	private String customerName;
	private String carType;
	private String carModel;
	private String addressLine1;
	private String addressLine2;
	private String city;
	

	public Customer() {}

	public Customer(String customerId, String customerName, String carType, String carModel, String addressLine1,
			String addressLine2, String city) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.carType = carType;
		this.carModel = carModel;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}				

}
