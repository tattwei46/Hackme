<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search JSP Page</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<a href="/hackme/comment">Goto Comments</a>
		<a href="/hackme/login">Logout</a> <br>
		<h2>Book Search Results</h2>
		<c:if test="${not empty bookList}">
			<table class="table table-bordered">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Author</th>
				</tr>
				<c:forEach items="${bookList}" var="book">
					<tr>
						<td>${book.id}</td>
						<td>${book.name}</td>
						<td>${book.author}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<br>
		<h2>Search for a book</h2>
		<form action="/hackme/search" method="get">
			<input type="text" name="bookName" /> <br>
			<br> <input type="submit" />
		</form>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>