<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<meta charset="UTF-8">
<title>学生选课信息管理系统-信息查询</title>
<link href="style_1.css" type="text/css" rel="stylesheet" />
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
		<div class="title">
			<p>学生选课信息管理系统</p>
		</div>
	</div>
	<div class="main">
		<div class="main_left">
			<div class="main_left_class00">
				<img src="img/long.jpg">
			</div>
			<div class="main_left_class01">
				<a href="SelectAllCourseServlet">选课管理</a>
			</div>
			<div class="main_left_class02">
				<a href="SelectAllStudentServlet">学生信息</a>
			</div>
			<div class="main_left_class03">
				<a href="SelectAllSCServlet01">信息查询</a>
			</div>
			<div class="main_left_class100">
				<input class="reset" type="button" value="注销"
					onClick="window.location.href=('CancellationServlet')">
			</div>
		</div>
		<div class="main_right">
			<div class="info">
				<p>亲爱的${teacher.tname }老师，下午好</p>
			</div>
			<div class="box">
				<div class="function">
					<p>[通知]选课系统已开放</p>
				</div>
				<div class="form">
					<div class="form_1">
						<form action=QueryByServlet method="post">
							<table class="form_1_table">
								<tr>
									<td><input class="text" type="text" name="queryKey"
										placeholder="请输入查询项" /></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td><select name="type">
											<option value="1">学号</option>
											<option value="2">姓名</option>
											<option value="3">班级</option>
											<option value="4">课程名</option>
											<option value="5">课程号</option>
											<option value="6">上课教室</option>
									</select></td>
									<td><input class="btn" type="submit" value="查询" /></td>
								</tr>
							</table>
						</form>
						<table border="1px">
						<tr>
							<td>学号</td>
							<td>姓名</td>
							<td>班级</td>
							<td>课程名</td>
							<td>课程号</td>
							<td>上课教室</td>
							<td>修改教室</td>
						</tr>
						<c:forEach items="${list }" var="list">
							<tr>
							
								<td>${list.student.sno }</td>
								<td>${list.student.sname }</td>
								<td>${list.student.sclass }</td>
								<td>${list.course.cname }</td>
								<td>${list.course.cno}</td>
								<td>${list.classroom }</td>
								<td><input class="btn" type="button" value="修改教室"
									onclick="window.location.href=('SelectClassRoomServlet?sid=${list.student.sno }&cid=${list.course.cno }')" /></td>
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

