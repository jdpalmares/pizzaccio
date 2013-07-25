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
			<h1 class="text-center"> <img src="<s:url value="/img/cashbox128.png"/>" style="width:40px;height:40px"/> Payment Slip</h1>
			<hr/>
			<s:form action="savePayment" theme="bootstrap" cssClass="form-vertical" id="orderTable">
				<table class="table">
	  				<thead>
						<tr>
	    					<th class="span6"><s:text name="label.common.column.dineType" /></th>
	    					<th class="span2"><s:text name="label.common.column.quantity" /></th>
	    					<th class="span6"><s:text name="label.common.column.pizzaName" /></th>
	    					<th class="span6 text-right"><s:text name="label.common.column.unitPrice" /></th>
	    					<th class="span3 text-right"><s:text name="label.common.column.subTotal" /></th>
	  					</tr>
	  				</thead>
	  				<tbody>
	  				<s:iterator value="orders" status="ctr">
	  				<tr id="<s:property value="orderId" />">
	  					<td><s:if test="dineType eq 0"><s:text name="label.common.radio.dineIn" /></s:if><s:else><s:text name="label.common.radio.takeOut" /></s:else></td>
	    				<td><s:property value="quantity" /><s:hidden name="finalOrders.orderId" value="%{orderId}"/>
	    				</td>
	    				<td><s:property value="pizzaName" /></td>
	    				<td class="text-right"><s:property value="unitPrice" /></td>
	    				<td id="subTotal-<s:property value="orderId"/>" class="text-right"><s:property value="subTotal" /></td>
	  				</tr>
	  				</s:iterator>
	  				<tfoot>
	  					<tr>
	  						<td colspan="3"><h5 class="text-right"><s:text name="label.common.table.totalAmt" /></h5><s:hidden name="totalPayment" value="%{totalPayment}"/></td>
	  						<td colspan="2">
	  							<h4 class="text-right">PHP <s:property value="totalPayment" />
								</h4>
							</td>
	  					</tr>
	  				</tfoot>
				</table>
				<s:textfield 
					key="label.common.input.payment"
					name="transaction.payment"
					cssClass="input-block-level"
				></s:textfield>
				<s:textfield 
					name="transaction.customer"
					key="label.common.input.customerName"
					cssClass="input-block-level"
				></s:textfield>
				<s:submit cssClass="btn btn-primary btn-block btn-large" value="%{getText('label.common.button.save')}"></s:submit>
				<br/>
				<s:reset cssClass="btn btn-danger pull-right" key="label.common.button.clear"></s:reset>
			</s:form>
			</div>
		</div>
    </jsp:body>
</t:genericpage>