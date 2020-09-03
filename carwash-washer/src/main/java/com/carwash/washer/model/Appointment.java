package com.carwash.washer.model;

import java.util.Date;

public class Appointment {
	
	public Washer washer;
	public Car car;
	public Date date;
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Appointment(Washer washer, Car car, Date date) {
		super();
		this.washer = washer;
		this.car = car;
		this.date = date;
	}
	public Washer getWasher() {
		return washer;
	}
	public void setWasher(Washer washer) {
		this.washer = washer;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
