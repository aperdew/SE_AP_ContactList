<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="Site.css"/>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Contact</title>
</head>
<body>
<%@include file="Banner.html" %>
		
	<div class ="container CL-NewContact--Container">
	<h1 class = "CL-NewContact--Title">New Contact</h1>
		<form action="ContactList" method="post" class="form-horizontal">
			<div class="row form-group">
				<label class="control-label col-sm-2 CL-NewContact--Label" for="firstName">First Name:</label>
				<input type="text" class="form-control col-sm-10" id="firstName" name="firstName">
			</div>
			<div class="row form-group">
				<label class="control-label col-sm-2 CL-NewContact--Label" for="lastName">Last Name:</label>
				<input type="text" class="form-control col-sm-10" id="lastName" name="lastName">
			</div>
			<div class="row form-group">
				<label class="control-label col-sm-2 CL-NewContact--Label" for="phone">Phone Number:</label>
				<input type="text" class="form-control col-sm-10" id="phone" name="phone">
			</div>
			<div class="row form-group">
				<label class="control-label col-sm-2 CL-NewContact--Label" for="email">Email:</label>
				<input type="text" class="form-control col-sm-10" id="email" name="email">
			</div>
			<div class="row form-group">
				<label class="control-label col-sm-2 CL-NewContact--Label" for="address">Address:</label>
				<input type="text" class="form-control col-sm-10" id="address" name="address">
			</div>
			<div class="row form-group">
			</div>
			<div class="row form-group">
				<div class="col-sm-offset-11">
					<input class="btn btn-default btn-warning" type="submit" value="Submit">
				</div>
			</div>
		</form>
	</div>
</body>
</html>