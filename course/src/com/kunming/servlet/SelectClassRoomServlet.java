package com.kunming.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kunming.bean.SC;
import com.kunming.service.SCService;
import com.kunming.serviceImpl.SCServiceImpl;

@WebServlet("/SelectClassRoomServlet")
public class SelectClassRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String sid = request.getParameter("sid");
		int sno = Integer.parseInt(sid);
		String cid = request.getParameter("cid");
		int cno = Integer.parseInt(cid);
		SCService scService = new SCServiceImpl();
		SC sc = scService.getSCBySnoCno(sno, cno);
		request.setAttribute("sc", sc);
		request.getRequestDispatcher("stu/updateRoom.jsp").forward(request, response);
	}

}
