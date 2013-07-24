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
public class AddPizzaAction extends BaseActionSupport{

	//Autowired Variables
	@Autowired
	@Qualifier("pizza")
	private Pizza pizza;
	
	@Autowired
	@Qualifier("pizzaServiceImpl")
	private PizzaServiceImpl pizzaServiceImpl;
	
	//Other Variables
	private List<Pizza> pizzas;
		
	//Actions
	@Action(value="addPizza", results ={
			@Result(name=ActionSupport.SUCCESS, location="pages/viewPizza.jsp"),
			@Result(name=ActionSupport.INPUT, location="pages/addPizza.jsp")
	})
	public String AddPizza() {
		System.out.println("Adding a pizza..");
		pizzaServiceImpl.addPizza(pizza.getPizzaName(), pizza.getPizzaPrice());
		System.out.println("Redirecting to View Pizza Page");
		setPizzas(pizzaServiceImpl.getAllPizza());
		return ActionSupport.SUCCESS;
	}
	
	public void validate(){
		if("".equals(pizza.getPizzaName())){
			addFieldError("pizza.pizzaName", "Pizza name cannot be blank");
		}
		if(pizza.getPizzaPrice()==0){
			addFieldError("pizza.pizzaPrice", "Pizza price cannot be zero");
		}
	}
	
	//Setter and Getter for each variable
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
