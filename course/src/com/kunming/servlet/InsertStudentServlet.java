package com.kunming.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kunming.bean.Student;
import com.kunming.service.StudentService;
import com.kunming.serviceImpl.StudentServiceImpl;

@WebServlet("/InsertStudentServlet")
public class InsertStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertStudentServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String Sname = request.getParameter("Sname");
		String Spassword = request.getParameter("Spassword");
		String Sclass = request.getParameter("Sclass");
		String Ssex = request.getParameter("Ssex");
		Student student = new Student();
		student.setSname(Sname);
		student.setSpassword(Spassword);
		student.setSclass(Sclass);
		student.setSsex(Ssex);
		PrintWriter out = response.getWriter();
		StudentService studentService = new StudentServiceImpl();
		int i = studentService.insertStu(student);
		if(i>0) {
			out.print("<span style='color:red;font-size:15px;text-aglin:center;'>添加成功</span>");
			response.setHeader("refresh","3;url=SelectAllStudentServlet");
		}else {
			out.print("<span style='color:red;font-size:15px;text-aglin:center;'>添加失败，请重新添加</span>");
			response.setHeader("refresh","3;url=stu/InsertStu.jsp");
		}
	}

}
