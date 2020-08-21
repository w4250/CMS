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
	<title>学生选课信息管理系统-显示学生个人信息</title>
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
		<div class="main_left_class02"><a href="SelectStuSCCourseServlet">课程查询</a></div>
		<div class="main_left_class03"><a href="SelectStuInfoServlet?sno=${student.sno }">学籍信息</a></div>
		<div class="main_left_class100">
		<input class="reset" type="button" value="注销" onClick="window.location.href=('CancellationServlet')">
		</div>
	</div>
	<div class="main_right">
		<div class="info">
			<p>亲爱的${student.sname }同学，下午好</p>
		</div>
		<div class="box">
			<div class="function"><p>[通知]选课系统已开放</p></div>
			<div class="form">
			<div class="form_1">
				<table class="info">
					<c:forEach items="${list }" var="list">
  					<tr><td></td></tr>
  					<tr><td></td><td><input class="text" type="text" value="姓名：${list.student.sname }" readonly="true"></td><td></td><td></td><td></td><td rowspan="2"><img src="/Ten/img/touxiang.png"/></td></tr>
  					<tr><td></td><td><input class="text" type="text" value="学号：${list.student.sname }" readonly="true"></input></td></tr>
  						<tr><td></td><td><input class="text" type="text" value="密码：${list.student.spassword }" readonly="true"></td></tr>
  						<tr><td></td><td><input class="text" type="text" value="性别:${list.student.ssex }" readonly="true"></td></tr>
  						<tr><td></td><td><input class="text" type="text" value="班级：${list.student.sclass }" readonly="true"></td></tr>
  						<tr><td></td><td><input class="text" type="text" value="总学分：${list.course.ccredit }" readonly="true"></td>
  					</tr>
  					</c:forEach>
  				</table>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>