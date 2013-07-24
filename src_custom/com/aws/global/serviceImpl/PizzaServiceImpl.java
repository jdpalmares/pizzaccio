package com.aws.global.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.aws.global.classes.Pizza;
import com.aws.global.dao.PizzaDAO;
import com.aws.global.service.PizzaService;

public class PizzaServiceImpl implements PizzaService{

	//Autowired variables
	@Autowired
	@Qualifier("pizzaDAO")
	private PizzaDAO pizzaDAO;
	
	//Overrided methods from PizzaService
	@Override
	public void addPizza(String pizzaName, int pizzaPrice) {
		// TODO Auto-generated method stub
		pizzaDAO.addPizza(pizzaName, pizzaPrice);
	}

	@Override
	public ArrayList<Pizza> getAllPizza() {
		// TODO Auto-generated method stub
		ArrayList<Pizza> pizzas = pizzaDAO.getAllPizza();
		return pizzas;
	}

	@Override
	public Pizza getPizzaById(int id) {
		// TODO Auto-generated method stub
		Pizza pizza = pizzaDAO.getPizzaById(id);
		return pizza;
	}

	@Override
	public void editPizza(String pizza_name, int pizza_price, int id) {
		// TODO Auto-generated method stub
		pizzaDAO.editPizza(pizza_name, pizza_price, id);
	}

	@Override
	public void deletePizza(int id) {
		// TODO Auto-generated method stub
		pizzaDAO.deletePizza(id);
	}

}
