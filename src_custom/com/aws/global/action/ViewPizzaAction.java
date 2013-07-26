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
	
	private boolean success;
	private boolean updated;
	private boolean deleted;
	
	//When User Chooses View Pizza Option in the navbar
	@Action(value="gotoViewPizza", results={
			@Result(name=ActionSupport.SUCCESS, location="pages/viewPizza.jsp")
	})
	public String gotoViewPizza() {
		System.out.println("Redirecting to View Pizza Page");
		setPizzas(pizzaServiceImpl.getAllPizza());
		if(isSuccess()){
			addActionMessage(getText("sucess.common.addPizza"));
		}
		if(isUpdated()){
			addActionMessage(getText("sucess.common.updatePizza"));
		}
		if(isDeleted()){
			addActionMessage(getText("sucess.common.deletePizza"));
		}
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

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the deleted
	 */
	public boolean isDeleted() {
		return deleted;
	}

	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	/**
	 * @return the updated
	 */
	public boolean isUpdated() {
		return updated;
	}

	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(boolean updated) {
		this.updated = updated;
	}
}
