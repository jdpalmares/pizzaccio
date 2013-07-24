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
	
	//SQL Statement when user wants to get a pizza record using a pizza id
	public Pizza getPizzaById(int id)
	{
		String sql = "SELECT * FROM PIZZA WHERE pizza_id = ?";
		Pizza pizza = (Pizza)getJdbcTemplate().queryForObject(
				sql, new Object[] { id },
				new PizzaRowMapper());
		return pizza;
	}
	
	//SQL Statement when user wants to update a certain pizza's information
	public void editPizza(String pizza_name, int pizza_price, int id)
	{
		String sql = "UPDATE PIZZA SET pizza_name = ?, pizza_price = ? WHERE pizza_id = ?;";
		getJdbcTemplate().update(sql, new Object[] { pizza_name, pizza_price, id });
	}
	
	//SQL Statement when user wants to delete a pizza information
	public void deletePizza(int id)
	{
		String sql = "DELETE FROM PIZZA WHERE pizza_id = ?";
		getJdbcTemplate().update(sql, new Object[] { id });
	}
}
