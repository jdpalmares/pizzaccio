package com.aws.global.service;

import java.util.List;

import com.aws.global.classes.Pizza;

public interface PizzaService {
	
	//declaration of abstract methods
	public void addPizza(String pizzaName, int pizzaPrice);
	public List<Pizza> getAllPizza();
}
