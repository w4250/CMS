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
	<title>学生选课信息管理系统-正在选课</title>
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
	<div class="title"><p> 学生选课信息管理系统 </p></div>
</div>
<div class="main">
	<div class="main_left">
		<div class="main_left_class00"><img src="img/long.jpg"></div>
		<div class="main_left_class01"><a href="SelectStuCourseServlet">学生选课</a></div>
		<div class="main_left_class02"><a href="SelectStuSCCourseServlet?sno=${student.sno}">课程查询</a></div>
		<div class="main_left_class03"><a href="SelectStuInfoServlet?sno=${student.sno }">学籍信息</a></div>
		<div class="main_left_class100">
		<input class="reset" type="button" value="注销" onClick="window.location.href=('CancellationServlet')">
		</div>
	</div>
		
	<div class="main_right">
		<div class="info">
			<p>亲爱的同学，下午好</p>
		</div>
		<div class="box">
			<div class="function"><p>[通知]选课系统已开放</p></div>
			<div class="form">
			
				<table>
  					<tr><td></td></tr>
  					<tr>
  						<td>课程编号</td><td>课程名称</td><td>课程学分</td><td>选课</td>
  						
  					</tr>
  					
  					<form action="InsertStuSCCourseServlet" method="post">
  					<c:forEach items="${list }" var="list">
  					<tr>
  					<td>${list.cno }</td>
  					<td>${list.cname }</td>
  					<td>${list.ccredit }</td>
  					<td><input type="checkbox" name="choiceCou" value="${list.cno }" /> </td>
  					</tr>
  					</c:forEach>
     			<tr><td></td></tr><tr><td></td><td></td>
  					<td><input class="sure" type="submit" value="确定"></td>
					<td><input class="cancle" type="reset" value="取消"></td>
  				</table>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>
