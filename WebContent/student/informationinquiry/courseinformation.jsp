<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课程运行</title>
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
		<h3>课程运行</h3>
		<a href="<%=request.getContextPath()%>/student/informationinquiry/examarrange.jsp">考试安排</a>
		<br><br>
		<a href="<%=request.getContextPath()%>/student/informationinquiry/courseschedule.jsp">课表查询</a>
		<br><br>
		<a href="<%=request.getContextPath()%>/student/businessmanagement/postponeExamapply.jsp">缓考申请</a>
	    <br><br>
		<a href="<%=request.getContextPath()%>/student/businessmanagement/exemptionapply.jsp">免修申请</a>
	</div>
</body>
</html>