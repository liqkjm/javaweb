package com.software.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录转发
 * 获取登录用户的信息，并判断登录用户的身份
 * 根据用户的身份转到对应的用户页面
 * @author liqkjm
 *
 */
@WebServlet("/loginChangeServlet")
public class LoginChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect(request.getContextPath() + "/student/student.jsp");
		
	}
}
