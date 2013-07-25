package com.aws.global.action;

import java.util.ArrayList;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.aws.global.classes.Order;
import com.aws.global.classes.Pizza;
import com.aws.global.common.base.BaseActionSupport;
import com.aws.global.serviceImpl.PizzaServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespace("/")
public class AddOrderAction extends BaseActionSupport {
	
	@Autowired
	@Qualifier("pizzaServiceImpl")
	private PizzaServiceImpl pizzaServiceImpl;
	
	@Autowired
	@Qualifier("order")
	private Order order;
	
	private ArrayList<Pizza> pizzas;
	
	private boolean success;
	
	//Actions
	@Action(value="addOrder", results ={
			@Result(name=ActionSupport.SUCCESS, location="pages/addOrder.jsp"),
	})
	public String AddOrderForm() {
		pizzas = pizzaServiceImpl.getAllPizza();
		if(isSuccess()){
			addActionMessage(getText("sucess.common.addOrder"));
		}
		System.out.println("Add Order");
		return ActionSupport.SUCCESS;
	}
	
	/**
	 * @return the pizzas
	 */
	public ArrayList<Pizza> getPizzas() {
		return pizzas;
	}

	/**
	 * @param pizzas the pizzas to set
	 */
	public void setPizzas(ArrayList<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	/**
	 * @return the pizzaServiceImpl
	 */
	public PizzaServiceImpl getPizzaServiceImpl() {
		return pizzaServiceImpl;
	}

	/**
	 * @param pizzaServiceImpl the pizzaServiceImpl to set
	 */
	public void setPizzaServiceImpl(PizzaServiceImpl pizzaServiceImpl) {
		this.pizzaServiceImpl = pizzaServiceImpl;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
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
}
