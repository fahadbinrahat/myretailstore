package com.myretailstore.api.onlineorders.dao;

public class Price {
	
	private double amount;
	private priceCurrency currency;
	
	public static enum priceCurrency{
		AUD, USD, EUR
	}

	public Price() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Price(double amount, priceCurrency currency) {
		super();
		this.amount = amount;
		this.currency = currency;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public priceCurrency getCurrency() {
		return currency;
	}

	public void setCurrency(priceCurrency currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Price [amount=" + amount + ", currency=" + currency + "]";
	}
	
	
	

}
