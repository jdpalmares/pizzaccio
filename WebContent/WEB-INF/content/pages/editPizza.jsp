<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
	<jsp:attribute name="pageTitle">
		<s:property value="pizza.pizzaName"/>
	</jsp:attribute>
    <jsp:body>
		<div class="row">
	    	<div class="span4 offset4">
			<h1 class="text-center"> <img src="<s:url value="/img/pizza128.png"/>" style="width:40px;height:40px"/> Edit <s:property value="pizza.pizzaName"/></h1>
			<hr/>
			<s:form action="updatePizza" theme="bootstrap" cssClass="form-vertical">
				<s:textfield 
					name="pizza.pizzaName" 
					label="Pizza Name" 
					placeholder="Please input pizza's name" 
					value="%{pizza.pizzaName}"
					cssClass="input-block-level"
				></s:textfield>
				<s:textfield 
					name="pizza.pizzaPrice" 
					label="Pizza Price" 
					placeholder="Please input pizza's price" 
					value="%{pizza.pizzaPrice}"
					cssClass="input-block-level"
				></s:textfield>
				<s:hidden name="pizza.pizzaId" value="%{pizza.pizzaId}"/>
				<s:submit cssClass="btn btn-primary btn-block btn-large" value="Edit"></s:submit>
				<s:reset cssClass="btn btn-primary btn-block btn-large" value="Clear"></s:reset>
			</s:form>
			</div>
		</div>
    </jsp:body>
</t:genericpage>