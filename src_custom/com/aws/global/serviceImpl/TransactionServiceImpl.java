package com.aws.global.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.aws.global.dao.TransactionDAO;
import com.aws.global.service.TransactionService;

public class TransactionServiceImpl implements TransactionService{

	//Autowired variables
	@Autowired
	@Qualifier("transactionDAO")
	private TransactionDAO transactionDAO;
		
	//Overridden methods
	@Override
	public void addTransaction(int payment, String customer) {
		// TODO Auto-generated method stub
		transactionDAO.addTransaction(payment, customer);
	}

	@Override
	public int getLatestTransactionId() {
		// TODO Auto-generated method stub
		int id = transactionDAO.getLatestTransactionId();
		return id;
	}

}
