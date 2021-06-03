<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 5px;
  text-align: left;    
}
</style>
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
		<h2>List of Students</h2>
		<br /> <a class="btn btn-primary" href="dashboard"><h2>Home</h2></a>
		<br /> <br />
		<table class="table">
			<thead>
				<tr>
					<th>Student Id</th>
					<th>Student Name</th>
					<th>DateOfBirth</th>
					<th>Parent's Name</th>
					<th>Contact@info</th>
					<th>Class ID</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="std" items="${students}">
					<tr>
						<td><c:out value="${std.stdid}" /></td>
						<td><c:out value="${std.stdname}" /></td>
						<td><c:out value="${std.dob}" /></td>
						<td><c:out value="${std.parent}" /></td>
						<td><c:out value="${std.contact}" /></td>
						<td><c:out value="${std.cid}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	
	<br>
	
	<table style="width:100%">
  <tr>
    <td><h3 style="color: #00008B">Add a New Student</h3>
	<form action="AddStudent">
		Enter Student Name: <input type="text"
			placeholder="Enter Student Name" name="stdname" /> <br> Enter
		Date of birth:<input type="date" placeholder="YYYY-MM-DD" name="dob" />
		<br> Enter Parent's Name: <input type="text"
			placeholder="Enter Parent's Name" name="parent" /> <br> Enter
		Contact Number: <input type="text" placeholder="Enter Contact Number"
			name="contact" /> <br> Assign Class: <input type="number"
			placeholder="Enter Class ID" name="cid" /> <br> <input
			type="submit" value="Submit" />
		<h2>&nbsp;</h2>
	</form>
	</td>
	
    <td><h3 style="color: #00008B">Update Student Details</h3>
	<form action="updateDetails">
		<input type="hidden" name="action" value="student">
		Enter Student ID: <input type="number" placeholder="Enter Student ID" name="stdid"><br>
		Enter Student Name: <input type="text" placeholder="Enter Student Name" name="stdname" /> <br> 
		Enter Date of birth:<input type="date" placeholder="YYYY-MM-DD" name="dob" /><br>
		<br> Enter Parent's Name: <input type="text" placeholder="Enter Parent's Name" name="parent" /> <br> 
		Enter Contact Number: <input type="text" placeholder="Enter Contact Number" name="contact" /> <br> 
		Assign Class: <input type="number" placeholder="Enter Class ID" name="cid" /> <br> 
		<input type="submit" value="Submit" />
		<h2>&nbsp;</h2>
	</form></td>
  </tr>
</table>
	
	

	<a class="btn btn-danger" href="logout">Logout</a>
	
	<%@include file='footer.html' %>

	<%} else { response.setHeader("refresh", "5;url='/LearnersAcademyProject'"); } %>

	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
		crossorigin="anonymous"></script>
</body>
</html>