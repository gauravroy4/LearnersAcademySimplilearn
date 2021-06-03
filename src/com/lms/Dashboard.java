package com.lms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Dashboard() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");

		PrintWriter out = response.getWriter();
		out.println("<html> <head> <style> h3,h2 {text-align: center;} </style> </head> <body bgcolor='cyan'>");

		HttpSession session = request.getSession(false);
		if (session != null) {
			String userId = (String) session.getAttribute("userid");
			out.println("Hello " + userId+" You are logged in.");
			out.println("<h2 style='background-color:Tomato;'>WELCOME TO LEARNER'S ACADEMY</h2><br>");
			out.println("<a href='viewStudents'><h3>Click For Details Of All the Students</h3></a><br>");
			out.println("<a href='viewClasses'><h3>Click For Details Of All the Classes</h3></a><br>");
			out.println("<a href='viewTeachers'><h3>Click For Details Of All the Teachers</h3></a><br>");
			out.println("<a href='viewSubjects'><h3>Click For Details Of All the Subjects</h3></a><br>");

			out.println("<a href='viewAssignClass'><h3>Click to Assign Class for subjects</h3></a><br>");
			out.println("<a href='viewAssignClass'><h3>Click to Assign teacher to a class</h3></a><br>");

			out.println("<a href='viewStudents'><h3>Show Student Master List</h3></a><br>");

			out.println("<a href='viewClasses'><h3>Show Class Report</h3></a><br>");

			out.println("<br><br><a href='logout'><h3>Logout</h3></a><br>");
			out.println("<h3>Developer Name: Gaurav Kumar Contact@Info: roygaurav000@gmail.com This Project is developed for Simplilearn's Phase 2 Assessment.</h3>");
		} else {
			response.setHeader("refresh", "5;url='/index.html'");
		}
		out.println("</body></html>");
	}

}
