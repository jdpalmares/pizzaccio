package com.aws.global.service;

import java.util.List;

import com.aws.global.classes.Order;

public interface OrderService {
	
	//declaration of abstract methods
	public List<Order> getAllOrder();
	
	public void addOrder(Order order);
	
	public void cancelOrder(int id);
	
	public Order getOrderById(int id);
	
	public void payOrder(int transaction_id, int id);
}
