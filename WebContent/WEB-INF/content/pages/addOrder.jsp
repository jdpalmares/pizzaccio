<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
	<jsp:attribute name="pageTitle">
		Add an Order
	</jsp:attribute>
    <jsp:body>
    	<div class="row">
	    	<div class="span4 offset4">
			<h1 class="text-center"> <img src="<s:url value="/img/cart128.png"/>" style="width:40px;height:40px"/> Add an Order</h1>
			<hr/>
			<s:form action="addPizza" theme="bootstrap" cssClass="form-vertical">
				<s:textfield 
					name="order.pizzaId" 
					label="What Pizza?" 
					placeholder="Please input pizza's name" 
					cssClass="input-block-level"
				></s:textfield>
				<s:textfield 
					name="pizza.quantity" 
					label="Number of pizzas"
					placeholder="e.g. 1, 2, 5, 20" 
					cssClass="input-block-level"
				></s:textfield>
				<s:radio label="" name="pizza.dineType" list="#{'1':'Take Out','0':'Dine In'}" value="1" />
				<s:submit cssClass="btn btn-primary btn-block btn-large" value="Save"></s:submit>
			</s:form>
			</div>
		</div>
    </jsp:body>
</t:genericpage>