package com.carwash.cardpayment.model;

public class Request {
	
	private String httpMethod;
	private String id;
	private Card card;
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
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}


	
	

}
