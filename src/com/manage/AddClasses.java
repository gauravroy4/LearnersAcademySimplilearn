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

public class AddClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddClasses() {
		super();

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		String classname = request.getParameter("classname");
		String section = request.getParameter("section");

		RequestDispatcher rd = null;

		HttpSession session = request.getSession(false);
		if (session != null) {

			if ((Pattern.matches("[a-zA-Z 0-9]+{20}", classname)) && (Pattern.matches("[A-Z]", section))) {

				try {

					InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
					Properties props = new Properties();
					props.load(in);

					DBConnection connection = new DBConnection(props.getProperty("url"), props.getProperty("userid"),
							props.getProperty("password"));

					CallableStatement clstmt = connection.getConnection().prepareCall("{call addNewClass(?,?)}");
					clstmt.setString(1, classname);
					clstmt.setString(2, section);

					clstmt.executeUpdate();

					clstmt.close();
					connection.closeConnection();

					System.out.println("Class Added succesfully.");

					response.sendRedirect("viewClasses");
				} catch (Exception e) {
					e.printStackTrace();
					rd = request.getRequestDispatcher("classList.jsp");
					rd.include(request, response);
					out.print("<h1 style=\"color:Tomato;\">Invalid input... Please Try Again..</h1>");
				}
			} else {

				rd = request.getRequestDispatcher("classList.jsp");
				rd.include(request, response);
				out.print("<h1 style=\"color:Tomato;\">Invalid input... Please Try Again..</h1>");
			}
		} else {
			response.setHeader("refresh", "5;url='/LearnersAcademyProject'");
		}
	}
}
