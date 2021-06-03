<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Assigned Classes</title>
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
		<h2>List of Assigned Classes and Teachers</h2>
		<br /> <a class="btn btn-primary" href="dashboard"><h2>Home</h2></a> <br />
		<br />
		<table class="table">
			<thead>
				<tr>
					<th>Record No.</th>
					<th>Class ID</th>
					<th>Subject ID</th>
					<th>Teacher ID</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="asc" items="${assignclasses}">
					<tr>
						<td><c:out value="${asc.sno}" /></td>
						<td><c:out value="${asc.classid}" /></td>
						<td><c:out value="${asc.subjectid}" /></td>
						<td><c:out value="${asc.teacherid}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	<h2 style="color: #bf00ff;">Master List</h2><br /> 
	<a class="btn btn-info" href="viewClasses"><h2>Classes</h2></a>
	<a class="btn btn-info" href="viewTeachers"><h2>Teachers</h2></a>
	<a class="btn btn-info" href="viewSubjects"><h2>Subjects</h2></a>
		
	<h3 style="color: #00008B">Assign Teacher For a class and subject</h3>
	<form action="updateDetails">
		<input type="hidden" name="action" value="addAssign">
		
		Enter Class ID : <input type="number" placeholder="Enter Class ID" name="classid" /><br> 
		Enter Subject ID: <input type="number" placeholder="Enter Subject ID" name="subjectid" /> <br> 
		Enter Teacher ID: <input type="number" placeholder="Enter Teacher ID" name="teacherid" /> <br>
		<input type="submit" value="Submit" />
		<h2>&nbsp;</h2>
	</form>
	<br>
		<h3 style="color: #00008B">Update Teacher, class and subject from an assigned record</h3>
	<form action="updateDetails">
		<input type="hidden" name="action" value="updateAssign">
		Enter Record Number : <input type="number" placeholder="Enter Record Number From List" name="record" /><br> 
		Enter Class ID : <input type="number" placeholder="Enter Class ID" name="classid" /><br> 
		Enter Subject ID: <input type="number" placeholder="Enter Subject ID" name="subjectid" /> <br> 
		Enter Teacher ID: <input type="number" placeholder="Enter Teacher ID" name="teacherid" /> <br>
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