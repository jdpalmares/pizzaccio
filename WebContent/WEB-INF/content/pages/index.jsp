<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
	<jsp:attribute name="pageTitle">
		Pizzaccio | Online Pizza Ordering Portal
	</jsp:attribute>
    <jsp:body>
			</div>
		</div>
	</div>
	<div id="landing-carousel" class="carousel slide">
	  <!-- Carousel items -->
	  <div class="carousel-inner">
	    <div class="active item">
	    	<img src="<s:url value="/img/p1.jpg"/>"/>
	    	<div class="carousel-caption">
   				<h4>Delicious Pizza</h4>
         		<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id 
           		elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies 
           		vehicula ut id elit.</p>
   			</div>
	    </div>
	    <div class="item">
	    	<img src="<s:url value="/img/p2.jpg"/>"/>
	    	<div class="carousel-caption">
              <h4>Second Thumbnail label</h4>
              <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
            </div>
	    </div>
	    <div class="item">
	    	<img src="<s:url value="/img/p3.jpg"/>"/>
	    	<div class="carousel-caption">
              <h4>Second Thumbnail label</h4>
              <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
            </div>
	    </div>
	  </div>
	  <!-- Carousel nav -->
	  <a class="carousel-control left" href="#landing-carousel" data-slide="prev">&lsaquo;</a>
	  <a class="carousel-control right" href="#landing-carousel" data-slide="next">&rsaquo;</a>
	</div>
	<div class="container">
		<div class="row">
			<div class="span12">
				<div class="row">
					<div class="span3 offset3">
						<a href="<s:url action="addOrder" namespace="/"/>" class="btn btn-primary btn-large btn-block">Start taking orders</a>
					</div>
					<div class="span3">
						<a href="<s:url action="gotoViewPizza" namespace="/"/>" class="btn btn-primary btn-large btn-block">Manage Products</a>
					</div>
				</div>
    </jsp:body>
</t:genericpage>