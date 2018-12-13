package com.software.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.dao.CourseQueryDAO;
import com.software.dao.StudentGradeDAO;
import com.software.entity.StudentGrade;
import com.software.entity.Course;
import com.software.impl.CourseQueryDAOImpl;
import com.software.impl.StudentGradeDAOIpml;

@WebServlet("/submitGradeServlet/*")
public class SubmitGradeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CourseQueryDAO courseQueryDAO = new CourseQueryDAOImpl();
	private StudentGradeDAO studentGradeDAO = new StudentGradeDAOIpml();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.获取requestUrI
		// String servletPath = request.getServletPath();
		// String contextPath = request.getContextPath();
		String requestUrI = request.getRequestURI();
		// 2.获取后面的insert/update
		String methodName = requestUrI.substring(36, requestUrI.length());
		// System.out.println(methodName);
		HttpSession session = request.getSession();
		Long studentid = Long.parseLong(request.getParameter("studentnumber"));
		String studentname = request.getParameter("studentname");
		String coursename = request.getParameter("coursename");
		Integer grade = Integer.parseInt(request.getParameter("grade"));

		/*FIXME course表查不出来，待修复*/
		// 根据课程名字查出对应的课程信息:课程Id，课程学分，课程类型，课程修习方式
		//courseInfo courseResult = courseQueryDAO.get(coursename);
		
		// 没有查找到课程，则说明没有这节课
		if(grade > 1000 || grade < 0) {
			session.setAttribute("message", "输入错误");
			
		} else{
			// 查询该课程的成绩是否存在，暂时默认该成绩不存在
			String courseid = "HFP1805";//courseResult.courseid;//课程ID
			Double credit = 4.0;//courseResult.credit;
			String studyway = "专业选修课";//courseResult.studyway;// 课程类别
			String classType = "选修";//courseResult.classtype;
			
			
			Double gradepoint = ((double) grade / 10) - 6.0;// 根据成绩计算
			gradepoint = (double) Math.round(gradepoint * 10) / 10;
			//Double  = grade / 100 * credit;
			// 固定
			String yearTerm = "2018春季";
			String examway = "正常考试";
			String gradeway = "百分制";
			String effectivity = "1";
			String remarks = "";
			
			StudentGrade studentGrade = new StudentGrade(yearTerm, studentid, studentname, courseid, coursename, grade, gradepoint,
					credit, classType, studyway, examway, gradeway, effectivity, remarks);	
			
			try {
				if(methodName.equals("insert")) {
					insert(studentGrade);
					session.setAttribute("message", "录入成功");
				} else {
					update(studentGrade);
					session.setAttribute("message", "修改成功");
				}
			} catch(Exception e) {
				e.printStackTrace();
				session.setAttribute("message", "修改失败");
			}
		}
		
		response.sendRedirect(request.getContextPath() + "/teacher/grademanagement/insertgrade.jsp");
	}

	private void insert(StudentGrade studentGrade) throws IOException {
		studentGradeDAO.insert(studentGrade);
	}

	private void update(StudentGrade studentGrade) throws IOException {
		
		// 保留原有信息，只更新成绩和绩点两个信息
		StudentGrade newStudentGrade = studentGradeDAO.get(studentGrade.getStudentId(),studentGrade.getCourseName());
		
		newStudentGrade.setGradePoint(studentGrade.getGradePoint());
		newStudentGrade.setScore(studentGrade.getScore());
		
		studentGradeDAO.updateByStudentIdAndCourseName(newStudentGrade);
	}
}
