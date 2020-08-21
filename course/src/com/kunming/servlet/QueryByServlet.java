package com.kunming.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kunming.bean.SC;
import com.kunming.service.SCService;
import com.kunming.serviceImpl.SCServiceImpl;

@WebServlet("/QueryByServlet")
public class QueryByServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//获取前台数据，如果选择的是课程编号那么这个输入框就是课程编号
		String queryKey=request.getParameter("queryKey");
		//获取下拉列表的值
		String[] parameterValues = request.getParameterValues("type");
		List<SC> list = new ArrayList();
		SCService scService = new SCServiceImpl();
		for(String s:parameterValues) {
			if(s.equals("1")) {
				list=scService.getSCById(Integer.parseInt(queryKey));
				request.setAttribute("list", list);
				request.getRequestDispatcher("stu/query.jsp").forward(request, response);;
			}else if(s.equals("2")) {
				list=scService.getSCBySname(queryKey);
				request.setAttribute("list", list);
				request.getRequestDispatcher("stu/query.jsp").forward(request, response);
			}else if(s.equals("3")) {
				list=scService.getSCBySclass(queryKey);
				request.setAttribute("list", list);
				request.getRequestDispatcher("stu/query.jsp").forward(request, response);
			}else if(s.equals("4")) {
				list=scService.getSCByCname(queryKey);
				request.setAttribute("list", list);
				request.getRequestDispatcher("stu/query.jsp").forward(request, response);
			}else if(s.equals("5")) {
				list=scService.getSCByCno(Integer.parseInt(queryKey));
				request.setAttribute("list", list);
				request.getRequestDispatcher("stu/query.jsp").forward(request, response);
			}else if(s.equals("6")) {
				list=scService.getSCByClassroom(queryKey);
				request.setAttribute("list", list);
				request.getRequestDispatcher("stu/query.jsp").forward(request, response);
			}
		}
		
		
	}

}
