package com.software.impl;

public class CourseQueryDAOImpl extends DAO<Course> implements CourseQueryDAO {

	@Override
	public Course get(String coursename) {
		// TODO Auto-generated method stub
		String sql = "select *from course where coursename = ?";
		return get(sql, coursename);
		// return null;
	}

	/*@Override
	public User get(String username) {
		String sql = "select *from users where username = ?";
		return get(sql, username);
	}*/
}
