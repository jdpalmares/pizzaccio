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
	
	private List<Integer> orderId;
	
	//Actions
	@Action(value="cancelOrder", results ={
			@Result(name=ActionSupport.SUCCESS, type="json"),
	})
	public String CancelOrder(){
		for(int i=0; i< orderId.size(); i++){
			orderServiceImpl.cancelOrder(orderId.get(i));
		}
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
