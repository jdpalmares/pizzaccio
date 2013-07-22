<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
	<jsp:attribute name="pageTitle">
		Index
	</jsp:attribute>
    <jsp:body>
		<h1>Search Users</h1>
		<s:form action="search" namespace="/user" theme="bootstrap" cssClass="form-vertical">
			<div class="row">
				<div class="span10">
					<s:textfield name="user.id" cssClass="input-block-level" placeholder="User ID (e.g. 1, 10, 150)"></s:textfield>
				</div>
				<div class="span2">
					<s:submit cssClass="btn btn-primary btn-block"></s:submit>
				</div>
			</div>
		</s:form>
    </jsp:body>
</t:genericpage>