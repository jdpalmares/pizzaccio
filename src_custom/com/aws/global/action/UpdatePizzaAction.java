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
public class UpdatePizzaAction extends BaseActionSupport{
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
	@Action(value="updatePizza", results ={
			@Result(name=ActionSupport.SUCCESS, location="pages/viewPizza.jsp"),
			@Result(name=ActionSupport.INPUT, location="pages/editPizza.jsp")
	})
	public String EditPizza() {
		System.out.println("Updating Pizza");
		pizzaServiceImpl.editPizza(pizza.getPizzaName(), pizza.getPizzaPrice(), pizza.getPizzaId());
		setPizzas(pizzaServiceImpl.getAllPizza());
		return ActionSupport.SUCCESS;
	}

	public void validate(){
		String pizzaDummyName = pizza.getPizzaName();
		String trimmedDummyName = pizzaDummyName.trim();
		pizza.setPizzaName(trimmedDummyName.replaceAll("\\s+"," "));
		if("".equals(pizza.getPizzaName())){
			addFieldError("pizza.pizzaName", "Pizza's Name cannot be blank.");
		}
		if(pizza.getPizzaPrice()==0){
			addFieldError("pizza.pizzaPrice", "Pizza's Price cannot be zero or blank.");
		}
	}
	
	//Getter and Setter methods for each variable
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
