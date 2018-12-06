<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教务管理系统</title>
</head>
<body style="background:url(../img/back2.jpg) no-repeat;">
	<!-- 学生的主页面 -->
	<h2><font color="purple">欢迎，${sessionScope.user.name }</font></h2>

	<table   border=1 style=border-collapse:collapse; width="400" >
     <tr >
         <th><a href="<%=request.getContextPath()%>/student/informationinquiry/informationinquiry.jsp">个人信息</a></th>
     </tr>
     <tr>
         <th><a href="<%=request.getContextPath()%>/student/courseselect/select.jsp">选课服务</a></th>
     </tr>
     <tr>    
         <th><a href="<%=request.getContextPath()%>/student/informationinquiry/courseinformation.jsp">课程运行</a></th>
      </tr>  
      <tr> 
         <th><a href="<%=request.getContextPath()%>/student/informationinquiry/grade.jsp">成绩查询</a></th>
      </tr>
</table>
	<div>
		<%session.setAttribute("path", request.getRequestURI()); %>
		<a href="<%=request.getContextPath()%>/modify/modifypassword.jsp">修改密码</a>
		<a href="<%=request.getContextPath()%>/logoutServlet">注销</a>
	</div>
	
<!--  
	<div>
		<h3>个人信息</h3>
		<a href="<%=request.getContextPath()%>/student/informationinquiry/informationinquiry.jsp">个人信息</a>
	</div>
	<div>
		<h3>选课服务</h3>
		<a href="<%=request.getContextPath()%>/student/courseselect/courseselect.jsp">选课服务</a>
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
	<div>
		<h3>学生成绩</h3>
		<a href="<%=request.getContextPath()%>/student/informationinquiry/coursegrade.jsp">学生成绩</a>
	</div>-->
	
</body>
</html>