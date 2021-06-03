<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teachers List</title>
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
	
	<%if(session!=null){ %>
	
	<div class="container">
	<br/><br/>
	<h2>List of Teachers</h2>
	<br/>
	<a class="btn btn-primary" href = "dashboard"><h2>Home</h2></a>
	<br/><br/>
	<table class="table">
		<thead>
			<tr>
				<th>Teacher Id</th>
				<th>Teacher Name</th>
				<th>Contact@Info</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="t" items="${teachers}">
				<tr>
					<td><c:out value="${t.tid}" /></td>
					<td><c:out value="${t.tname}" /></td>
					<td><c:out value="${t.contact}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	</div>
	
	<h3 style="color: #00008B">Add a New Teacher</h3>
	<form action="AddTeacher">
		Enter Teacher Name: <input type="text" placeholder="Enter Teacher Name" name="tname" /> <br> 
		Enter Contact Email: <input type="email" placeholder="Enter Email ID" name="contact" /> <br>
		<input type="submit" value="Submit" />
		<h2>&nbsp;</h2>
	</form>
	
	<br>
	
	<h3 style="color: #00008B">Update Teacher Details</h3>
	<form action="updateDetails">
		<input type="hidden" name="action" value="teacher">
		Enter Teacher ID : <input type="number" placeholder="Enter Teacher ID" name="tid" /><br> 
		Enter Teacher Name: <input type="text" placeholder="Enter Teacher Name" name="tname" /> <br> 
		Enter Contact Email: <input type="email" placeholder="Enter Email ID" name="contact" /> <br>
		<input type="submit" value="Submit" />
		<h2>&nbsp;</h2>
	</form>
	
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