package com.aws.global.service;

import java.util.ArrayList;

import com.aws.global.classes.Sales;

public interface SalesService {
	//declaration of abstract methods
	public ArrayList<Sales> getTodaySales();
	public int getMoneyInHandToday();
	public int getTotalSalesToday();
}
