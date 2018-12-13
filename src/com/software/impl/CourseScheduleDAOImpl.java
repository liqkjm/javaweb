package com.software.impl;

import java.util.List;

import com.software.dao.CourseScheduleDAO;
import com.software.dao.DAO;
import com.software.entity.CourseSchedule;

public class CourseScheduleDAOImpl extends DAO<CourseSchedule> implements CourseScheduleDAO {

	@Override
	public List<CourseSchedule> getAll() {
		String sql = "SELECT * FROM courseschedule;";
		return getForList(sql);
	}

	@Override
	public CourseSchedule get(String studentId) {
		String sql = "select * from courseschedule where studentId = ?";
		return get(sql, studentId);
	}

	@Override
	public void insert(CourseSchedule courseSchedule) {
		String sql = "insert into courseschedule values(?,?,?,?,?,?,?)";
		update(sql , courseSchedule.getStudentId(), courseSchedule.getWeek(), courseSchedule.getWeekday(), 
				courseSchedule.getJoint(), courseSchedule.getCourse(),courseSchedule.getTeacher(), 
				courseSchedule.getClassplace());

	}

	@Override
	public void update(CourseSchedule courseSchedule) {
		String sql = "update courseschedule set Week = ?,Weekday = ?, Joint = ?, " +
				"Course = ?, Teacher = ?, Classplace = ? where studentId = ?";
		update(sql, courseSchedule.getWeek(), courseSchedule.getWeekday(), 
				courseSchedule.getJoint(), courseSchedule.getCourse(),courseSchedule.getTeacher(), 
				courseSchedule.getClassplace(), courseSchedule.getStudentId());

	}

	@Override
	public void delete(String studentId) {
		String sql = "delete from courseschedule where studentId = ?";
		update(sql, studentId);
	}

	@Override
	public long getCountWithName(String studentId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CourseSchedule> getAllWithYearTerm(String studentId,
			String yearTerm, String week) {
		String sql = "SELECT * FROM courseschedule where studentId = ? and yearTerm = ? and week = ?;";
		return getForList(sql, studentId, yearTerm, week);
	}

	public List<CourseSchedule> getAllcourse(Long teacherId){
		String sql = "SELECT courseschedule.studentId,teacher,course,classplace,week,weekday,joint FROM courseschedule,teacherinformation where teacherinformation.teacherId = ? and courseschedule.teacher=teacherinformation.teacherName ;";
		return getForList(sql, teacherId);
	}
	
}
