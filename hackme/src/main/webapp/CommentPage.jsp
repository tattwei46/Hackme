<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Comment JSP Page</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<a href="/hackme/search">Goto Book Search</a>
		<h2>All Comments</h2>
		<c:if test="${not empty commentList}">
			<table class="table table-bordered">
				<tr>
					<th>Comment</th>
					<th>Author ID</th>
				</tr>
				<c:forEach items="${commentList}" var="comment">
					<tr>
						<td>${comment.comment}</td>
						<td>${comment.authorid}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

		<br>
		<form action="/hackme/comment" method="post">
			<h2>New Comment</h2>
			<input type="text" name="comment" />
			 <br><br> 
			 <input type="submit" />
		</form>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>