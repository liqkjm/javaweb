package com.software.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.dao.CourseScheduleDAO;
import com.software.entity.CourseSchedule;
import com.software.entity.User;
import com.software.impl.CourseScheduleDAOImpl;


@WebServlet("*.Course")
public class CourseinformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//1.获取ServletPath：/addUser.do
		String servletPath = request.getServletPath();
		//2.去除 / 和 .do ，得到类似于addUser这样的字符串
		String methodName = servletPath.substring(1, servletPath.length() - 7);
				
		try {
			//3.利用反射获取methodName对应的方法
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			//4.利用反射调用对应的方法
			method.invoke(this, request, response);
		} catch (Exception e) {	
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	private void teacherQuery(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		
		List<CourseSchedule> CourseSchedules = getAllcourseList(user);
		
		session.setAttribute("CourseSchedules", CourseSchedules);
		System.out.println(CourseSchedules.toString());
		
		response.sendRedirect(request.getContextPath() + "/teacher/inquirynews/courseinformation.jsp");
	}
	
	private List<CourseSchedule> getAllcourseList(User user) {
	CourseScheduleDAO csd=new CourseScheduleDAOImpl();
	return csd.getAllcourse(Long.parseLong(user.getUsername()));
	}
}
