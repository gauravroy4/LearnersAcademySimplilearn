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

import com.lms.DBConnection;


public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddStudent() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		String stdname = request.getParameter("stdname");
		String dob = request.getParameter("dob");
		String parent = request.getParameter("parent");
		String contact = request.getParameter("contact");
		String cid = request.getParameter("cid");

		RequestDispatcher rd = null;

		if ((Pattern.matches("[a-zA-Z 0-9]+{20}", stdname)) && (Pattern.matches("[a-zA-Z 0-9]+{20}", parent)) && (Pattern.matches("[1-9]+{2}", cid))) {

			try {

				InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
				Properties props = new Properties();
				props.load(in);

				DBConnection connection = new DBConnection(props.getProperty("url"), props.getProperty("userid"),
						props.getProperty("password"));

				CallableStatement clstmt = connection.getConnection().prepareCall("{call addNewStudent(?,?,?,?,?)}");
				clstmt.setString(1, stdname);
				clstmt.setString(2, dob);
				clstmt.setString(3, parent);
				clstmt.setString(4, contact);
				clstmt.setString(5, cid);
				
				clstmt.executeUpdate();

				clstmt.close();
				connection.closeConnection();
				
				System.out.println("Student Added succesfully.");

				response.sendRedirect("viewStudents");
			} catch (Exception e) {
				e.printStackTrace();
				rd = request.getRequestDispatcher("studentList.jsp");
				rd.include(request, response);
				out.print("<h1 style=\"color:red;\">Invalid input... Please Try Again..</h1>");
			}
		} else {

			rd = request.getRequestDispatcher("studentList.jsp");
			rd.include(request, response);
			out.print("<h1 style=\"color:red;\">Invalid input... Please Try Again..</h1>");
		}
		
		
		
	}

}
