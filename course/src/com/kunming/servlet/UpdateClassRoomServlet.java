package com.kunming.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kunming.bean.SC;
import com.kunming.service.SCService;
import com.kunming.serviceImpl.SCServiceImpl;

/**
 * Servlet implementation class UpdateClassRoomServlet
 */
@WebServlet("/UpdateClassRoomServlet")
public class UpdateClassRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String classroom = request.getParameter("classroom");
		String snoStr = request.getParameter("sno");
		int sno = Integer.parseInt(snoStr);
		String cnoStr = request.getParameter("cno");
		int cno = Integer.parseInt(cnoStr);
		SC sc = new SC();
		sc.setClassroom(classroom);
		sc.setCno(cno);
		sc.setSno(sno);
		SCService scService = new SCServiceImpl();
		PrintWriter out = response.getWriter();
		int i= scService.updateSC(sc);
		if(i > 0) {

			out.print("<span style='color:red;font-size:15px;text-aglin:center;'>更改成功</span>");
			response.setHeader("refresh","3;url=SelectAllSCServlet01");
		}else {
			out.print("<span style='color:red;font-size:15px;text-aglin:center;'>更改失败，请重新删除</span>");
			response.setHeader("refresh","3;url=SelectAllSCServlet01");
		}
		
	}

}
