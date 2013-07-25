package com.aws.global.classes;

public class Sales {
	//declaration of attributes
	private boolean dineType;
	private String pizzaName;
	private int quantity;
	private int pizzaPrice;
	private int totalPrice;
	private String customerName;
	private int payment;
	
	//Getter and Setter for each attribute
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public int getPizzaPrice() {
		return pizzaPrice;
	}
	public void setPizzaPrice(int pizzaPrice) {
		this.pizzaPrice = pizzaPrice;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public boolean isDineType() {
		return dineType;
	}
	public void setDineType(boolean dineType) {
		this.dineType = dineType;
	}
}
