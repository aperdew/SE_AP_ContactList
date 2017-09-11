<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
	<link rel="stylesheet" href="Site.css"/>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Contact</title>
</head>
<body>
<%@ page isELIgnored="false" %>
<%@include file="html/Banner.html" %>
<%@ page import ="contactlist.models.contactModel" %>	
		
	<div class ="container CL-NewContact--Container">
	<h1 class = "CL-NewContact--Title">Edit Contact</h1>
		<form action="Edit" method="POST" class="form-horizontal">
			<input type="hidden" name="id" value="${contact.getId()}">
			<div class="row form-group">
				<label class="control-label col-sm-2 CL-NewContact--Label" for="firstName">First Name:</label>
				<div class = "col-sm-10">
					<input type="text" class="form-control" id="firstName" name="firstName" required value="${contact.getFirstName()}">
				</div>
			</div>
			<div class="row form-group">
				<label class="control-label col-sm-2 CL-NewContact--Label" for="lastName">Last Name:</label>
				<div class = "col-sm-10">
					<input type="text" class="form-control" id="lastName" name="lastName" required value="${contact.getLastName()}">
				</div>
			</div>
			<div class="row form-group">
				<label class="control-label col-sm-2 CL-NewContact--Label" for="phone">Phone Number:</label>
				<div class = "col-sm-10">
					<input type="tel" class="form-control" id="phone" name="phone" value="${contact.getPhone()}">
				</div>
			</div>
			<div class="row form-group">
				<label class="control-label col-sm-2 CL-NewContact--Label" for="email">Email:</label>
				<div class = "col-sm-10">
					<input type="email" class="form-control" id="email" name="email" value="${contact.getEmail()}">
				</div>
			</div>
			<div class="row form-group">
				<label class="control-label col-sm-2 CL-NewContact--Label" for="address">Address:</label>
				<div class = "col-sm-10">
					<input type="text" class="form-control" id="address" name="address" value="${contact.getAddress()}">
				</div>
			</div>
			<div class="row form-group">
				<div class="col-sm-offset-10">					
					<input class="btn btn-default btn-success" type="submit" value="Submit">
					<a href="Contacts" class = "btn btn-default btn-danger">Cancel</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>