package com.software.dao;

import com.software.entity.Course;
public interface CourseQueryDAO {
	
	//public List<courseInfo> getAll();
	
	//public List<courseInfo> getAllcourse(Long teacherId);
	
	public Course get(String coursename);
	
	//public void insert(courseInfo courseSchedule);
	
	//public void update(courseInfo courseSchedule);
	
	//public void delete(String studentId);

	/**
	 * 返回和studentId相等的记录数
	 * @param studentId
	 * @return
	 */
	//public long getCountWithName(String studentId);
	
	/**
	 * 返回和studentId、yearTerm、week相等的记录
	 * @param studentId
	 * @param yearTerm
	 * @param week
	 * @return
	 */
	//public List<CourseSchedule> getAllWithYearTerm(String studentId, String yearTerm, String week);
	
	
	
}
