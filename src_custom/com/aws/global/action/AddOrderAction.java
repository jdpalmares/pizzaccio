package com.aws.global.action;

import java.util.ArrayList;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.aws.global.classes.Pizza;
import com.aws.global.common.base.BaseActionSupport;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespace("/")
public class AddOrderAction extends BaseActionSupport {
	
	private ArrayList<Pizza> pizzas;
	
	//Actions
	@Action(value="addOrder", results ={
			@Result(name=ActionSupport.SUCCESS, location="pages/addOrder.jsp"),
	})
	public String AddOrderForm() {
		System.out.println("Add Order");
		return ActionSupport.SUCCESS;
	}
	
	@Action(value="saveOrder", results ={
			@Result(name=ActionSupport.SUCCESS, location="pages/addOrder.jsp"),
	})
	public String SaveOrder(){
		System.out.println("Save Order");
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
}
