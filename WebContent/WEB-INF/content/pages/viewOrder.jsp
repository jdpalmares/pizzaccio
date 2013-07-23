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
			<s:form action="payOrder" theme="bootstrap" cssClass="form-vertical" id="orderTable">
				<table class="table">
	  				<thead>
						<tr>
		  					<th><s:checkbox name="checkAll" id="checkAll" value="false" /></th>
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
  					<td><s:checkbox name="orderId" fieldValue="%{orderId}"	value="false" cssClass="orderId"/></td>
	    				<td><s:property value="pizzaName" /></td>
	    				<td><s:property value="quantity" /></td>
	    				<td><s:property value="unitPrice" /></td>
	    				<td><s:if test="dineType eq 0">Dine In</s:if><s:else>Take Out</s:else></td>
    				<td id="subTotal-<s:property value="orderId"/>"><s:property value="subTotal" /></td>
	  				</tr>
	  				</s:iterator>
	  				</tbody>
				</table>
				<s:submit value="Pay Order"/>
				<s:url id="simpleecho" value="/cancelOrder.action"/>
	            <sj:submit 
	            	id="formSubmit2"
	            	href="%{simpleecho}"
                	targets="result" 
                	value="Cancel Order" 
                	timeout="2500" 
                	indicator="indicator" 
                	onCompleteTopics="complete"
	            	button="true"
                />
			</s:form>
			<strong>Total Amount</strong>
			<div id="total" class="result ui-widget-content ui-corner-all">
				0
			</div>
			<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>
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
		<script type="text/javascript">
		  /*<![CDATA[*/
		  jQuery(function($) {
			  $('#checkAll').click(function(e){
				  var checkAll = this.checked;
				$('.orderId').each(function(e){
					var prevState = this.checked;
					this.checked = checkAll;
					if(checkAll != prevState)
						computeTotal(this);
				});
			  });
			  $.subscribe('complete', function(event,data) {
					console.log($("#orderTable").serialize());
			   	 	alert('status: ' + event.originalEvent.status + '\n\nresponseText: \n' + event.originalEvent.request.responseText + 
			     '\n\nThe output div should have already been updated with the responseText.');
			    });
			  $('.orderId').click(function(e){
				  computeTotal(this);
			  });
			  
			  function computeTotal(e){
				  var value = $(e).val();
				  var subTotal = parseInt($('#subTotal-'+value).text());
				  var total = parseInt($('#total').text());
				  if($(e).is(':checked')){
					  var TrueTotal = subTotal + total;
					  $('#total').text(TrueTotal);
				  }
				  else{
					  var TrueTotal = total - subTotal;
					  $('#total').text(TrueTotal);
				  }
			  }
		  });
		  /*]]>*/
	  	</script>
    </jsp:body>
</t:genericpage>