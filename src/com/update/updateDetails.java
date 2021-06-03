package com.update;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.DBConnection;

public class updateDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public updateDetails() {
		super();

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			String action = request.getParameter("action");

			PrintWriter out = response.getWriter();
			RequestDispatcher rd = null;

			try {
				InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
				Properties props = new Properties();
				props.load(in);

				DBConnection connection = new DBConnection(props.getProperty("url"), props.getProperty("userid"),
						props.getProperty("password"));

				if (action.equals("teacher")) {
					String tid = request.getParameter("tid");
					String tname = request.getParameter("tname");
					String contact = request.getParameter("contact");

					CallableStatement clstmt = connection.getConnection().prepareCall("{call updateTeacher(?,?,?)}");
					clstmt.setString(1, tid);
					clstmt.setString(2, tname);
					clstmt.setString(3, contact);

					clstmt.executeUpdate();

					clstmt.close();
					connection.closeConnection();

					System.out.println("Teacher Data Updated succesfully.");

					response.sendRedirect("viewTeachers");
				}
				if (action.equals("student")) {
					String stdid = request.getParameter("stdid");
					String stdname = request.getParameter("stdname");
					String dob = request.getParameter("dob");
					String parent = request.getParameter("parent");
					String contact = request.getParameter("contact");
					String cid = request.getParameter("cid");

					CallableStatement clstmt = connection.getConnection()
							.prepareCall("{call updateStudent(?,?,?,?,?,?)}");
					clstmt.setString(1, stdid);
					clstmt.setString(2, stdname);
					clstmt.setString(3, dob);
					clstmt.setString(4, parent);
					clstmt.setString(5, contact);
					clstmt.setString(6, cid);

					clstmt.executeUpdate();

					clstmt.close();
					connection.closeConnection();

					System.out.println("Student Data Updated succesfully.");

					response.sendRedirect("viewStudents");
				}

				if (action.equals("class")) {

					String cid = request.getParameter("classid");
					String cname = request.getParameter("classname");
					String sec = request.getParameter("section");

					CallableStatement clstmt = connection.getConnection().prepareCall("{call updateClass(?,?,?)}");
					clstmt.setString(1, cid);
					clstmt.setString(2, cname);
					clstmt.setString(3, sec);

					clstmt.executeUpdate();

					clstmt.close();
					connection.closeConnection();

					System.out.println("Class Data Updated succesfully.");

					response.sendRedirect("viewClasses");
				}

				if (action.equals("showAssign")) {

					CallableStatement clstmt = connection.getConnection().prepareCall("{call showAssignClass()}");

					clstmt.executeUpdate();

					clstmt.close();
					connection.closeConnection();

					System.out.println("Assigned Records Displayed succesfully.");

					response.sendRedirect("viewAssignClass");
				}

				if (action.equals("updateAssign")) {

					String record = request.getParameter("record");
					String cid = request.getParameter("classid");
					String subid = request.getParameter("subjectid");
					String tid = request.getParameter("teacherid");

					CallableStatement clstmt = connection.getConnection()
							.prepareCall("{call updateAssignClass(?,?,?,?)}");

					clstmt.setString(1, record);
					clstmt.setString(2, cid);
					clstmt.setString(3, subid);
					clstmt.setString(4, tid);

					clstmt.executeUpdate();

					clstmt.close();
					connection.closeConnection();

					System.out.println("Records Updated succesfully.");

					response.sendRedirect("viewAssignClass");
				}

				if (action.equals("addAssign")) {

					String cid = request.getParameter("classid");
					String subid = request.getParameter("subjectid");
					String tid = request.getParameter("teacherid");

					CallableStatement clstmt = connection.getConnection().prepareCall("{call addAssignRecord(?,?,?)}");

					clstmt.setString(1, cid);
					clstmt.setString(2, subid);
					clstmt.setString(3, tid);

					clstmt.executeUpdate();

					clstmt.close();
					connection.closeConnection();

					System.out.println("Record inserted succesfully.");

					response.sendRedirect("viewAssignClass");
				}

				if (action.equals("deleteAssign")) {

					String record = request.getParameter("record");

					CallableStatement clstmt = connection.getConnection()
							.prepareCall("{call deleteRecordAssignClass(?)}");
					clstmt.setString(1, record);

					clstmt.executeUpdate();

					clstmt.close();
					connection.closeConnection();

					System.out.println("Record Deleted succesfully.");

					response.sendRedirect("viewAssignClass");
				}

			} catch (Exception e) {
				e.printStackTrace();
				rd = request.getRequestDispatcher("classList.jsp");
				rd.include(request, response);
				out.print("<h1 style=\"color:Tomato;\">Invalid input... Please Try Again..</h1>");
			}
		} else {
			response.setHeader("refresh", "5;url='/LearnersAcademyProject'");
		}
	}
}
