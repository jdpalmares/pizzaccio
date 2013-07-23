package com.aws.global.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.aws.global.common.base.BaseActionSupport;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespace("/")
public class GoToAddPizzaAction extends BaseActionSupport{
	//Actions
	@Action(value="gotoAddPizza", results={
			@Result(name=ActionSupport.SUCCESS, location="pages/addPizza.jsp")
	})
	public String gotoAddPizza() {
		System.out.println("Redirecting to Add Pizza Page");
		return ActionSupport.SUCCESS;
	}
}
