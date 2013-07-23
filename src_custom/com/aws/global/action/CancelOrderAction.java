package com.aws.global.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.aws.global.common.base.BaseActionSupport;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespace("/")
@ParentPackage("json-default")
public class CancelOrderAction extends BaseActionSupport {
	
	private List<Integer> orderId;
	
	//Actions
	@Action(value="cancelOrder", results ={
			@Result(name=ActionSupport.SUCCESS, type="json"),
	})
	public String CancelOrder(){
		return ActionSupport.SUCCESS;
	}

	/**
	 * @return the orderId
	 */
	public List<Integer> getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(List<Integer> orderId) {
		this.orderId = orderId;
	}
}
