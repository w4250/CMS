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

@WebServlet("/SelectAllCourseServlet")
public class SelectAllCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决乱码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//调用service方法
		CourseService courseService = new CourseServiceImpl();
		List<Course> list = courseService.getAllCourse();
		//转发
		request.setAttribute("list", list);
		request.getRequestDispatcher("tea/selectCou.jsp").forward(request, response);
	}

}
