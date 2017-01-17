<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.javaweb.controller.config.Attributes"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>More-Less game</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<h1 class="centerFlex">More-Less Game</h1>
	<div id="WholeContainer" class="centerFlex">
		<p>${requestScope[Attributes.LOW_LIMIT]} - ${requestScope[Attributes.HIGH_LIMIT]}</p>
	</div>
</body>
</html>