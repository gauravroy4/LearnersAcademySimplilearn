package com.view;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.*;
import com.pojo.Students;

public class ViewStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewStudents() {
		super();
	}

	StudentDAO stdDAO = new StudentDAO();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			listStudents(request, response);
		} else {
			response.setHeader("refresh", "5;url='/LearnersAcademyProject'");
		}

	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Students> stdList = stdDAO.getAllStudents();
		System.out.println(stdList);

		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");

		request.setAttribute("students", stdList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentList.jsp");
		dispatcher.forward(request, response);
	}

}
