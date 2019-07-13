<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fake Login JSP Page</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<h2>Fake Login</h2>
		<br> <font color="red">${errorMessage}</font>
		<form action="/hackme/fakelogin" method="post">
			<div class="form-group">
				<label>UserName: </label> <input type="text" name="username"
					placeholder="Enter email" />
			</div>
			<div class="form-group">
				<label>Password: </label> <input type="text" name="password" placeholder="Enter password"/>
				<br><br>
				<button type="submit" class="btn btn-primary">Login</button>
			</div>
		</form>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>