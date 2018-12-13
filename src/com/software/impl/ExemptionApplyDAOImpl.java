package com.software.impl;

import java.util.List;

import com.software.dao.DAO;
import com.software.dao.ExemptionApplyDAO;
import com.software.entity.ExemptionApply;

public class ExemptionApplyDAOImpl extends DAO<ExemptionApply> implements ExemptionApplyDAO {

	@Override
	public List<ExemptionApply> getAll() {
		String sql = "SELECT * FROM exemptionapply;";
		return getForList(sql);
	}

	@Override
	public ExemptionApply get(String studentId) {
		String sql = "select *from exemptionapply where studentId = ?";
		return get(sql, studentId);
	}

	@Override
	public void insert(ExemptionApply exemptionApply) {
		String sql = "insert into exemptionapply values(?,?,?,?)";
		update(sql , exemptionApply.getYearTerm(),exemptionApply.getStudentId(), 
				exemptionApply.getCourseName(), exemptionApply.getApplyReason());

	}

	@Override
	public void update(ExemptionApply exemptionApply) {
		
	}

	@Override
	public void delete(String studentId) {
		String sql = "delete from exemptionapply where studentId = ?";
		update(sql, studentId);
	}


}
