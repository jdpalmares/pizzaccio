<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
	<jsp:attribute name="pageTitle">
		<s:text name="label.common.form.SalesToday" />
	</jsp:attribute>
    <jsp:body>
		<section id="orderTableSection" <s:if test="salesList eq null">style="display:none"</s:if>>
		<h1><img src="<s:url value="/img/order-slip128.png"/>" style="width:40px;height:40px"/> <s:text name="label.common.form.SalesToday" /></h1>
				<table class="table" id="orderFormTable">
	  				<thead>
						<tr>
	    					<th class="span6"><s:text name="label.common.column.customerName" /></th>
	    					<th class="span3"><s:text name="label.common.column.dineType" /></th>
	    					<th class="span6"><s:text name="label.common.column.pizzaName" /></th>
	    					<th class="span6"><s:text name="label.common.column.quantity" /></th>
	    					<th class="span3 text-right"><s:text name="label.common.column.unitPrice" /></th>
	    					<th class="span3 text-right"><s:text name="label.common.column.subTotal" /></th>
	  					</tr>
	  				</thead>
	  				<tbody>
	  				<s:iterator value="salesList">
	  				<tr>
	  					<td><s:property value="customerName" /></td>
	    				<td><s:if test="dineType eq 0"><s:text name="label.common.radio.dineIn" /></s:if><s:else>Take Out</s:else></td>
	    				<td><s:property value="pizzaName" /></td>
	    				<td><s:property value="quantity" /></td>
	    				<td class="text-right">PHP <s:property value="pizzaPrice" />.00</td>
	    				<td id="totalPrice-<s:property value="orderId"/>" class="text-right">PHP <s:property value="totalPrice" />.00</td>
	  				</tr>
	  				</s:iterator>
	  				</tbody>
	  				<tfoot>
	  					<tr>
	  						<td colspan="5"><h5 class="text-right"><s:text name="label.common.table.totalAmt" /></h5></td>
	  						<td>
	  							<h4 class="text-right">PHP <s:property value="salesToday" />.00
								</h4>
							</td>
	  					</tr>
	  					<tr>
	  						<td colspan="5"><h5 class="text-right"><s:text name="label.common.table.amtTendered" /></h5></td>
	  						<td>
	  							<h4 class="text-right">PHP <s:property value="moneyToday" />.00
								</h4>
							</td>
	  					</tr>
	  					<tr>
	  						<td colspan="5"><h5 class="text-right"><s:text name="label.common.table.totalChange" /></h5></td>
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
					<img src="<s:url value="/img/piggy512.png"/>"/>
				</div>
			</div>
			<div class="row">
				<div class="span8 offset2" style="text-align:center">
					<h1><s:text name="label.common.noSales.heading" /></h1>
					<h4><s:text name="label.common.noSales.description" /></h4>
				</div>
			</div>
		</section>
    </jsp:body>
</t:genericpage>