package com.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.AssignClassDAO;
import com.pojo.AssignClass;

public class viewAssignClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public viewAssignClass() {
		super();
	}

	AssignClassDAO acDAO = new AssignClassDAO();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			listAssignClass(request, response);
		} else {
			response.setHeader("refresh", "5;url='/LearnersAcademyProject'");
		}
	}

	private void listAssignClass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<AssignClass> acList = acDAO.getAllAssignClass();
		System.out.println(acList);

		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");

		request.setAttribute("assignclasses", acList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("assignClassList.jsp");
		dispatcher.forward(request, response);
	}

}
