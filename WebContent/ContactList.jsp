<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Site.css"/>
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  	<script type="text/javascript" src="ContactList.js"></script>
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
				<th class ="col-sm-2">Email</th>
				<th class ="col-sm-1"></th>
				<th class ="col-sm-3 CL-ContactList--Button-Panel">
					<div class="pull-right">
						<form class="CL-ContactList--Search-Form" action="Search" method=GET>
							<div class = "input-group">
								<input type="text" name="searchQuery" class =" CL-ContactList--Search-Input form-control"
									placeholder="Search Contacts">
								<span class ="input-group-btn">
									<button type="submit" class="glyphicon glyphicon-search btn btn-info"></button>
								</span>
							</div>
						</form>
						<a href="NewContact.jsp" class="glyphicon glyphicon-plus btn btn-success CL-ContactList--New-Contact-Button"></a>
					</div>
					
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
						<td class ="col-sm-2">${model.getEmail()}</td>
						<td class ="col-sm-1"></td>
						<td class ="col-sm-3">
							<div class="pull-right">
								<form action="GetById" method="GET" class="CL-ContactList--Edit-Form">
									<input type="hidden" name="id" value="${model.getId() }">
									<button type="submit" class="glyphicon glyphicon-pencil btn btn-primary"></button>
								</form>
								<button class="glyphicon glyphicon-trash btn btn-danger" onclick="deleteById(${model.getId()})"></button>
							</div>							
						</td>
					</tr>					
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</div>



</body>
</html>