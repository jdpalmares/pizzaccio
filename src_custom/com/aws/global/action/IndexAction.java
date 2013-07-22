package com.aws.global.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.aws.global.common.base.BaseActionSupport;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespace("/")
@Action(value="index", results={
	@Result(name=ActionSupport.SUCCESS, location="pages/index.jsp"),
})
public class IndexAction extends BaseActionSupport {
	
	//Home Page of the System
	public String execute() {
		// TODO : ADD IMPLEMENTATION HERE
		System.out.println("Home Page");
		return ActionSupport.SUCCESS;
	}
	
	//When User Chooses Add Order Option in the navbar
	@Action(value="goToAddOrder", results={
			@Result(name=ActionSupport.SUCCESS, location="pages/userTable.jsp")
	})
	public String gotoAddOrder() {
		System.out.println("Redirecting to Add Order Page");
		return ActionSupport.SUCCESS;
	}
	
	//When User Chooses View Order Option in the navbar
	@Action(value="goToViewOrder", results={
			@Result(name=ActionSupport.SUCCESS, location="pages/userTable.jsp")
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

}
