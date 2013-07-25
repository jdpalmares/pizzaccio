package com.aws.global.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.aws.global.classes.Sales;
import com.aws.global.dao.SalesDAO;
import com.aws.global.service.SalesService;

public class SalesServiceImpl implements SalesService{

	//Autowired variables
	@Autowired
	@Qualifier("salesDAO")
	private SalesDAO salesDAO;
		
	@Override
	public ArrayList<Sales> getTodaySales() {
		// TODO Auto-generated method stub
		ArrayList<Sales> sales = salesDAO.getTodaySales();
		return sales;
	}

	@Override
	public int getMoneyInHandToday() {
		// TODO Auto-generated method stub
		int x = salesDAO.getMoneyInHandToday();
		return x;
	}

	@Override
	public int getTotalSalesToday() {
		// TODO Auto-generated method stub
		int x = salesDAO.getTotalSalesToday();
		return x;
	}

}
