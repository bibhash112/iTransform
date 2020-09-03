package com.carwash.cardpayment.model;

public class Card {
	private String id;
	private String holderName;
	private String cardType;
	private String cardNumber;
	private boolean success;
	
	public Card() {}
	public Card(String id, String holderName, String cardType, String cardNumber) {
		super();
		this.id = id;
		this.holderName = holderName;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
}
