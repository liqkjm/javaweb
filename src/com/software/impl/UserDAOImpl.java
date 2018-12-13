package com.software.impl;

import java.util.List;

import com.software.dao.DAO;
import com.software.dao.UserDAO;
import com.software.entity.CriterUser;
import com.software.entity.User;

public class UserDAOImpl extends DAO<User> implements UserDAO {
	
	@Override
	public List<User> getAll() {
		
		String sql = "SELECT * FROM users;";
		return getForList(sql);
	}

	@Override
	public User get(String username) {
		String sql = "select *from users where username = ?";
		return get(sql, username);
	}

	@Override
	public void insert(User user) {
		String sql = "insert into users values(?,?,?,?,?,?,?)";
		update(sql , user.getUsername(), user.getPassword(), user.getName(), 
				user.getIdentity(), user.getFindMMproof(),user.getLogin_last_time(), 
				user.getPassword_last_changed());

	}

	@Override
	public void update(User user) {
		String sql = "update users set password = ?,name = ?, identity = ?, " +
				"findMMproof = ?, login_last_time = ?, password_last_changed = ? where username = ?";
		update(sql, user.getPassword(),user.getName(), user.getIdentity(), user.getFindMMproof(), 
				user.getLogin_last_time(), user.getPassword_last_changed(), user.getUsername());

	}

	@Override
	public void delete(String username) {
		String sql = "delete from users where username = ?";
		update(sql, username);
	}

	@Override
	public long getCountWithName(String username) {
		String sql = "select count(*) from users where username = ?";
		return getForValue(sql,username);
	}

	@Override
	public List<User> getForListWithCriterCustomer(CriterUser user) {
		String sql = "select * from users " +
				"where username like ? and name like ? and identity like ?";
		
		return getForList(sql, user.getUsername(), user.getName(), user.getIdentity());
	}


}
