package com.aws.global.dao;

import java.util.ArrayList;
import com.aws.global.classes.Pizza;
import com.aws.global.common.base.BaseDAO;
import com.aws.global.mapper.PizzaRowMapper;

public class PizzaDAO extends BaseDAO{
	
	//SQL Statement when user adds a pizza to his inventory
	public void addPizza(String pizzaName, int pizzaPrice)
	{
		String sql = "INSERT INTO PIZZA (pizza_id, pizza_name, pizza_price) VALUES (NULL, ?, ?);";
		getJdbcTemplate().update(sql, new Object[] { pizzaName, pizzaPrice});
	}
	
	//SQL Statement when user wants to get a list of pizzas
	public ArrayList<Pizza> getAllPizza()
	{
		String sql = "SELECT * FROM Pizza";
		ArrayList<Pizza> pizzas = (ArrayList<Pizza>) getJdbcTemplate().query(sql, new PizzaRowMapper());
		return pizzas;
	}

}
