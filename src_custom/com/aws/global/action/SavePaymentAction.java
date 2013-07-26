package com.aws.global.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.aws.global.classes.Order;
import com.aws.global.classes.Transaction;
import com.aws.global.common.base.BaseActionSupport;
import com.aws.global.serviceImpl.OrderServiceImpl;
import com.aws.global.serviceImpl.TransactionServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespace("/")
public class SavePaymentAction extends BaseActionSupport{
	
	//Autowired Variables
	@Autowired
	@Qualifier("transaction")
	private Transaction transaction;
	
	@Autowired
	@Qualifier("transactionServiceImpl")
	private TransactionServiceImpl transactionServiceImpl;
	
	@Autowired
	@Qualifier("orderServiceImpl")
	private OrderServiceImpl orderServiceImpl;
	
	//Other Variables
	private int transactionIdConnector;

	private List<Order> finalOrders;
	
	private List<Order> orders;

	private int totalPayment;

	//Actions
	@Action(value="savePayment", results ={
			@Result(name=ActionSupport.SUCCESS, location="goToViewOrder.action", type="redirect", params={"success","true"}),
			@Result(name=ActionSupport.INPUT, location="pages/paymentForm.jsp")
	})
	public String PayOrder() {
		System.out.println("Adding a transaction ID..");
		transactionServiceImpl.addTransaction(transaction.getPayment(), transaction.getCustomer());
		System.out.println("Getting the latest transaction ID");
		setTransactionIdConnector(transactionServiceImpl.getLatestTransactionId());
		System.out.println("Updating Orders");
		for(int i=0; i< finalOrders.size(); i++){
			if(finalOrders.get(i).getOrderId()!=0){
				orderServiceImpl.payOrder(getTransactionIdConnector(), finalOrders.get(i).getOrderId());
				System.out.println("Update order for orderId "+finalOrders.get(i).getOrderId());
			}
		}
		setOrders(orderServiceImpl.getAllOrder());
		if (orders.isEmpty()) orders = null;
		System.out.println("Orders Paid!");
		return ActionSupport.SUCCESS;
	}
	
	public void validate(){
		String dummyCustomerName = transaction.getCustomer();
		String trimmedDummyCustomerName = dummyCustomerName.trim();
		transaction.setCustomer(trimmedDummyCustomerName.replaceAll("\\s+"," "));
		if(transaction.getPayment()==0){
			addFieldError("transaction.payment", getText("error.common.payment.required"));
		}
		else if(transaction.getPayment()<getTotalPayment()){
			addFieldError("transaction.payment", getText("error.common.payment.range"));
		}
		if("".equals(transaction.getCustomer())){
			addFieldError("transaction.customer", getText("error.common.customerName.required"));
		}
		List<Order> ordersTemp = new ArrayList<Order>();
		for(int i=0; i< finalOrders.size(); i++){
			if(finalOrders.get(i).getOrderId()!=0){
				ordersTemp.add(orderServiceImpl.getOrderById(finalOrders.get(i).getOrderId()));
			}
		}
		setOrders(ordersTemp);
	}
	
	//Getter and Setter of each variable
	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public TransactionServiceImpl getTransactionServiceImpl() {
		return transactionServiceImpl;
	}

	public void setTransactionServiceImpl(
			TransactionServiceImpl transactionServiceImpl) {
		this.transactionServiceImpl = transactionServiceImpl;
	}
	
	public int getTransactionIdConnector() {
		return transactionIdConnector;
	}

	public void setTransactionIdConnector(int transactionIdConnector) {
		this.transactionIdConnector = transactionIdConnector;
	}
	
	public OrderServiceImpl getOrderServiceImpl() {
		return orderServiceImpl;
	}

	public void setOrderServiceImpl(OrderServiceImpl orderServiceImpl) {
		this.orderServiceImpl = orderServiceImpl;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Order> getFinalOrders() {
		return finalOrders;
	}

	public void setFinalOrders(List<Order> finalOrders) {
		this.finalOrders = finalOrders;
	}
	
	public int getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(int totalPayment) {
		this.totalPayment = totalPayment;
	}
}
