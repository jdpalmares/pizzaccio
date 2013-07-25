<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
	<jsp:attribute name="pageTitle">
		<s:text name="label.common.form.ListOrder" />
	</jsp:attribute>
    <jsp:body>
		
		<section id="orderTableSection" <s:if test="orders eq null">style="display:none"</s:if>>
		<h1><img src="<s:url value="/img/order-slip128.png"/>" style="width:40px;height:40px"/> <s:text name="label.common.form.ListOrder" /></h1>
			<section id="validationErrors">
			<s:if test="hasFieldErrors()">
			   <div class="alert alert-danger">
			   		<button type="button" class="close" data-dismiss="alert">&times;</button>
			   		<strong><s:text name="label.common.validation.header" /></strong><br/>
			      	<s:fielderror/>
			   </div>
			</s:if>
			</section>
			<s:form action="payOrder" theme="bootstrap" cssClass="form-vertical" id="orderTable">
				<table class="table" id="orderFormTable">
	  				<thead>
						<tr>
		  					<th class="span1"><s:checkbox name="checkAll" id="checkAll" value="false" theme="simple"/></th>
	    					<th class="span6"><s:text name="label.common.column.dineType" /></th>
	    					<th class="span6"><s:text name="label.common.column.pizzaName" /></th>
	    					<th class="span6"><s:text name="label.common.column.quantity" /></th>
	    					<th class="span6 text-right"><s:text name="label.common.column.unitPrice" /></th>
	    					<th class="span3 text-right"><s:text name="label.common.column.subTotal" /></th>
	  					</tr>
	  				</thead>
	  				<tbody>
	  				<s:iterator value="orders">
	  				<tr id="<s:property value="orderId" />">
	  					<td><s:checkbox name="finalOrder" fieldValue="%{orderId}" value="false" cssClass="orderId" theme="simple"/></td>
	    				<td><s:if test="dineType eq 0"><s:text name="label.common.radio.dineIn" /></s:if><s:else><s:text name="label.common.radio.takeOut" /></s:else></td>
	    				<td><s:property value="pizzaName" /></td>
	    				<td><s:property value="quantity" /></td>
	    				<td class="text-right"><s:property value="unitPrice" /></td>
	    				<td id="subTotal-<s:property value="orderId"/>" class="text-right"><s:property value="subTotal" /></td>
	  				</tr>
	  				</s:iterator>
	  				</tbody>
	  				<tfoot>
	  					<tr>
	  						<td colspan="5"><h5 class="text-right"><s:text name="label.common.table.totalAmt" /></h5></td>
	  						<td>
	  							<h4 class="text-right">PHP <span id="total" class="result">0</span>.00
								</h4>
							</td>
	  					</tr>
	  				</tfoot>
				</table>
				<div class="form-actions">
					<s:submit key="label.common.button.payOrder" cssClass="btn btn-primary"/>
					<s:url id="simpleecho" value="/cancelOrder.action"/>
		            <sj:submit 
		            	id="formSubmit2"
		            	href="%{simpleecho}"
	                	targets="result" 
	                	key="label.common.button.cancelOrder" 
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
				<div class="span8 offset2" style="text-align:center">
					<h1><s:text name="label.common.basketEmpty.heading" /></h1>
					<h4><s:text name="label.common.basketEmpty.description" /></h4>
					<a href="<s:url action="addOrder" namespace="/"/>" class="btn btn-primary btn-large"><s:text name="label.common.basketEmpty.orderNow" /></a>
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
				  var check = false;
				  $('.orderId').each(function(e){
						check = check || this.checked;
					});
				  if(check){
					  if (!confirm('Are you sure?')) {
						  event.originalEvent.options.submit = false; 
					  }
				  } else {
					  var html = '<div class="alert alert-danger">'+
					  	'<button type="button" class="close" data-dismiss="alert">&times;</button>'+
					  	'<strong><s:text name="label.common.validation.header" /></strong><ul><li><s:text name="error.common.orderCancel.required" /></li></ul></div>';
					  $("#validationErrors").html(html);
					  event.originalEvent.options.submit = false; 
				  }
			  });
			  $.subscribe('complete', function(event,data) {
					var jsonData = event.originalEvent.request.responseText;
					jsonData = jQuery.parseJSON(jsonData);
					var rowLength = $('#orderFormTable tbody tr').length;
					console.log(jsonData);
					$.each(jsonData.finalOrder, function(index, value) {
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
			  $('#orderTable').submit(function(e){
				  this.submit();
			  });
		  });
		  /*]]>*/
	  	</script>
    </jsp:body>
</t:genericpage>