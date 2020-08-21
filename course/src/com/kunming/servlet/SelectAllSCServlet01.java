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

@WebServlet("/SelectAllSCServlet01")
public class SelectAllSCServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectAllSCServlet01() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		SCService scService = new SCServiceImpl();
		List<SC> list = scService.getAllSC01();
		request.setAttribute("list", list);
		request.getRequestDispatcher("stu/query.jsp").forward(request, response);
		
	}

}
