package com.aws.global.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;

import com.aws.global.classes.Pizza;

public class PizzaRowMapper implements RowMapper<Pizza> {
	
	@Autowired
	@Qualifier("pizza")
	private Pizza pizza;
	
	@Override
	public Pizza mapRow(ResultSet rs, int arg1) throws SQLException {
		if (rs.getRow() == 0) return null;
		pizza = new Pizza();
		pizza.setPizzaId(rs.getInt("pizza_id"));
		pizza.setPizzaName(rs.getString("pizza_name"));
		pizza.setPizzaPrice(rs.getInt("pizza_price"));
		return pizza;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

}
