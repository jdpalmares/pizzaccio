package com.aws.global.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;

import com.aws.global.classes.Order;

public class OrderRowMapper implements RowMapper<Order> {
	
	@Autowired
	@Qualifier("order")
	private Order order;
	
	@Override
	public Order mapRow(ResultSet rs, int arg1) throws SQLException {
		if (rs.getRow() == 0) return null;
		order = new Order();
		order.setOrderId(rs.getInt("ORDER_ID"));
		order.setPizzaName(rs.getString("PIZZA_NAME"));
		order.setQuantity(rs.getInt("QUANTITY"));
		order.setUnitPrice(rs.getInt("PIZZA_PRICE"));
		order.setSubTotal(rs.getInt("PRICE"));
		order.setDineType(rs.getBoolean("DINE_TYPE"));
		return order;
	}
}
