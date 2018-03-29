<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Information</title>
</head>
<h1>Doggy Chic</h1>
<body>
	<p>Please select correct customer:</p>
	<form method = "post" action = "setCustomerServlet">
	<p>Please select correct customer:</p>	
	<table>
	<c:forEach items = "${requestScope.matchingCustomers}" var = "currentcustomer">
	<tr>
		<td><input type="radio" name="id" value="${currentcustomer.id}"></td>
		<td>${currentcustomer.firstName}</td>
		<td>${currentcustomer.lastName}</td>
		<td>${currentcustomer.address}</td>
	</tr>
	</c:forEach>
	</table>
	<br/>
	<input type = "submit" value = "Select Customer" name = "doThisToItem">
	<input type = "submit" value = "New Customer" name = "doThisToItem">
	<img src = "images/dogGroup2.jpg">
	</form>
</body>
</html>