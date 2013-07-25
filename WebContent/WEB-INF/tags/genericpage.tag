<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="pageTitle" fragment="true" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html>
<html lang="en">
	<head>
	<meta charset="utf-8">
	<title><jsp:invoke fragment="pageTitle"/> | Pizzaccio | Online Pizza Ordering Portal</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
	<!--[if lt IE 9]>
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<script src="<s:url value="/js/jquery-1.9.1.js"/>"></script>
	<sj:head></sj:head>
	<link rel="stylesheet" href="<s:url value="/css/bootstrap.css" />" type="text/css"/>
	<link rel="shortcut icon" href="<s:url value="/img/favico.ico" />">
	<sb:head includeStylesResponsive="true" includeScripts="true" includeScriptsValidation="true" includeStyles="false"/>
	<link rel="stylesheet" type="text/css" href="<s:url value="/css/doc.css"/>"/>
	</head>
  <body>
  	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				<a class="brand brand-img" href="<s:url action="index" namespace="/"/>">
					<img src="<s:url value="/img/pizzaccio_logo_80.png"/>"></img>
				</a>
				<div class="nav-collapse">
					<ul class="nav main-nav">
						<li><a href="<s:url action="goToAddOrder" namespace="/"/>"><s:text name="link.common.navbar.AddOrder" /></a></li>
						<li><a href="<s:url action="goToViewOrder" namespace="/"/>"><s:text name="link.common.navbar.ViewOrder" /></a></li>
						<li><a href="<s:url action="gotoAddPizza" namespace="/"/>"><s:text name="link.common.navbar.AddPizza" /></a></li>
						<li><a href="<s:url action="gotoViewPizza" namespace="/"/>"><s:text name="link.common.navbar.ViewPizza" /></a></li>
						<li><a href="<s:url action="gotoSales" namespace="/"/>"><s:text name="link.common.navbar.Sales" /></a></li>
					</ul>
					<ul class="nav pull-right">
						<li><a href="#"><s:text name="link.common.navbar.welcome" /></a></li>
					</ul>
				</div><!--/.nav-collapse -->
			</div>
		</div>
	</div>
    <div id="pageheader">
      <jsp:invoke fragment="header"/>
    </div>
    <div id="body">
    	<div class="container">
			<div class="row">
				<div class="span12">
					<s:if test="hasActionErrors()">
						<div class="alert alert-error">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<s:actionerror/>
						</div>
					</s:if>
					<s:if test="hasActionMessages()">
					   <div class="alert alert-success">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
				      		<s:actionmessage/>
					   </div>
					</s:if>
      				<jsp:doBody/>
      			</div>
			</div>
		</div>
    </div>
    <div id="pagefooter">
      <div class="container">
			<div class="row">
				<div class="span12">
      				<jsp:invoke fragment="footer"/>
      				<s:text name="label.common.footer.copyright"></s:text>
      				<span class="pull-right">
      					<s:url id="localeEN" namespace="/" action="locale" >
						   <s:param name="request_locale" >en</s:param>
						</s:url>
						<s:url id="localeJP" namespace="/" action="locale" >
						   <s:param name="request_locale" >jp</s:param>
						</s:url>
						Pizzaccio in 
						<s:a href="%{localeEN}" ><s:text name="label.common.footer.language_en" /></s:a> |
						<s:a href="%{localeJP}" ><s:text name="label.common.footer.language_jp" /></s:a>
      				</span>
      			</div>
			</div>
		</div>
    </div>
  </body>
</html>