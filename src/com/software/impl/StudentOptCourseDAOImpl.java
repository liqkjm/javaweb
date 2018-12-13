package com.software.impl;

import java.util.List;

import com.software.dao.DAO;
import com.software.dao.StudentOptCourseDAO;
import com.software.entity.StudentOptCourse;

public class StudentOptCourseDAOImpl extends DAO<StudentOptCourse> implements StudentOptCourseDAO {

	@Override
	public List<StudentOptCourse> getAll() {
		String sql = "SELECT * FROM studentoptcourse;";
		return getForList(sql);
	}

	@Override
	public StudentOptCourse get(String studentId) {
		String sql = "select *from studentoptcourse where studentId = ?";
		return get(sql, studentId);
	}

	@Override
	public void insert(StudentOptCourse studentOptCourse) {
		String sql = "insert into studentoptcourse values(?,?)";
		update(sql , studentOptCourse.getStudentId(),studentOptCourse.getCourseId());

	}

	@Override
	public void update(StudentOptCourse studentOptCourse) {
		String sql = "update studentoptcourse set CourseId = ? where studentId = ?";
		update(sql, studentOptCourse.getCourseId(), studentOptCourse.getStudentId() );

	}

	@Override
	public void delete(String studentId) {
		String sql = "delete from studentoptcourse where studentId = ?";
		update(sql, studentId);
	}

	@Override
	public long getCountWithName(String studentId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public StudentOptCourse get(StudentOptCourse studentOptCourse) {
		String sql = "select *from studentoptcourse where studentId = ? and courseId = ?";
		return get(sql, studentOptCourse.getStudentId(), studentOptCourse.getCourseId());
	}

	@Override
	public List<StudentOptCourse> getAll(String studentId) {
		String sql = "SELECT * FROM studentoptcourse where studentId = ?;";
		return getForList(sql, studentId);
	}


}
