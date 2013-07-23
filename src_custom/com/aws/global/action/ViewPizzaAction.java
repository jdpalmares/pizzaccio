package com.aws.global.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.aws.global.classes.Pizza;
import com.aws.global.common.base.BaseActionSupport;
import com.aws.global.serviceImpl.PizzaServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespace("/")
public class ViewPizzaAction extends BaseActionSupport{
	//Autowired Variables
	@Autowired
	@Qualifier("pizza")
	private Pizza pizza;
		
	@Autowired
	@Qualifier("pizzaServiceImpl")
	private PizzaServiceImpl pizzaServiceImpl;

	//Other Variables
	private List<Pizza> pizzas;

	//When User Chooses View Pizza Option in the navbar
	@Action(value="gotoViewPizza", results={
			@Result(name=ActionSupport.SUCCESS, location="pages/viewPizza.jsp")
	})
	public String gotoViewPizza() {
		System.out.println("Redirecting to View Pizza Page");
		setPizzas(pizzaServiceImpl.getAllPizza());
		return ActionSupport.SUCCESS;
	}
		
	//Getter and Setter for all variables
	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public PizzaServiceImpl getPizzaServiceImpl() {
		return pizzaServiceImpl;
	}

	public void setPizzaServiceImpl(PizzaServiceImpl pizzaServiceImpl) {
		this.pizzaServiceImpl = pizzaServiceImpl;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
}
