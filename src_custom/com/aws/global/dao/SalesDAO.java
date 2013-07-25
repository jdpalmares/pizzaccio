package com.aws.global.dao;

import java.util.ArrayList;

import com.aws.global.classes.Sales;
import com.aws.global.common.base.BaseDAO;
import com.aws.global.mapper.SalesRowMapper;

public class SalesDAO extends BaseDAO{
	
	public ArrayList<Sales> getTodaySales()
	{
		String sql = "SELECT dine_type, pizza_name, pizza_price, quantity, pizza_price*quantity AS price, customer, payment FROM pizza_store.order, pizza, transaction WHERE pizza.pizza_id = order.pizza_id AND order.transaction_id = transaction.transaction_id AND pay_date = curdate() ORDER BY transaction.transaction_id ASC";
		ArrayList<Sales> salesList = (ArrayList<Sales>) getJdbcTemplate().query(sql, new SalesRowMapper());
		return salesList;
	}
	
	public int getMoneyInHandToday()
	{
		String sql = "SELECT sum(payment) AS total FROM transaction WHERE pay_date = curdate() ";
		int x = getJdbcTemplate().queryForInt(sql);
		return x;
	}
	
	public int getTotalSalesToday()
	{
		String sql = "SELECT sum(quantity*pizza_price) AS total FROM pizza, pizza_store.order, transaction WHERE pizza.pizza_id = order.pizza_id AND order.transaction_id = transaction.transaction_id AND pay_date = curdate()";
		int x = getJdbcTemplate().queryForInt(sql);
		return x;
	}
}
