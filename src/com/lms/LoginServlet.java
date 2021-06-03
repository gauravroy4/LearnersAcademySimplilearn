package com.lms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		// HttpSession session = request.getSession(false);
		String userId = request.getParameter("userid");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();
		session.setAttribute("userid", userId);
		session.setAttribute("password", password);

		RequestDispatcher rd = null;

		if (userId.equals("admin") && password.equals("1234")) {
			response.sendRedirect("dashboard");
		} else {
			rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
			out.print("<h1 style=\"color:Tomato;\">Invalid Credentials... Please Try Again..</h1>");

		}

		out.println("</body></html>");
	}

}
