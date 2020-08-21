package com.kunming.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kunming.bean.Course;
import com.kunming.service.CourseService;
import com.kunming.serviceImpl.CourseServiceImpl;


@WebServlet("/SelectByIdCourseServlet")
public class SelectByIdCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SelectByIdCourseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决乱码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//获取参数
		String id = request.getParameter("cno");

		//调用service方法
		CourseService courseService = new CourseServiceImpl();
		Course course = courseService.getByidCourse(Integer.parseInt(id));
		//存储到request中
		request.setAttribute("course", course);
		//转发
		request.getRequestDispatcher("tea/updateCou.jsp").forward(request, response);
	
	}
}
