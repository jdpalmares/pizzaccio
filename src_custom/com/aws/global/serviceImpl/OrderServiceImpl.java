package com.aws.global.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.aws.global.classes.Order;
import com.aws.global.dao.OrderDAO;
import com.aws.global.service.OrderService;

public class OrderServiceImpl implements OrderService{

	//Autowired variables
	@Autowired
	@Qualifier("orderDAO")
	private OrderDAO orderDAO;
	
	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		List<Order> orders = orderDAO.getAllOrder();
		return orders;
	}

}
