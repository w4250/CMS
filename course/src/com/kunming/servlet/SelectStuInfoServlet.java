package com.kunming.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kunming.bean.SC;
import com.kunming.service.SCService;
import com.kunming.serviceImpl.SCServiceImpl;

@WebServlet("/SelectStuInfoServlet")
public class SelectStuInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int sno = Integer.parseInt(request.getParameter("sno"));
		SCService scService = new SCServiceImpl();
		List<SC> list = scService.getSCById(sno);
		request.setAttribute("list", list);
		request.getRequestDispatcher("student/stuInfo.jsp").forward(request, response);
		
	}

}
