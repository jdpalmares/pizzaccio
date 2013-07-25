<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
	<jsp:attribute name="pageTitle">
		Welcome
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
   				<h4><s:text name="carousel.dummy.label" /></h4>
         		<p><s:text name="carousel.dummy.description" /></p>
   			</div>
	    </div>
	    <div class="item">
	    	<img src="<s:url value="/img/p2.jpg"/>"/>
	    	<div class="carousel-caption">
              <h4><s:text name="carousel.dummy.label" /></h4>
              <p><s:text name="carousel.dummy.description" /></p>
            </div>
	    </div>
	    <div class="item">
	    	<img src="<s:url value="/img/p3.jpg"/>"/>
	    	<div class="carousel-caption">
              <h4><s:text name="carousel.dummy.label" /></h4>
              <p><s:text name="carousel.dummy.description" /></p>
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
						<a href="<s:url action="goToAddOrder" namespace="/"/>" class="btn btn-primary btn-large btn-block">
							<s:text name="label.common.button.startOrder" />
						</a>
					</div>
					<div class="span3">
						<a href="<s:url action="gotoViewPizza" namespace="/"/>" class="btn btn-primary btn-large btn-block">
							<s:text name="label.common.button.manageProducts" />
						</a>
					</div>
				</div>
    </jsp:body>
</t:genericpage>