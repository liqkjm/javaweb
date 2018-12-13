package com.software.impl;

import java.util.List;

import com.software.dao.DAO;
import com.software.dao.OptionalCourseDAO;
import com.software.entity.OptionalCourse;

public class OptionalCourseDAOImpl extends DAO<OptionalCourse> implements OptionalCourseDAO {

	@Override
	public List<OptionalCourse> getAll() {
		String sql = "SELECT * FROM optionalcourse;";
		return getForList(sql);
	}

	@Override
	public OptionalCourse get(String courseId) {
		String sql = "select *from optionalcourse where courseId = ?";
		return get(sql, courseId);
	}

	@Override
	public void insert(OptionalCourse optionalCourse) {
		String sql = "insert into optionalcourse values(?,?,?,?,?,?,?,?)";
		update(sql , optionalCourse.getYearTerm(), optionalCourse.getCourseId(), optionalCourse.getCourseName(), 
				optionalCourse.getCredit(), optionalCourse.getCourseType(),optionalCourse.getTeacher(), 
				optionalCourse.getClassWay(), optionalCourse.getClassTime());

	}

	@Override
	public void update(OptionalCourse optionalCourse) {
		String sql = "update optionalcourse set YearTerm = ?,CourseName = ?, Credit = ?, " +
				"CourseType = ?, Teacher = ?, ClassWay = ?, ClassTime = ? where courseId = ?";
		update(sql, optionalCourse.getYearTerm(), optionalCourse.getCourseName(), 
				optionalCourse.getCredit(), optionalCourse.getCourseType(),optionalCourse.getTeacher(), 
				optionalCourse.getClassWay(), optionalCourse.getClassTime(), optionalCourse.getCourseId());

	}

	@Override
	public void delete(String courseId) {
		String sql = "delete from optionalcourse where courseId = ?";
		update(sql, courseId);
	}

	@Override
	public long getCountWithName(String courseId) {
		
		return 0;
	}

	@Override
	public List<OptionalCourse> getAllWithYearTerm(String yearTerm) {
		String sql = "SELECT * FROM optionalcourse where yearTerm = ?;";
		return getForList(sql, yearTerm);
	}

	@Override
	public OptionalCourse get(String courseId, String yearTerm) {
		String sql = "select *from optionalcourse where courseId = ? and yearTerm = ?";
		return get(sql, courseId, yearTerm);
	}

}
