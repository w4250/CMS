<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
	<title>学生选课信息管理系统-修改学生信息</title>
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
			<p>亲爱的${teacher.tname }老师，下午好</p>
		</div>
		<div class="box">
			<div class="function"><p>[通知]选课系统已开放</p></div>
			<div class="form">
			<div class="form_1">
				<form action="UpdateStudentServlet" method="post">
				<table>
					<c:forEach items="${list}" var="stu">
  					<tr><td></td></tr>
  					<tr><td>学生学号</td> <td><input  class="text" type="text" name="SNo" value="${stu.student.sno}" readonly="true"/></td></tr>
  					<tr><td>学生姓名</td> <td><input  class="text" type="text" name="Sname" value="${stu.student.sname}"/></td></tr>
  					<tr><td>学生密码</td> <td><input  class="text" type="text" name="Spassword" value="${stu.student.spassword }"/></td></tr>
  					<tr><td>学生班级</td> <td><input  class="text" type="text" name="Sclass" value="${stu.student.sclass}"/></td></tr>
  					<tr><td>学生性别</td> <td><input  class="text" type="text" name="Ssex" value="${stu.student.ssex}"/></td></tr>
  					<tr><td></td><td><input class="btn" type="submit" value="确认修改"/> 
  					<input class="btn" type="reset" value="取消修改"/>  </td></tr>
 </c:forEach>
			  		
  					
  				</table>
  				</form>
  				
  				</div>
  				</div>
				
			</div>
		</div>
	</div>
</body>
</html>
