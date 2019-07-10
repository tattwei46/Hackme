<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login JSP Page</title>
</head>
<body>
	<form action="/hackme/search" method="get">
		<h2>Search for products</h2>
		<input type="text" name="bookName" /> <br> <input type="submit" />
	</form>

	<c:if test="${not empty bookList}">
		<table border="1" style="width:100%">
			<tr>
				<td>Name</td>
				<td>Author</td>
			</tr>
			<c:forEach items="${bookList}" var="book">
				<tr>
					<td>${book.name}</td>
					<td>${book.author}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>


</body>
</html>