<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
	<jsp:attribute name="pageTitle">
		Payment Slip
	</jsp:attribute>
    <jsp:body>
    	<div class="row">
	    	<div class="span4 offset4">
			<h1 class="text-center"> <img src="<s:url value="/img/pizza128.png"/>" style="width:40px;height:40px"/> Payment Slip</h1>
			<hr/>
			<s:form action="savePayment" theme="bootstrap" cssClass="form-vertical" id="orderTable">
				<table class="table">
	  				<thead>
						<tr>
	    					<th class="span6">Pizza</th>
	    					<th class="span6">Quantity</th>
	    					<th class="span6 text-right">Unit Price</th>
	    					<th class="span6">Take Out/Dine In</th>
	    					<th class="span3 text-right">SubTotal</th>
	  					</tr>
	  				</thead>
	  				<tbody>
	  				<s:iterator value="orders" status="ctr">
	  				<tr id="<s:property value="orderId" />">
	  					<s:hidden name="finalOrders.orderId" value="%{orderId}"/>
	    				<td><s:property value="pizzaName" /></td>
	    				<td><s:property value="quantity" /></td>
	    				<td class="text-right"><s:property value="unitPrice" /></td>
	    				<td><s:if test="dineType eq 0">Dine In</s:if><s:else>Take Out</s:else></td>
	    				<td id="subTotal-<s:property value="orderId"/>" class="text-right"><s:property value="subTotal" /></td>
	  				</tr>
	  				</s:iterator>
	  				<tfoot>
	  				<s:hidden name="totalPayment" value="%{totalPayment}"/>
	  					<tr>
	  						<td colspan="5"><h5 class="text-right">Total Amount</h5></td>
	  						<td>
	  							<h4 class="text-right">PHP <s:property value="totalPayment" />
								</h4>
							</td>
	  					</tr>
	  				</tfoot>
				</table>
				<s:textfield 
					name="transaction.payment" 
					label="Payment" 
					placeholder="Please input payment amount" 
					cssClass="input-block-level"
				></s:textfield>
				<s:textfield 
					name="transaction.customer" 
					label="Customer Name" 
					placeholder="Please input customer's name" 
					cssClass="input-block-level"
				></s:textfield>
				<s:submit cssClass="btn btn-primary btn-block btn-large" value="Save"></s:submit>
				<s:reset cssClass="btn btn-primary btn-block btn-large" value="Clear"></s:reset>
			</s:form>
			</div>
		</div>
    </jsp:body>
</t:genericpage>