<%@ page language="java" import="java.util.* " pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
	<title>学生选课信息管理系统-学生信息</title>
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
				<table border="1px" cellpadding="0px" cellspacing="0px"  >
					<tr>
						<td>
							<input class="btn" type="button" value="添加学生" onclick="window.location.href=('stu/InsertStu.jsp')"/>
						</td>
						<td colspan="6"></td>
					</tr>
  					<tr>
  						<td>学生编号</td>
  						<td>学生名称</td>
  						<td>所在班级</td>
  						<td>学生密码</td>
  						<td>学生性别</td>
  						<td>学分数</td>
  						<td>
  							修改信息
  						</td>	
  						<td>
  							删除信息
  						</td>					
  					</tr>
					<c:forEach var="list" items="${list}">
  					<tr>
	  					<td>${list.sno}</td>
	  					<td>${list.getStudent().sname}</td>
	  					<td>${list.getStudent().sclass}</td>
	  					<td>${list.getStudent().spassword}</td>
	  					<td>${list.getStudent().ssex}</td>
	  					<td>${list.getCourse().ccredit}</td>
	  					<td><input class="btn" type="button" value="修改信息" onClick="window.location.href=('SelectSCByIdServlet?sno=${list.sno}')"></td>
	  					<td><input class="btn" type="button" value="删除信息" onClick="if(confirm('确定要删除吗？'))window.location.href=('DeleteStudentServlet?sno=${list.sno}')"></td>
  					</tr>
  					</c:forEach>
  				</table>
  			<div class="form_1">
  				<form action="tea/selectStu.jsp" method="post">
				<table>
				<tr><td>最低修读学分</td><td><input class="text" type="text" name="sumary" value="7.0"/></td><td></td>
				</tr>
				<tr><td>最高修读学分</td><td><input class="text" type="text" name="maxscore" value="10.0"/></td><td></td>
				</tr>
				</table>
				</form>
				
				
				<table>
				<tr><th></th></tr>
  			
  					
				</table>
				</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
