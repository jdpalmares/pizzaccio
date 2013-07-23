<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
	<jsp:attribute name="pageTitle">
		Order Tab
	</jsp:attribute>
    <jsp:body>
		<h1>Orders</h1>
		
			<div class="row">
				<table>
  				<tr>
    				<th>Pizza</th>
    				<th>Quantity</th>
    				<th>Unit Price</th>
    				<th>Take Out/Dine In</th>
    				<th>SubTotal</th>
  				</tr>
  				<s:iterator value="orders" >
  				<tr>
    				<td><s:property value="pizzaName" /></td>
    				<td><s:property value="quantity" /></td>
    				<td><s:property value="unitPrice" /></td>
    				<td><s:if test="dineType eq 0">Dine In</s:if><s:else>Take Out</s:else></td>
    				<td><s:property value="subTotal" /></td>
  				</tr>
  				</s:iterator>
			</table>
			</div>
    </jsp:body>
</t:genericpage>