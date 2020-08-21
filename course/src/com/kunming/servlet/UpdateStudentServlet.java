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

@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateStudentServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("SNo");
		int sno = Integer.parseInt(id);
		String sname = request.getParameter("Sname");
		String spassword = request.getParameter("Spassword");
		String sclass = request.getParameter("Sclass");
		String ssex = request.getParameter("Ssex");
		Student student = new Student();
		student.setSno(sno);
		student.setSname(sname);
		student.setSpassword(spassword);
		student.setSclass(sclass);
		student.setSsex(ssex);
		PrintWriter out = response.getWriter();
		StudentService studentService = new StudentServiceImpl();
		int i = studentService.updateStudent(student);
		if(i > 0) {

			out.print("<span style='color:red;font-size:15px;text-aglin:center;'>更改成功</span>");
			response.setHeader("refresh","3;url=SelectAllStudentServlet");
		}else {
			out.print("<span style='color:red;font-size:15px;text-aglin:center;'>更改失败，请重新删除</span>");
			response.setHeader("refresh","3;url=SelectAllStudentServlet");
		}
	}
}
