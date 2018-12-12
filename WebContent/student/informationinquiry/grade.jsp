<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成绩查询</title>
</head>
<body style="background:url(../informationinquiry/back2.jpg)">
<h2>欢迎，${sessionScope.user.name }</h2>
	<div>
		<a href="<%=request.getContextPath()%>/modify/modifypassword.jsp">修改密码</a>
		<a href="<%=request.getContextPath()%>/logoutServlet">注销</a>
		<br><br>
		<a href="<%=request.getContextPath() %>/student/student.jsp">返回上一步</a>
	</div>
	<div>
		<h3>成绩查询</h3>
		<a href="<%=request.getContextPath()%>/studentQuery.grade">课程成绩</a>
		<br><br>
		<a href="<%=request.getContextPath()%>/studentquery.query">考级成绩</a>
		<br><br>
		
	</div>
</body>
</html>