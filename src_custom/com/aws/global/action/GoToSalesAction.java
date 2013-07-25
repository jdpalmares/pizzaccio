package com.aws.global.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.aws.global.classes.Sales;
import com.aws.global.common.base.BaseActionSupport;
import com.aws.global.serviceImpl.SalesServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespace("/")
public class GoToSalesAction extends BaseActionSupport{
	//Autowired Variables
	@Autowired
	@Qualifier("sales")
	private Sales sales;
		
	@Autowired
	@Qualifier("salesServiceImpl")
	private SalesServiceImpl salesServiceImpl;

	//Other Variables
	private List<Sales> salesList;
	
	private int salesToday;
	
	private int moneyToday;

	private int extraMoneyToday;
	
	//When User Chooses View Pizza Option in the navbar
	@Action(value="gotoSales", results={
			@Result(name=ActionSupport.SUCCESS, location="pages/viewSales.jsp")
	})
	public String gotoSales() {
		System.out.println("Redirecting to View Sales Page");
		setSalesList(salesServiceImpl.getTodaySales());
		setSalesToday(salesServiceImpl.getTotalSalesToday());
		setMoneyToday(salesServiceImpl.getMoneyInHandToday());
		setExtraMoneyToday(getMoneyToday()-getSalesToday());
		if((salesList == null)||(salesList.size()==0)){
			salesList = null;
		}
		return ActionSupport.SUCCESS;
	}
		
	//Setter and Getter for each attribute
	public Sales getSales() {
		return sales;
	}

	public void setSales(Sales sales) {
		this.sales = sales;
	}

	public SalesServiceImpl getSalesServiceImpl() {
		return salesServiceImpl;
	}

	public void setSalesServiceImpl(SalesServiceImpl salesServiceImpl) {
		this.salesServiceImpl = salesServiceImpl;
	}

	public List<Sales> getSalesList() {
		return salesList;
	}

	public void setSalesList(List<Sales> salesList) {
		this.salesList = salesList;
	}

	public int getSalesToday() {
		return salesToday;
	}

	public void setSalesToday(int salesToday) {
		this.salesToday = salesToday;
	}

	public int getMoneyToday() {
		return moneyToday;
	}

	public void setMoneyToday(int moneyToday) {
		this.moneyToday = moneyToday;
	}

	public int getExtraMoneyToday() {
		return extraMoneyToday;
	}

	public void setExtraMoneyToday(int extraMoneyToday) {
		this.extraMoneyToday = extraMoneyToday;
	}

}
