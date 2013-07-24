package com.aws.global.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.aws.global.common.base.BaseActionSupport;
import com.aws.global.serviceImpl.OrderServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespace("/")
@ParentPackage("json-default")
public class CancelOrderAction extends BaseActionSupport {
	
	@Autowired
	@Qualifier("orderServiceImpl")
	private OrderServiceImpl orderServiceImpl;
	
	private List<Integer> finalOrder;
	
	//Actions
	@Action(value="cancelOrder", results ={
			@Result(name=ActionSupport.SUCCESS, type="json"),
			@Result(name=ActionSupport.ERROR, type="json"),
	})
	public String CancelOrder(){
		if(finalOrder == null || finalOrder.size() == 0) 
			return ActionSupport.ERROR;
		for(int i=0; i< finalOrder.size(); i++){
			orderServiceImpl.cancelOrder(finalOrder.get(i));
		}
		return ActionSupport.SUCCESS;
	}

	/**
	 * @return the finalOrder
	 */
	public List<Integer> getFinalOrder() {
		return finalOrder;
	}


	/**
	 * @param finalOrder the finalOrder to set
	 */
	public void setFinalOrder(List<Integer> finalOrder) {
		this.finalOrder = finalOrder;
	}


	/**
	 * @return the orderServiceImpl
	 */
	public OrderServiceImpl getOrderServiceImpl() {
		return orderServiceImpl;
	}

	/**
	 * @param orderServiceImpl the orderServiceImpl to set
	 */
	public void setOrderServiceImpl(OrderServiceImpl orderServiceImpl) {
		this.orderServiceImpl = orderServiceImpl;
	}
}
