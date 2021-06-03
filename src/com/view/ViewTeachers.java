package com.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.TeacherDAO;
import com.pojo.Teachers;

public class ViewTeachers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewTeachers() {
		super();

	}

	TeacherDAO tDAO = new TeacherDAO();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			listTeachers(request, response);
		} else {
			response.setHeader("refresh", "5;url='/LearnersAcademyProject'");
		}
	}

	private void listTeachers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Teachers> tList = tDAO.getAllTeachers();
		System.out.println(tList);

		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");

		request.setAttribute("teachers", tList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("teachersList.jsp");
		dispatcher.forward(request, response);
	}

}
