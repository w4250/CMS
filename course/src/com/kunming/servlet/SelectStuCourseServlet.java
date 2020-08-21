package com.kunming.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kunming.bean.Course;
import com.kunming.service.CourseService;
import com.kunming.serviceImpl.CourseServiceImpl;

@WebServlet("/SelectStuCourseServlet")
public class SelectStuCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		CourseService courservice = new CourseServiceImpl();
		List<Course> list = courservice.getAllCourse();
		request.setAttribute("list", list);
		request.getRequestDispatcher("student/choiceCou.jsp").forward(request, response);
	}

}
