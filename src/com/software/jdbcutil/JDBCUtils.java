package com.software.jdbcutil;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * JDBC操作的工具类
 * @author liqkjm
 *
 */
public class JDBCUtils {
	
	
	/** JDBC2.0 提供了javax.sql.DataSource接口，它负责建立与数据库的连接，当在应用程序中访问数据库时 
		不必编写连接数据库的代码，直接引用DataSource获取数据库的连接对象即可。用于获取操作数据Connection对象。
	 */
	private static DataSource dataSource = null;
	
	static{
		//数据源只能被创建一次
		/**
		 * 1. 基本思想：可以为数据库建立一个“缓冲池”。预先在缓冲池中放入一定数量的连接，当需要建立数据库连接时，
		 * 只需要从“缓冲池”中取出一个，使用完毕再放回去，避免了重复连接所消耗的时间与资源。
	　　	 * 2. 职责：数据库连接池负责分配，管理，和释放数据库链接，它允许应用程序重复使用一个现有的数据库链接，而不是新建立一个。
	　　        * 3. JDBC的数据库链接池使用javax.sql.DataSource 来表示，DataSource 只是一个接口，
		 * 该接口通常由服务器（Webblogic，Tomact）提供实现，也有一些开源组织提供实现：DBCP，C3P0。
		 */
		dataSource = new ComboPooledDataSource("hua.project"); // 加载“c3p0-config.xml”文件中定义的“hua.project”这个配置元素
	}
	
	/**
	 * 
	 * @return 数据源的一个Connection对象
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	/**
	 * 关闭Connection连接
	 * @param conn
	 */
	public static void closeConnection(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
