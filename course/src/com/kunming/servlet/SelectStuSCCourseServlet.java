package com.kunming.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kunming.bean.SC;
import com.kunming.bean.Student;
import com.kunming.service.SCService;
import com.kunming.serviceImpl.SCServiceImpl;

@WebServlet("/SelectStuSCCourseServlet")
public class SelectStuSCCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectStuSCCourseServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		Student student = (Student) session.getAttribute("student");
	/*	String id = request.getParameter("sno");
		int sno = Integer.parseInt(id);*/
		int sno = student.getSno();
		SCService scService = new SCServiceImpl();
		List<SC> list = scService.getStudentCourse(sno);
		request.setAttribute("list", list);
		request.getRequestDispatcher("student/showCou.jsp").forward(request, response);
	}

}
