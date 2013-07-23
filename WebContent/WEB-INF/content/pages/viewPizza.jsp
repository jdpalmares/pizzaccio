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
		<ul class="thumbnails">
		  <s:iterator value="pizzas" >
		  <li class="span3">
		  	<div class="thumbnail pizza-item">
			    <a href="#">
			      <img src="<s:url value="/img/pizza-thumb.jpg"/>" alt="" class="img-rounded">
			    </a>
			    <div class="caption">
	              <h3><s:property value="pizzaName" /><span class="pull-right"><s:property value="pizzaPrice" /></span></h3>
	            </div>
	            <div class="actions">
	        	    <a href="<s:url action="index" namespace="/"/>"><i class="icon-pencil"></i> Edit</a>
	        	    <a href="<s:url action="index" namespace="/"/>"><i class="icon-trash"></i> Delete</a>    
	            </div>
	        </div>
		  </li>
		  </s:iterator>
		</ul>
    </jsp:body>
</t:genericpage>