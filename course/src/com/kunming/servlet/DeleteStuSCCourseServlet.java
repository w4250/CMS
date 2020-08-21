package com.kunming.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kunming.bean.Student;
import com.kunming.service.SCService;
import com.kunming.serviceImpl.SCServiceImpl;

@WebServlet("/DeleteStuSCCourseServlet")
public class DeleteStuSCCourseServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String Cno = request.getParameter("cno");
		int cno = Integer.parseInt(Cno);
		HttpSession session = request.getSession();
		Student student = (Student) session.getAttribute("student");
		SCService scService = new SCServiceImpl();
		int sno = student.getSno();
		int i = scService.deleteStudentCourse(sno, cno);
		PrintWriter out = response.getWriter();
		if(i > 0) {
			out.print("<span style='color:red;font-size:15px;text-aglin:center;'>取消成功</span>");
			response.setHeader("refresh","3;url=SelectStuSCCourseServlet");
		}else {
			out.print("<span style='color:red;font-size:15px;text-aglin:center;'>取消失败，请重新操作</span>");
			response.setHeader("refresh","3;url=SelectStuSCCourseServlet");
		}

		
		
	}

}
