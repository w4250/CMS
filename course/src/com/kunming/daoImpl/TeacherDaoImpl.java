package com.kunming.daoImpl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.kunming.bean.Teacher;
import com.kunming.dao.TeacherDao;
import com.kunming.jdbc.JdbcUtils;

public class TeacherDaoImpl implements TeacherDao {
	private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());

	@Override
	public Teacher getTeacher(Teacher teacher) {
		String sql="select * from teacher where tname=? and tpassword=?";
		try {
			return qr.query(sql, new BeanHandler<>(Teacher.class),teacher.getTname(),teacher.getTpassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;			
	}
	public static void main(String[] args) {
		TeacherDaoImpl t = new TeacherDaoImpl();
		Teacher teacher = new Teacher();
		teacher.setTname("admin");
		teacher.setTpassword("admin");
		Teacher t1 = t.getTeacher(teacher);
		System.out.println(t1);
	}
	
}
