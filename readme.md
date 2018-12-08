# 学生信息管理平台开发说明
## 介绍

## 小组分工

6人

- 后台
    - 数据库操作部分
        - entity层
        - DAO层
        - implement层
        - jdbcutil工具类
    - 与前端的操作部分
        - servlet层
        - filter层
    - 单元测试
- 前端
    - 全局页面
        - 登录页面
        - 找回密码页面
        - 修改密码页面
    - 学生页面
    - 教师页面
    - 教务员页面
    - 管理员页面


## 如何运行该项目
第一次运行项目：

如果使用IDEA：
1. 使用IDEA导入该工程
2. 使用IDEA定位到红色的报错位置，Alt+Enter导入所需要的包（javax和Junit）
3. 运行test包下的FirstTest文件，测试能否运行java程序和能否连接数据库
4. 配置Tomcat(这里使用的是8.5)，在deployment中设置WebContent目录映射路径为/，配置默认访问目录为WebContent
5. 然后访问http://localhost:8080/

如果使用Eclipse：
1. 文件都报错：导入工程后，加载javax.servlet和junit包
2. 文件名的小红叉都消失了，但项目图标上还有小红叉：
由于他人工程中的org.eclipse.wst.common.project.facet.core.xml文件中存在一个<runtime>标签，里面进行了相关定义和声明导致的。
，其中定义了Tomcat的版本，将其改为自己Tomcat服务器的版本就可以了。
<runtime name="Apache Tomcat v8.5"/>
3. 更改数据库地址以及用户名和密码，在c3p0-config.xml文件中
4. 运行Tomcat后。访问http://localhost:8080/javaweb_project/login/login.jsp

## 项目结构
数据库操作：

三个底层文件：
	c3p0-config.xml
	JDBCUtils.java
	DAO.java

数据库连接：
	c3p0连接池
	
	JDBC2.0 提供了javax.sql.DataSource接口，它负责建立与数据库的连接，当在应用程序中访问数据库时 
	不必编写连接数据库的代码，直接引用DataSource获取数据库的连接对象即可。用于获取操作数据Connection对象。


CURD（增删改查）：

	使用简化JDBC操作的组件——DBUtils

		DbUtils类(org.apache.commons.dbutils.DbUtils)主要负责装载驱动、关闭连接的常规工作。
		QreryRunner类(org.apache.commons.dbutils.QueryRunner) 显著的简化了SQL查询，并与ResultSetHandler协同工作将使编码量大为减少。
			update(Connection conn, String sql, Object... params)	插入，删除，更新
           	query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params)	查询
			
		ResultSetHandler接口(org.apache.commons.dbutils.ResultSethandler)执行处理一个结果集对象，将数据转变并处理为任何一种形式，供其他应用使用。
			BeanHandler: 把结果集转为一个 Bean,并返回
			BeanListHandler: 把结果集转为一个 Bean 的 List, 并返回
			ScalarHandler: 可以返回指定列的一个值或返回一个统计函数的值，比如count(1)。
			

implement实现层：
所有实现类继承DAO类，以调用DAO类封装的CURD接口，并在初始化的过程中，将class对象赋值个DAO.clazz

构造对以下14张表的实体类，DAO类，实现类：

	cetgrade, 
	course, 
	courseschedule, 
	examarrange, 
	exemptionapply, 
	jwteacherinformation, 
	levelexam, 
	levelexamlist, 
	optionalcourse, 
	postponeexamapply, 
	studentbasicinformation, 
	studentgrade, 
	studentoptcourse, 
	teacherinformation, 
	users


web.xml
	welcome-file-list是一个配置在web.xml中的一个欢迎页，
	用于当用户在url中输入工程名称或者输入web容器url（如http://localhost:8080/）时直接跳转的页面.

Servlet层和Filter层：
先经过Filter再调用Servlet

Filter过滤器：

在不使用web.xml来配置Filter，而使用@WebFilter注解来配置Filter时，可以通过控制filter的文件名来控制filer的执行顺序

9种过滤：
0. HTTPFilter										继承Filter，自定义抽象过滤类，以下都继承该抽象类

1. AcdemicDeanJspFilter		/acdemic_dean/*			访问教务员用户下的所有页面的过滤器，当session中的user丢失，即需要重新登录
2. StudentFilter			/student/*				访问学生用户下的所有页面的过滤器，当session中的user丢失，即需要重新登录
3. TeacherFilter			/teacher/*				访问教师用户下的所有页面的过滤器，当session中的user丢失，即需要重新登录
4. AdministratorJspFilter	/administrator/*		访问管理员用户下的所有页面的过滤器，当session中的user丢失，即需要重新登录
	
5. LoginCheckCodeFilter		/loginChangeServlet		登录时检验 验证码是否一致
6. LoginFilter				/loginChangeServlet		登录时验证用户名和密码是否输入正确

7. EncodingFilter			/*						针对所有请求，字符编号过滤器，选用utf-8，
8. FindMMCheckCodeFilter	/findPasswordServlet	找回密码时判断验证码正不正确
9. ModifyPasswordFilter		/modifyPasswordServlet	修改密码时检验：1.检验旧密码是否正确， 2.检验新密码与确认密码是否一致


servlet层：
20个类

功能分别为：

1. loginChangeServlet			/loginChangeServlet		登录转发，根据不同用户角色，返回不同的用户界面student.jsp/teacher.jsp/acdemic_dean.jsp/administrator.jsp
2. FindPasswordServlet			/findPasswordServlet	找回密码，返回密码
3. ValidateColorServlet			/validateColorServlet	生成验证码

4. LogoutServlet				/logoutServlet			退出登录，返回登录页面login.jsp
5. ModifyPasswordServlet		/modifyPasswordServlet	修改密码，返回成功信息

student页面：

6. studentInformationServlet	/studentInformationServlet	查看学籍信息，返回studentinformation.jsp

7. LevelExamServlet				*。apply					考级信息查询与考级报名		
8. OptionalCourseServlet		*.optional				课程信息查询与报名

9. ExamArrangeServlet			/examArrangeServlet		查看考试安排
10. CourseScheduleServlet		/courseScheduleServlet	查看课程表
11. PostponeExamapplyServlet	/PostponeExamapplyServlet	缓考申请
12. ExemptionApplyServlet		/ExemptionApplyServlet		免修申请

13. CoursegradeServlet			*.grade(studentquery.grade)	学生查询自己的成绩，返回查询coursegrade.jsp
14. LevelExaminationGradeServlet	studentquery.query		学生自己查询自己的考级成绩，返回levelExaminationGrade.jsp


acdemic_dean页面：

15. studentInformationServlet							教务员录入学生信息为update,不是insert


teacher页面：


    录入学生成绩bug：
    
    
    毫无头绪，单单课程信息查不出来
    只有插入，没有更新，且插入已经存在的成绩也能成功










