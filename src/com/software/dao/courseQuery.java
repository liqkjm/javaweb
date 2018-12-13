package com.software.dao;
import com.software.entity.Course;
public class courseQuery extends DAO<Course>{
	//private QueryRunner qr = new QueryRunner();
	
	//private Class<courseInfo> clazz;
	
	//@SuppressWarnings("unchecked")
	public courseQuery(){
		/*Type superClass = getClass().getGenericSuperclass();
		
		if(superClass instanceof ParameterizedType){
			ParameterizedType pt = (ParameterizedType)superClass;
			
			Type[] typeArgs = pt.getActualTypeArguments();
			if(typeArgs != null && typeArgs.length > 0){
				if(typeArgs[0] instanceof Class){
					clazz = (Class<courseInfo>)typeArgs[0];
				}
			}
		}*/
		//clazz=courseInfo.class;
	}
	
	public Course courseSelectByName(String coursename) {
		
		String sql = "select * from course where coursename = ?;";
		Course c = get(sql, coursename);
		System.out.println(c.toString());
		
		return get(sql, coursename);
		
		/*Connection conn = null;
		
		try {
			conn = JDBCUtils.getConnection();
			//double coursename=1.5;
			Statement statement = conn.createStatement();
			ResultSet set = statement.executeQuery("select * from course where coursename='"+coursename+"';");
			
			set.next();
			// FIXME Illegal operation on empty result set.º”∏ˆ∑÷∫≈ ‘ ‘
			courseInfo c=new courseInfo(set.getString(1),set.getString(2),set.getLong(3),set.getString(4),set.getString(5));
			return c;
			//qr.query(conn, "insert into course values('xx','xx',1,'1','1')" );
			//return qr.query(conn, sql,new BeanHandler<courseInfo>(clazz),args);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeConnection(conn);
		}*/
		
		//return null;	
	}
}
