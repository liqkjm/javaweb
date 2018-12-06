package com.software.test;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.jupiter.api.Test;

import com.software.entity.User;
import com.software.jdbcutil.JDBCUtils;


class FirstTest {

	@Test
	void test() {
		// fail("Not yet implemented");

		String sql1 = "select * from users where username = ?";
		
		String username = "4225111212";
		
		QueryRunner queryRunner = new QueryRunner();
		java.sql.Connection conn = null;
		
		try {
			conn = JDBCUtils.getConnection();

			User user = queryRunner.query(conn, sql1, new BeanHandler<User>(User.class), username);
			System.out.println(user.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeConnection(conn);
		}
		
	}

}
