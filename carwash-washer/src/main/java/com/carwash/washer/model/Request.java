package com.carwash.washer.model;

public class Request {
	
	private String httpMethod;
	private String id;
	private Appointment appointment;
	private Washer washer;
	
	public Washer getWasher() {
		return washer;
	}
	public void setWasher(Washer washer) {
		this.washer = washer;
	}
	public String getHttpMethod() {
		return httpMethod;
	}
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	
	

}
