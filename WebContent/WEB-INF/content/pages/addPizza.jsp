<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
	<jsp:attribute name="pageTitle">
		<s:text name="link.common.navbar.AddPizza" />
	</jsp:attribute>
    <jsp:body>
    	<div class="row">
	    	<div class="span4 offset4">
			<h1 class="text-center"> <img src="<s:url value="/img/pizza128.png"/>" style="width:40px;height:40px"/> <s:text name="link.common.navbar.AddPizza" /></h1>
			<hr/>
			<s:form action="addPizza" theme="bootstrap" cssClass="form-vertical">
				<s:textfield 
					name="pizza.pizzaName" 
					key="label.common.input.pizzaName"
					cssClass="input-block-level"
				></s:textfield>
				<s:textfield 
					name="pizza.pizzaPrice" 
					key="label.common.input.pizzaPrice"
					cssClass="input-block-level"
				></s:textfield>
				<s:submit cssClass="btn btn-primary btn-block btn-large" value="%{getText('label.common.button.save')}"></s:submit>
				<br>
				<s:reset cssClass="btn btn-danger pull-right" key="label.common.button.clear"></s:reset>
			</s:form>
			</div>
		</div>
    </jsp:body>
</t:genericpage>