package com.kunming.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kunming.bean.Course;
import com.kunming.service.CourseService;
import com.kunming.serviceImpl.CourseServiceImpl;


@WebServlet("/InsertCourseServlet")
public class InsertCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public InsertCourseServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决乱码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//获取前台数据
		String cname = request.getParameter("Cname");
		String ccreditStr = request.getParameter("Ccredit");
		//String类型转换成int使用Interger.parseInt();
		//String类型转换成float类型，使用Float方法
		float ccredit =  Float.parseFloat(ccreditStr);
		
		System.out.println(ccredit);
		Course course = new Course();
		course.setCcredit(ccredit);
		course.setCname(cname);
		//调用service方法
		CourseService courseService = new CourseServiceImpl();
		int i = courseService.insertCourse(course);
		if(i > 0) {
			out.print("<span style='color:red;font-size:15px;text-aglin:center;'>添加成功</span>");
			response.setHeader("refresh","3;url=SelectAllCourseServlet");
		}else {
			out.print("<span style='color:red;font-size:15px;text-aglin:center;'>添加失败，请重新添加</span>");
			response.setHeader("refresh","3;url=tea/InsertCou.jsp");
		}
		
	}

}
