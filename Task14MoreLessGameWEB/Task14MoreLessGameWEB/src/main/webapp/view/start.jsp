<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.javaweb.controller.config.Initialization"%>
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
		<div class="inner inner3">
			<p>Start with your custom limits</p>
			<form id="FormCustom" action="ControllerMain">
				<c:out value="low bound setup : ${Initialization.LOW_BOUND_SETUP}" />
				<p>${Initialization.LOW_BOUND_SETUP}</p>
				<input name="${Initialization.LOW_BOUND_SETUP}" type="number"
					placeholder="Low bound" /> <br /> 
				<input name="${Initialization.HIGH_BOUND_SETUP}" type="number"
					placeholder="High bound" /> <br />
				<button>Accept and play</button>
			</form>
		</div>
		<div class="inner inner3">
			<p>Start with default limits (0 - 100)</p>
			<form action="ControllerMain">
				<button class="centered-button">Play</button>
			</form>
		</div>
	</div>
</body>
</html>