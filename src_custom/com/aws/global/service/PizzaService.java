package com.aws.global.service;

import java.util.List;

import com.aws.global.classes.Pizza;

public interface PizzaService {
	
	//declaration of abstract methods
	public void addPizza(String pizzaName, int pizzaPrice);
	public List<Pizza> getAllPizza();
	public Pizza getPizzaById(int id);
	public void editPizza(String pizza_name, int pizza_price, int id);
	public void deletePizza(int id);
}
