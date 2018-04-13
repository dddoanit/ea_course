<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<title>Add a Book</title>
</head>
<body>
	<form:form action="/books/addBook" modelAttribute="book" action="/books/addBook" method="post">
		<table>
			<form:errors path="*" element="div"></form:errors>
			<tr>
				<td>Title:</td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td>ISBN:</td>
				<td><form:input path="ISBN" /></td>
			</tr>
			<tr>
				<td>Author:</td>
				<td><form:input path="author" /></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><form:input path="price" /></td>
			</tr>
		</table>
		<input type="submit" />
	</form:form>
</body>
</html>