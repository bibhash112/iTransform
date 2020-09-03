package com.carwash.washer.model;

public class Washer {
	
	public String userID;
	public String name;
	public String Email;
	public String password;
	
	public Washer(String userID, String name, String Email, String password) {
		super();
		this.userID = userID;
		this.name = name;
		this.Email = Email;
		this.password = password;
	}
	public Washer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Washer(String userID, String name) {
		super();
		this.userID = userID;
		this.name = name;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
