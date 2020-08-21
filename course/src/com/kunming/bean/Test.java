package com.kunming.bean;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.kunming.daoImpl.StudentDaoImpl;
import com.kunming.jdbc.JdbcUtils;

public class Test {
	private QueryRunner qr = new QueryRunner (JdbcUtils.getDataSource());

	public Student getStuBySnoPassWord(Student s) {
		String sql="select * from student where sno=? and spassword=?";
		try {
		return qr.query(sql, new BeanHandler<>(Student.class),s.getSno(),s.getSpassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
	/*	TeacherDaoImpl t = new TeacherDaoImpl();
		Teacher teacher = new Teacher();
		teacher.setTname("admin");
		teacher.setTpassword("admin");
		Teacher t1 = t.getTeacher(teacher);
		System.out.println(t1);*/
		StudentDaoImpl t = new StudentDaoImpl();
		Student student = new Student();
		student.setSno(Integer.parseInt("1514010929"));
		student.setSpassword("15432");
		Student student2 = t.getStuBySnoPassWord(student);
		System.out.println(student2);
		
	}
}
