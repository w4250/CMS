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

@WebServlet("/UpdateCourseServlet")
public class UpdateCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateCourseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charest=UTF-8");
		String cnoStr = request.getParameter("CNo");
		int cno = Integer.parseInt(cnoStr);
		String cname = request.getParameter("Cname");
		String ccreditStr = request.getParameter("Ccredit");
		float ccredit = Float.parseFloat(ccreditStr);
		Course course = new Course();
		course.setCno(cno);
		course.setCname(cname);
		course.setCcredit(ccredit);
		CourseService courseService = new CourseServiceImpl();
		int i = courseService.updateCourse(course);
		if(i>0) {
			response.sendRedirect("SelectAllCourseServlet");
		}else {
			request.setAttribute("msg", "修改失败");
		}
	}

}
