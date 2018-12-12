<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息查询</title>
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
		<h3>信息查询</h3>
		<a href="<%=request.getContextPath()%>/studentInformationServlet">学籍信息</a>
	</div>
</body>
</html>