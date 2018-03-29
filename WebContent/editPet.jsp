<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Pet Information</title>
</head>
<h1>Doggy Chic</h1>
<body>
	<form action = "editAppointmentServlet" method = "post">
	Name: <input type = "text" name = "petName" value = "${petToEdit.petName}">
	Weight: <input type = "text" name = "weight" value = "${petToEdit.weight}"><br/>
	Has current vaccinations (Y/N): <input type = "text" name = "shots" value = "${petToEdit.hasShots}"><br/>
	<input type = "hidden" name = "id" value = "${petToEdit.id}">
	<br/>
	<input type = "submit" value = "Save Pet Information" name = "doThisToItem">
	<img src = "images/dog-grooming2.jpg">
	</form>
</body>
</html>