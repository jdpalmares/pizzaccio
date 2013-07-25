<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
	<jsp:attribute name="pageTitle">
		Sales For Today
	</jsp:attribute>
    <jsp:body>
		<section id="orderTableSection" <s:if test="salesList eq null">style="display:none"</s:if>>
		<h1><img src="<s:url value="/img/order-slip128.png"/>" style="width:40px;height:40px"/> Sales for Today</h1>
				<table class="table" id="orderFormTable">
	  				<thead>
						<tr>
	    					<th class="span6">Take Out/Dine In</th>
	    					<th class="span6">Pizza</th>
	    					<th class="span6">Quantity</th>
	    					<th class="span6 text-right">Unit Price</th>
	    					<th class="span3 text-right">SubTotal</th>
	    					<th class="span3 text-right">Customer Name</th>
	  					</tr>
	  				</thead>
	  				<tbody>
	  				<s:iterator value="salesList">
	  				<tr>
	    				<td><s:if test="dineType eq 0">Dine In</s:if><s:else>Take Out</s:else></td>
	    				<td><s:property value="pizzaName" /></td>
	    				<td><s:property value="quantity" /></td>
	    				<td class="text-right"><s:property value="pizzaPrice" /></td>
	    				<td id="totalPrice-<s:property value="orderId"/>" class="text-right"><s:property value="totalPrice" /></td>
	  					<td class="text-right"><s:property value="customerName" /></td>
	  				</tr>
	  				</s:iterator>
	  				</tbody>
	  				<tfoot>
	  					<tr>
	  						<td colspan="5"><h5 class="text-right">Total Amount</h5></td>
	  						<td>
	  							<h4 class="text-right">PHP <s:property value="salesToday" />.00
								</h4>
							</td>
	  					</tr>
	  					<tr>
	  						<td colspan="5"><h5 class="text-right">Amount Tendered</h5></td>
	  						<td>
	  							<h4 class="text-right">PHP <s:property value="moneyToday" />.00
								</h4>
							</td>
	  					</tr>
	  					<tr>
	  						<td colspan="5"><h5 class="text-right">Extra Profit</h5></td>
	  						<td>
	  							<h4 class="text-right">PHP <s:property value="extraMoneyToday" />.00
								</h4>
							</td>
	  					</tr>
	  				</tfoot>
				</table>
		</section>	
		
		<section id="basketEmpty" <s:if test="salesList neq null">style="display:none"</s:if>>
			<div class="row">
				<div class="span4 offset4">
					<img src="<s:url value="/img/basket-empty.png"/>"/>
				</div>
			</div>
			<div class="row">
				<div class="span6 offset3" style="text-align:center">
					<h1>You still have no sales for today.</h1>
					<h4>:(</h4>
				</div>
			</div>
		</section>
    </jsp:body>
</t:genericpage>