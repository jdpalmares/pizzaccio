package com.aws.global.action;

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
public class EditPizzaAction extends BaseActionSupport{
	//Autowired Variables
	@Autowired
	@Qualifier("pizza")
	private Pizza pizza;
		
	@Autowired
	@Qualifier("pizzaServiceImpl")
	private PizzaServiceImpl pizzaServiceImpl;

	//OtherVariables
	private int pizzaId;

	//Actions
	@Action(value="editPizza", results ={
			@Result(name=ActionSupport.SUCCESS, location="pages/editPizza.jsp")
	})
	public String EditPizza() {
		System.out.println("Editing Pizza's information");
		setPizza(pizzaServiceImpl.getPizzaById(getPizzaId()));
		return ActionSupport.SUCCESS;
	}
		
	//Getter and Setters for each variable
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

	public int getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}
}
