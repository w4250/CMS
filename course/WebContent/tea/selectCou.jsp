<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
	<title>学生选课信息管理系统-课程信息</title>
	<link href="style_1.css" type="text/css" rel="stylesheet"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <body>
<div class="top">
	<div class="title"><p> 学生选课信息管理系统</p></div>
</div>
<div class="main">
	<div class="main_left">
		<div class="main_left_class00"><img src="img/long.jpg"></div>
			<div class="main_left_class01"><a href="SelectAllCourseServlet">选课管理</a></div>
			<div class="main_left_class02"><a href="SelectAllStudentServlet">学生信息</a></div>
			<div class="main_left_class03"><a href="SelectAllSCServlet01">信息查询</a></div>
			<div class="main_left_class100">
		<input class="reset" type="button" value="注销" onClick="window.location.href=('CancellationServlet')">
		</div>
	</div>
	<div class="main_right">
		<div class="info">
			<p>亲爱的老师，下午好</p>
		</div>
		<div class="box">
			<div class="function"><p>[通知]选课系统已开放</p></div>
			<div class="form">
				<table border="1px" cellpadding="0px" cellspacing="0px">
  					<tr>
  						<td>
  							<input class="btn" type="button" value="添加课程" onclick="window.location.href=('tea/InsertCou.jsp')"/>
  						</td>
  						<td colspan="4"></td>
  					</tr>
  					<tr>
  						<td>课程编号</td>
  						<td>课程名称</td>
  						<td>课程学分</td>
  						<td>修改课程</td>
  						<td>删除课程</td>
  						
  					</tr>
			  		<c:forEach var="list" items="${list }">
			  		<tr>
	  					<td>${list.cno }</td>
	  					<td>${list.cname }</td>
	  					<td>${list.ccredit }</td>
	  					<td><input  class="btn" type="button" value="修改课程" onClick="window.location.href=('SelectByIdCourseServlet?cno=${list.cno}')"></td>
	  					<td><input id="btn"  class="btn" type="button" value="删除课程" onclick="if(confirm('确定要删除吗？'))window.location.href=('DeleteCourseServlet?cno=${list.cno}')"></td>
  					</tr>
  					</c:forEach>
  					
  					<tr>
  				</table>
				
			</div>
		</div>
	</div>
</body>
</html>
