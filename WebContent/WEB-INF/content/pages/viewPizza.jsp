<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
	<jsp:attribute name="pageTitle">
		Pizzas
	</jsp:attribute>
    <jsp:body>
		<h1>Pizzas</h1>
		
			<div class="row">
				<table>
  				<tr>
    				<th>Name</th>
    				<th>Price</th>
    				<th>Action</th>
  				</tr>
  				<s:iterator value="pizzas" >
  				<tr>
    				<td><s:property value="pizzaName" /></td>
    				<td><s:property value="pizzaPrice" /></td>
    				<td><a href="<s:url action="index" namespace="/"/>">Edit</a> <a href="<s:url action="index" namespace="/"/>">Delete</a></td>
  				</tr>
  				</s:iterator>
			</table>
			</div>
    </jsp:body>
</t:genericpage>