package com.view;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.DBConnection;

public class viewClassReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public viewClassReport() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		PrintWriter out = response.getWriter();
		out.println(
				"<html><head><style> table, th, td { border: 1px solid black; border-collapse: collapse;} th, td { padding: 5px; text-align: left;} </style></head><body>");
		out.println("");
		HttpSession session = request.getSession(false);
		if (session != null) {
			try {

				String classid = request.getParameter("classid");

				InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
				Properties props = new Properties();
				props.load(in);

				DBConnection conn = new DBConnection(props.getProperty("url"), props.getProperty("userid"),
						props.getProperty("password"));

				Statement stmt = conn.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);

				out.println("<h2 style='color: #00008B;'>CLass Report Generated</h2>");

				ResultSet rst1 = stmt
						.executeQuery("SELECT st.stdid, st.stdname FROM students st WHERE st.cid=" + classid + ";");

				out.println(
						"<table style='width:100%'> <tr> <th>Students</th><th>Subjects</th> <th>Teachers</th> </tr> <tr> <td>");

				int count1 = 1;
				while (rst1.next()) {

					out.println(count1 + ":   StudentID: " + rst1.getInt(1) + "    Student Name:   " + rst1.getString(2)
							+ "<br>");
					count1++;
				}

				ResultSet rst2 = stmt.executeQuery(
						"SELECT s.subid, s.subname FROM subjects s , assignclass ac WHERE ac.subjectid=s.subid AND ac.classid="
								+ classid + ";");

				out.println("</td><td>");

				int count2 = 1;
				while (rst2.next()) {

					out.println(count2 + ":   SubjectID: " + rst2.getInt(1) + "    Subject Name:   " + rst2.getString(2)
							+ "<br>");
					count2++;
				}

				ResultSet rst3 = stmt.executeQuery(
						"SELECT t.tid, t.tname FROM teachers t , assignclass ac WHERE ac.teacherid=t.tid AND ac.classid="
								+ classid + ";");

				out.println("</td><td>");

				int count3 = 1;
				while (rst3.next()) {

					out.println(count3 + ":   TeacherID: " + rst3.getInt(1) + "    Teacher Name:   " + rst3.getString(2)
							+ "<br>");
					count3++;
				}

				stmt.close();

				out.println("</td></tr></table>");

				out.println("<a class='btn btn-info' href='viewClasses'><h2>Home</h2></a>");

				System.out.println("Class Report Generated...");

				out.println("</body></html>");

				conn.closeConnection();

			} catch (ClassNotFoundException | SQLException e) {
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
