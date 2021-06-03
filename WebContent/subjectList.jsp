<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Subject List</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
</head>
<body>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	%>

	<%
		if (session != null) {
	%>

	<div class="container">
		<br />
		<br />
		<h2>List of Subjects</h2>
		<br /> <a class="btn btn-primary" href="dashboard"><h2>Home</h2></a> <br />
		<br />
		<table class="table">
			<thead>
				<tr>
					<th>Subject Id</th>
					<th>Subject Name</th>
					<th>Language of subject</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="sub" items="${subjects}">
					<tr>
						<td><c:out value="${sub.subid}" /></td>
						<td><c:out value="${sub.subname}" /></td>
						<td><c:out value="${sub.language}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

	<a class="btn btn-danger" href="logout">Logout</a>
	<%@include file='footer.html' %>

	<%
		} else {
		response.setHeader("refresh", "5;url='/LearnersAcademyProject'");
	}
	%>

	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
		crossorigin="anonymous"></script>
</body>
</html>