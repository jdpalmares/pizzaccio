<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
	<jsp:attribute name="pageTitle">
		<s:text name="label.common.form.ListPizza" />
	</jsp:attribute>
    <jsp:body>
		<h1><img src="<s:url value="/img/pizza128.png"/>" style="width:40px;height:40px"/> <s:text name="label.common.form.ListPizza" /></h1>
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
	        	    <a href="<s:url action="editPizza" namespace="/"><s:param name="pizzaId" value="pizzaId"/></s:url>"><i class="icon-pencil"></i> <s:text name="link.common.thumbnail.edit" /></a>
	        	    <a class="deletePizza" href="<s:url action="deletePizza" namespace="/"><s:param name="pizzaId" value="pizzaId"/></s:url>"><i class="icon-trash"></i> <s:text name="link.common.thumbnail.delete" /></a>    
	            </div>
	        </div>
		  </li>
		  </s:iterator>
		</ul>
		<script type="text/javascript">
		  /*<![CDATA[*/
		  jQuery(function($) {
			  $('.deletePizza').click(function(e){
				  return confirm("Are you sure?");
			  });
		  });
		  /*]]>*/
	  	</script>
    </jsp:body>
</t:genericpage>