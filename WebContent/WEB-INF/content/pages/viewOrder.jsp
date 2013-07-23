<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
	<jsp:attribute name="pageTitle">
		Order Tab
	</jsp:attribute>
    <jsp:body>
		<s:if test="orders neq null">
		<h1>Orders</h1>
			<table class="table">
  				<thead>
  					<tr>
    					<th>Pizza</th>
    					<th>Quantity</th>
    					<th>Unit Price</th>
    					<th>Take Out/Dine In</th>
    					<th>SubTotal</th>
  					</tr>
  				</thead>
  				<tbody>
  				<s:iterator value="orders">
  				<tr id="<s:property value="orderId" />">
    				<td><s:property value="pizzaName" /></td>
    				<td><s:property value="quantity" /></td>
    				<td><s:property value="unitPrice" /></td>
    				<td><s:if test="dineType eq 0">Dine In</s:if><s:else>Take Out</s:else></td>
    				<td><s:property value="subTotal" /></td>
  				</tr>
  				</s:iterator>
  				</tbody>
			</table>
			<sj:submit ></sj:submit>
		</s:if>
		<s:else>
			<div class="row">
				<div class="span4 offset4">
					<img src="<s:url value="/img/basket-empty.png"/>"/>
				</div>
			</div>
			<div class="row">
				<div class="span6 offset3" style="text-align:center">
					<h1>Your basket seems empty.</h1>
					<h4>You want to order something yummy?</h4>
					<a href="<s:url action="addOrder" namespace="/"/>" class="btn btn-primary btn-large">Order Now!</a>
				</div>
			</div>
		</s:else>
    </jsp:body>
</t:genericpage>