<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
	<jsp:attribute name="pageTitle">
		<s:text name="label.common.form.AddOrder" />
	</jsp:attribute>
    <jsp:body>
    	<div class="row">
	    	<div class="span4 offset4">
			<h1 class="text-center"> <img src="<s:url value="/img/cart128.png"/>" style="width:40px;height:40px"/> <s:text name="label.common.form.AddOrder" /></h1>
			<hr/>
			<s:form action="saveOrder" theme="bootstrap" cssClass="form-vertical">
				<s:select key="label.common.input.pizzaName"
					headerKey="-1" headerValue="%{getText('label.common.select.whatPizza')}"
					list="pizzas" 
					name="order.pizzaId" listKey="pizzaId" listValue="pizzaName" cssClass="input-block-level"/>
				<s:textfield 
					key="label.common.input.quantity"
					name="order.quantity"
					placeholder="e.g. 1, 2, 5, 20" 
					cssClass="input-block-level"
				></s:textfield>
				<s:radio label="" name="order.dineType" list="#{true:getText('label.common.radio.takeOut'),false:getText('label.common.radio.dineIn')}" value="false" />
				<s:submit cssClass="btn btn-primary btn-block btn-large" key="label.common.button.save"></s:submit>
				<br/>
				<s:reset cssClass="btn btn-danger pull-right" key="label.common.button.clearOrder"></s:reset>
			</s:form>
			</div>
		</div>
		<script type="text/javascript">
		  /*<![CDATA[*/
		  jQuery(function($) {
			  $('input[type=reset]').click(function(e){
				  if($('input[type="text"][name="order.quantity"]').val()=="0"){
				  	$('input[type="text"][name="order.quantity"]').attr('value',"");
				  }
			  });
		  });
		  /*]]>*/
	  	</script>
    </jsp:body>
</t:genericpage>