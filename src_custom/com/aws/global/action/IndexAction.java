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
@Action(value="index", results={
	@Result(name=ActionSupport.SUCCESS, location="pages/index.jsp"),
})
public class IndexAction extends BaseActionSupport {
	
	//Autowired Variables
	@Autowired
	@Qualifier("pizza")
	private Pizza pizza;
		
	@Autowired
	@Qualifier("pizzaServiceImpl")
	private PizzaServiceImpl pizzaServiceImpl;

	private List<Pizza> pizzas;

	//Home Page of the System
	public String execute() {
		// TODO : ADD IMPLEMENTATION HERE
		System.out.println("Home Page");
		return ActionSupport.SUCCESS;
	}
	
	//When User Chooses Add Order Option in the navbar
	@Action(value="goToAddOrder", results={
			@Result(name=ActionSupport.SUCCESS, location="pages/index.jsp")
	})
	public String gotoAddOrder() {
		System.out.println("Redirecting to Add Order Page");
		return ActionSupport.SUCCESS;
	}
	
	//When User Chooses View Order Option in the navbar
	@Action(value="goToViewOrder", results={
			@Result(name=ActionSupport.SUCCESS, location="pages/index.jsp")
	})
	public String gotoViewOrder() {
		System.out.println("Redirecting to View Order Page");
		return ActionSupport.SUCCESS;
	}
	
	//When User Chooses Add Pizza Option in the navbar
	@Action(value="gotoAddPizza", results={
			@Result(name=ActionSupport.SUCCESS, location="pages/addPizza.jsp")
	})
	public String gotoAddPizza() {
		System.out.println("Redirecting to Add Pizza Page");
		return ActionSupport.SUCCESS;
	}

	//When User Chooses View Pizza Option in the navbar
	@Action(value="gotoViewPizza", results={
			@Result(name=ActionSupport.SUCCESS, location="pages/viewPizza.jsp")
	})
	public String gotoViewPizza() {
		System.out.println("Redirecting to View Pizza Page");
		setPizzas(pizzaServiceImpl.getAllPizza());
		return ActionSupport.SUCCESS;
	}
	
	//Getter and Setter for the variables
	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	
	public PizzaServiceImpl getPizzaServiceImpl() {
		return pizzaServiceImpl;
	}

	public void setPizzaServiceImpl(PizzaServiceImpl pizzaServiceImpl) {
		this.pizzaServiceImpl = pizzaServiceImpl;
	}
}
