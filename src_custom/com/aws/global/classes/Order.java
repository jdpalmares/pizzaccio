package com.aws.global.classes;

public class Order {
	//declaration of attributes
	private int orderId;
	private int pizzaId;
	private String pizzaName;
	private int quantity;
	private boolean dineType;
	private boolean cancelStatus;
	private int transactionId;
	private int unitPrice;
	private int subTotal;
	
	//setters and getters for each attribute
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the pizzaId
	 */
	public int getPizzaId() {
		return pizzaId;
	}
	/**
	 * @param pizzaId the pizzaId to set
	 */
	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
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
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}
}
