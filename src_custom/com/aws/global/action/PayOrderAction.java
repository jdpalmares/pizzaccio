package com.aws.global.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.aws.global.common.base.BaseActionSupport;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespace("/")
public class PayOrderAction extends BaseActionSupport{
	private List<Integer> orderId;

	//Actions
	@Action(value="payOrder", results ={
			@Result(name=ActionSupport.SUCCESS, location="pages/paymentForm.jsp"),
	})
	public String PayOrder(){
		
		return ActionSupport.SUCCESS;
	}
	
	//Getter and Setter
	public List<Integer> getOrderId() {
		return orderId;
	}

	public void setOrderId(List<Integer> orderId) {
		this.orderId = orderId;
	}
}




