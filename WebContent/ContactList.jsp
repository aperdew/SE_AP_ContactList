<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<link rel="stylesheet" href="Site.css"/>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contacts</title>
</head>
<body>
<%@ page isELIgnored="false" %>
<%@include file="html/Banner.html" %>
<%@ page import ="java.util.ArrayList,
				  contactlist.models.contactModel" %>

<%
	ArrayList<contactModel> contactList = (ArrayList<contactModel>) request.getAttribute("contactList");
%>

<div class ="container">
	<h1 class = "CL-NewContact--Title">Contacts</h1>
	<table class ="table table-striped">
		<thead>
			<tr>
				<th class ="col-sm-2">First Name</th>
				<th class ="col-sm-2">Last Name</th>
				<th class ="col-sm-2">Phone Number</th>
				<th class ="col-sm-3"></th>
				<th>
					
					<button class="glyphicon glyphicon-search btn btn-info"></button>
					<a href="NewContact.jsp" class="glyphicon glyphicon-plus btn btn-success"></a>
				</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${contactList !=null }">
				<c:forEach items = "${contactList}" var="model">
					<tr>
						<td class ="col-sm-2">${model.getFirstName()}</td>
						<td class ="col-sm-2">${model.getLastName()}</td>
						<td class ="col-sm-2">${model.getPhone()}</td>
						<td class ="col-sm-3"></td>
						<td>
							<button class="glyphicon glyphicon-pencil btn btn-primary"></button>
							<button class="glyphicon glyphicon-trash btn btn-danger"></button>
						</td>
					</tr>					
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</div>



</body>
</html>