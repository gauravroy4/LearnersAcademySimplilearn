<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Of Classes</title>
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
		<br /> <br />
		<h2>List of Classes</h2>
		<br /> <a class="btn btn-primary" href="dashboard"><h2>Home</h2></a><br>
		<a class="btn btn-info"><h2>Generate Class Report</h2></a>
		<form action="viewClassReport">
		Enter ClassID to generate class report: <input type="number" placeholder="Enter Class from below list" name="classid"><br>
		<input type="submit" value="Submit" />
	</form>
		<br /> <br />
		<table class="table">
			<thead>
				<tr>
					<th>Class Id</th>
					<th>Class Name</th>
					<th>Section</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="cls" items="${classes}">
					<tr>
						<td><c:out value="${cls.classid}" /></td>
						<td><c:out value="${cls.classname}" /></td>
						<td><c:out value="${cls.section}" /></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

	<h3 style="color: #00008B">Add a New Class</h3>
	<form action="AddClasses">
		Enter Class Name: <input type="text" placeholder="Enter Class Name"
			name="classname" /> <br> Enter Section of class: <input
			type="text" placeholder="Enter Class Name" name="section" /> <br>
		<input type="submit" value="Submit" />
		<h2>&nbsp;</h2>
	</form>
	
	<br>
	
	<h3 style="color: #00008B">Update Class Details</h3>
	<form action="updateDetails">
		<input type="hidden" name="action" value="class">
		Enter Class ID : <input type="number" placeholder="Enter Class ID" name="classid" /><br> 
		Enter Class Name: <input type="text" placeholder="Enter Class Name" name="classname" /> <br> 
		Enter Section: <input type="text" placeholder="Enter Section of Class" name="section" /> <br>
		<input type="submit" value="Submit" />
		<h2>&nbsp;</h2>
	</form>

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