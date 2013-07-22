package com.aws.global.dao;

import com.aws.global.common.base.BaseDAO;

public class PizzaDAO extends BaseDAO{
	
	//SQL Statement when user adds a pizza to his inventory
	public void addPizza(String pizzaName, int pizzaPrice)
	{
		String sql = "INSERT INTO PIZZA (pizza_id, pizza_name, pizza_price) VALUES (NULL, ?, ?);";
		getJdbcTemplate().update(sql, new Object[] { pizzaName, pizzaPrice});
	}

}
