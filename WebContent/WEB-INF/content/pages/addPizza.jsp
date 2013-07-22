<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
	<jsp:attribute name="pageTitle">
		Add a Pizza
	</jsp:attribute>
    <jsp:body>
		<h1>Add a new Pizza</h1>
		
		
		<s:form action="addPizza" theme="bootstrap" cssClass="form-vertical">
			<div class="row">
				<s:textfield name="pizza.pizzaName" label="Pizza Name" placeholder="Please input pizza's name"></s:textfield>
				<s:textfield name="pizza.pizzaPrice" label="Pizza Price" placeholder="Please input pizza's price"></s:textfield>
				<s:submit cssClass="btn btn-primary btn-block"></s:submit>
			</div>
		</s:form>
    </jsp:body>
</t:genericpage>