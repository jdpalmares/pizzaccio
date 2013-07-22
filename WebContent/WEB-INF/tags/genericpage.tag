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
	<title><jsp:invoke fragment="pageTitle"/></title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="stylesheet" type="text/css" href="<s:url value="/css/doc.css"/>"/>
	
	<!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
	<!--[if lt IE 9]>
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<script src="<s:url value="/js/jquery-1.9.1.js"/>"></script>
	<sb:head includeStylesResponsive="true" includeScripts="true" includeScriptsValidation="true" includeStyles="true"/>
	</head>
  <body>
  	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				<a class="brand" href="<s:url action="index" namespace="/"/>">J2EEeXER</a>
				<div class="nav-collapse">
					<ul class="nav">
						<li><a href="<s:url action="index" namespace="/"/>">Index</a></li>
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
					   <div class="alert alert-info">
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
      				Copyright &copy; Seth Marquin Busque 2013. All rights reserved.
      			</div>
			</div>
		</div>
    </div>
  </body>
</html>