package com.aws.global.classes;

import java.sql.Date;

public class Transaction {
	//declaration of attributes
	private int transactionId;
	private int payment;
	private String customer;
	private Date payDate;
	
	//setters and getters for each attribute
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
}
