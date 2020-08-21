package com.kunming.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kunming.service.CourseService;
import com.kunming.serviceImpl.CourseServiceImpl;

@WebServlet("/DeleteCourseServlet")
public class DeleteCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteCourseServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String NO = request.getParameter("cno");
		int cno = Integer.parseInt(NO);
		System.out.println(cno);
		CourseService courseService = new CourseServiceImpl();
		int i = courseService.deleteCourse(cno);
		PrintWriter out = response.getWriter();
		if(i > 0) {
			out.print("<span style='color:red;font-size:15px;text-aglin:center;'>删除成功</span>");
			response.setHeader("refresh","3;url=SelectAllCourseServlet");
		}else {
			out.print("<span style='color:red;font-size:15px;text-aglin:center;'>删除失败，请重新删除</span>");
			response.setHeader("refresh","3;url=SelectAllCourseServlet");
		}
	}

}
