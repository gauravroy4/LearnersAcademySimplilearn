package com.manage;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.DBConnection;

public class AddTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddTeacher() {
		super();

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session != null) {
			PrintWriter out = response.getWriter();
			out.println("<html><body>");

			String tname = request.getParameter("tname");
			String contact = request.getParameter("contact");

			RequestDispatcher rd = null;

			if ((Pattern.matches("[a-zA-Z 0-9]+{20}", tname))) {

				try {

					InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
					Properties props = new Properties();
					props.load(in);

					DBConnection connection = new DBConnection(props.getProperty("url"), props.getProperty("userid"),
							props.getProperty("password"));

					CallableStatement clstmt = connection.getConnection().prepareCall("{call addNewTeacher(?,?)}");
					clstmt.setString(1, tname);
					clstmt.setString(2, contact);

					clstmt.executeUpdate();

					clstmt.close();
					connection.closeConnection();

					System.out.println("Teacher Added succesfully.");

					response.sendRedirect("viewTeachers");
				} catch (Exception e) {
					e.printStackTrace();
					rd = request.getRequestDispatcher("teacherList.jsp");
					rd.include(request, response);
					out.print("<h1 style=\"color:Tomato;\">Invalid input... Please Try Again..</h1>");
				}
			} else {

				rd = request.getRequestDispatcher("teacherList.jsp");
				rd.include(request, response);
				out.print("<h1 style=\"color:Tomato;\">Invalid input... Please Try Again..</h1>");
			}

		} else {
			response.setHeader("refresh", "5;url='/LearnersAcademyProject'");
		}
	}

}
