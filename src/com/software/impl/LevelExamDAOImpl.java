package com.software.impl;

import java.util.List;

import com.software.dao.DAO;
import com.software.dao.LevelExamDAO;
import com.software.entity.LevelExam;

public class LevelExamDAOImpl extends DAO<LevelExam> implements LevelExamDAO {

	@Override
	public List<LevelExam> getAll() {
		String sql = "SELECT * FROM levelexam;";
		return getForList(sql);
	}

	@Override
	public LevelExam get(String courseId) {
		String sql = "select *from levelexam where courseId = ?";
		return get(sql, courseId);
	}

	@Override
	public void insert(LevelExam levelExam) {
		String sql = "insert into levelexam values(?,?,?,?,?,?)";
		update(sql , levelExam.getYearTerm(), levelExam.getCourseId(), levelExam.getCourseName(), 
				levelExam.getApplyTime(), levelExam.getExamTime(),levelExam.getExamCost());

	}

	@Override
	public void update(LevelExam levelExam) {
		String sql = "update levelexam set YearTerm = ?,CourseName = ?, ApplyTime = ?, " +
				"ExamTime = ?, ExamCost = ? where courseId = ?";
		update(sql, levelExam.getYearTerm(), levelExam.getCourseName(), levelExam.getApplyTime(), 
				levelExam.getExamTime(),levelExam.getExamCost(), levelExam.getCourseId() );

	}

	@Override
	public void delete(String courseId) {
		String sql = "delete from levelexam where courseId = ?";
		update(sql, courseId);
	}

	@Override
	public long getCountWithName(String courseId) {
		
		return 0;
	}

	@Override
	public List<LevelExam> getAllWithYearTerm(String yearTerm) {
		String sql = "SELECT * FROM levelexam where yearTerm = ?;";
		return getForList(sql, yearTerm);
	}

	@Override
	public LevelExam get(String courseId, String yearTerm) {
		String sql = "select *from levelexam where courseId = ? and yearTerm = ?";
		return get(sql, courseId, yearTerm);
	}

}
