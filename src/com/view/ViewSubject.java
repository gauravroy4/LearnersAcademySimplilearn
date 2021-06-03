package com.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.SubjectDAO;
import com.pojo.Subjects;

public class ViewSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewSubject() {
		super();

	}

	SubjectDAO subDAO = new SubjectDAO();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			listClasses(request, response);
		} else {
			response.setHeader("refresh", "5;url='/LearnersAcademyProject'");
		}

	}

	private void listClasses(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Subjects> subList = subDAO.getAllSubjects();
		System.out.println(subList);

		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");

		request.setAttribute("subjects", subList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("subjectList.jsp");
		dispatcher.forward(request, response);
	}
}
