package com.kunming.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kunming.service.StudentService;
import com.kunming.serviceImpl.StudentServiceImpl;

@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteStudentServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String Sno = request.getParameter("sno");
		System.out.println(Sno);
		int sno = Integer.parseInt(Sno);
		StudentService studentService = new StudentServiceImpl();
		int i = studentService.deleteStudent(sno);
		PrintWriter out = response.getWriter();
		if(i > 0) {
			out.print("<span style='color:red;font-size:15px;text-aglin:center;'>删除成功</span>");
			response.setHeader("refresh","3;url=SelectAllStudentServlet");
		}else {
			out.print("<span style='color:red;font-size:15px;text-aglin:center;'>删除失败，请重新删除</span>");
			response.setHeader("refresh","3;url=SelectAllStudentServlet");
		}
		
		
	}

}
