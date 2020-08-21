package com.kunming.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/InsertStuSCCourseServlet")
public class InsertStuSCCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//从Student类中获取
		HttpSession session = request.getSession();
		String[] values = request.getParameterValues("choiceCou");
		Student student = (Student) session.getAttribute("student");
		//创建service的对象
		SCService scService = new SCServiceImpl();
		if(values.length!=0) {
		SC[] sc = new SC[values.length];
		for (int i = 0; i < values.length; i++) {
			sc[i] = new SC();
			sc[i].setCno(Integer.parseInt(values[i]));
			sc[i].setSno(student.getSno());
			sc[i].setClassroom("0");
		}
		int[] is = scService.insertSC(sc);
		out.print("<span style='color:red;font-size:15px;text-aglin:center;'>选择成功</span>");
		response.setHeader("refresh","3;url=SelectStuSCCourseServlet");
		}
		
	}

}
