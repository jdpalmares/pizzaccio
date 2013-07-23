package com.aws.global.dao;

import java.util.List;

import com.aws.global.classes.Order;
import com.aws.global.common.base.BaseDAO;
import com.aws.global.mapper.OrderRowMapper;

public class OrderDAO extends BaseDAO{

	public List<Order> getAllOrder()
	{
		String sql = "SELECT ORDER_ID, PIZZA_NAME, QUANTITY, PIZZA_PRICE, (QUANTITY*PIZZA_PRICE) AS PRICE , DINE_TYPE FROM PIZZA, PIZZA_STORE.ORDER WHERE PIZZA.PIZZA_ID = ORDER.PIZZA_ID AND (CANCEL_STATUS != 1 OR TRANSACTION_ID IS NULL)";
		List<Order> orders = getJdbcTemplate().query(sql, new OrderRowMapper());
		return orders;
	}
}
