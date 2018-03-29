<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Your Pet</title>
</head>
<h1>Doggy Chic</h1>
<body>
	<p>Please select correct pet:</p>
	<form method = "post" action = "setCustomerServlet">
	<p>Please select correct pet:</p>
	<table>
	<c:forEach items = "${requestScope.matchingPets}" var = "currentpet">
	<tr>		<td><input type="radio" name="id" value="${currentpet.id}"></td>
		<td>${currentpet.petName}</td>
		<td>${' '}</td>
		<td>${currentpet.weight}</td>
		<td>${'lbs'}</td>
	</tr>
	</c:forEach>
	</table>
	<br/>
	<input type = "submit" value = "Select Pet" name = "doThisToItem">
	<input type = "submit" value = "New Pet" name = "doThisToItem">
	<img src = "images/dog-grooming1.jpg">
	</form>
</body>
</html>