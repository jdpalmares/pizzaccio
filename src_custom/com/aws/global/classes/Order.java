package com.aws.global.classes;

public class Order {
	//declaration of attributes
	private int orderId;
	private int pizzaId;
	private int quantity;
	private boolean dineType;
	private boolean cancelStatus;
	private int transactionId;
	
	//setters and getters for each attribute
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isDineType() {
		return dineType;
	}
	public void setDineType(boolean dineType) {
		this.dineType = dineType;
	}
	public boolean isCancelStatus() {
		return cancelStatus;
	}
	public void setCancelStatus(boolean cancelStatus) {
		this.cancelStatus = cancelStatus;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
}
