package com.lms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LogoutServlet() {
        super();

    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		
		
		HttpSession session = request.getSession(false);
		session.invalidate();
		RequestDispatcher rd = null;
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		rd = request.getRequestDispatcher("index.html");
		rd.include(request, response);
		out.println("<h2>Logged out of sesssion.</h2><br>");
		response.setHeader("refresh", "5;url='/index.html'");
		out.println("</body></html>");
	}

}
