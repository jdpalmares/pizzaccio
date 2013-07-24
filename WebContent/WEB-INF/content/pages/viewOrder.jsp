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
		
		<section id="orderTableSection" <s:if test="orders eq null">style="display:none"</s:if>>
		<h1><img src="<s:url value="/img/order-slip128.png"/>" style="width:40px;height:40px"/> Orders</h1>
			<s:form action="payOrder" theme="bootstrap" cssClass="form-vertical" id="orderTable">
				<table class="table" id="orderFormTable">
	  				<thead>
						<tr>
		  					<th class="span1"><s:checkbox name="checkAll" id="checkAll" value="false" /></th>
	    					<th class="span6">Take Out/Dine In</th>
	    					<th class="span6">Pizza</th>
	    					<th class="span6">Quantity</th>
	    					<th class="span6 text-right">Unit Price</th>
	    					<th class="span3 text-right">SubTotal</th>
	  					</tr>
	  				</thead>
	  				<tbody>
	  				<s:iterator value="orders">
	  				<tr id="<s:property value="orderId" />">
	  					<td><s:checkbox name="orderId" fieldValue="%{orderId}"	value="false" cssClass="orderId" /></td>
	    				<td><s:if test="dineType eq 0">Dine In</s:if><s:else>Take Out</s:else></td>
	    				<td><s:property value="pizzaName" /></td>
	    				<td><s:property value="quantity" /></td>
	    				<td class="text-right"><s:property value="unitPrice" /></td>
	    				<td id="subTotal-<s:property value="orderId"/>" class="text-right"><s:property value="subTotal" /></td>
	  				</tr>
	  				</s:iterator>
	  				</tbody>
	  				<tfoot>
	  					<tr>
	  						<td colspan="5"><h5 class="text-right">Total Amount</h5></td>
	  						<td>
	  							<h4 class="text-right">PHP <span id="total" class="result">0</span>.00
								</h4>
							</td>
	  					</tr>
	  				</tfoot>
				</table>
				<div class="form-actions">
					<s:submit value="Pay Order" cssClass="btn btn-primary"/>
					<s:url id="simpleecho" value="/cancelOrder.action"/>
		            <sj:submit 
		            	id="formSubmit2"
		            	href="%{simpleecho}"
	                	targets="result" 
	                	value="Cancel Order" 
	                	timeout="2500" 
	                	indicator="indicator" 
	                	onCompleteTopics="complete"
	                	onBeforeTopics="beforeForm"
	                	cssClass="btn btn-primary"
	                />
	                <img id="indicator" src="<s:url value="/img/indicator.gif"/>" alt="Loading..." style="display:none"/>
                </div>
			</s:form>
		</section>	
		
		<section id="basketEmpty" <s:if test="orders neq null">style="display:none"</s:if>>
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
		</section>
		
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
			  $.subscribe('beforeForm', function(event,data) {
				  if (!confirm('Are you sure?')) {
					  event.originalEvent.options.submit = false; 
				} 
			  });
			  $.subscribe('complete', function(event,data) {
					var jsonData = event.originalEvent.request.responseText;
					jsonData = jQuery.parseJSON(jsonData);
					var rowLength = $('#orderFormTable tbody tr').length;
					console.log(jsonData);
					$.each(jsonData.orderId, function(index, value) {
						$('input[type=checkbox][value='+value+']').each(function(){
							this.checked = false;
							computeTotal(this);
						});
						$('#'+value).fadeOut(function(e){
							$(e).remove();
						});
						rowLength--;
					});
					if(rowLength==0){
						$('#orderTableSection').fadeOut(500,function(){
							$('#basketEmpty').fadeIn(500);	
						});
					}
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