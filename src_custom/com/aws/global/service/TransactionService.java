package com.aws.global.service;

public interface TransactionService {
	
	//declaration of abstract methods
	public void addTransaction(int payment, String customer);
	
	public int getLatestTransactionId();
}
