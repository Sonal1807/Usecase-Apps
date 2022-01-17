<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	

	<div align="center">
	<h1>Employee List</h1>
		<table border="2" style="background-color: #e0ffff">
			<tr>
				<th>Name</th>
				<th>ProjectDetails</th>
				<th>Mail Id</th>
				<th>phone number</th>
			</tr>
			<c:forEach items="${employeeList}" var="emp">
				<tr>
					<td>${emp.name}</td>
					<td>${emp.project}</td>
					<td>${emp.mailId}</td>
					<td>${emp.phoneNo}</td>
					<td><a href="updateEmployee?employeeId=${emp.employeeId}">UPDATE</a>
					<td><a href="deleteEmployee/${emp.employeeId}">DELETE</a>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div
		style="text-align: center; border: 1px solid black; margin-left: 40%; margin-right: 40%; background-color: #e0ffff">

		<a href="search" class="btn btn-warning">SEARCH EMPLOYEE</a>
	</div>
	<div
		style="text-align: center; border: 1px solid black; margin-left: 40%; margin-right: 40%; background-color: #e0ffff">
		<a href="addemployee" class="btn btn-warning">ADD EMPLOYEE</a>
	</div>

</body>
</html>