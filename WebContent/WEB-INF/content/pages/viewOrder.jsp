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
    <script type="text/javascript">
		  /*<![CDATA[*/
		  jQuery(function($) {
			  $('.orderId').click(function(e){
				  var value = $(this).val();
				  var subTotal = parseInt($('#subTotal-'+value).text());
				  var total = parseInt($('#total').text());
				  if($(this).is(':checked')){
					  var TrueTotal = subTotal + total;
					  $('#total').text(TrueTotal);
				  }
				  else{
					  var TrueTotal = total - subTotal;
					  $('#total').text(TrueTotal);
				  }
				  
			  });
		  });
		  /*]]>*/
	  	</script>
		<h1>Orders</h1>
		
			<div class="row">
			<s:form action="orderTransaction" theme="bootstrap">
				<table class="table">
  				<tr>
  					<th>status   </th>
    				<th>Pizza   </th>
    				<th>Quantity   </th>
    				<th>Unit Price   </th>
    				<th>Take Out/Dine In </th>
    				<th>SubTotal </th>
  				</tr>
  				<s:iterator value="orders" >
  				<tr>
  					<td><s:checkbox name="orderId" fieldValue="%{orderId}"	value="false" cssClass="orderId"/></td>
    				<td><s:property value="pizzaName" /></td>
    				<td><s:property value="quantity" /></td>
    				<td><s:property value="unitPrice" /></td>
    				<td><s:if test="dineType eq 0">Dine In</s:if><s:else>Take Out</s:else></td>
    				<td id="subTotal-<s:property value="orderId"/>"><s:property value="subTotal" /></td>
  				</tr>
  				</s:iterator>
  				
  				
			</table>
			<s:submit value="Pay Order"/>
  			<s:reset value="Cancel Order"/>
			</s:form>
			</div>
			<strong>Total Amount</strong>
			<div id="total" class="result ui-widget-content ui-corner-all">
				0
			</div>
			<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>
    </jsp:body>
</t:genericpage>