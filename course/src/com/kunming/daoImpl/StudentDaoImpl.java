package com.kunming.daoImpl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.kunming.bean.Student;
import com.kunming.dao.StudentDao;
import com.kunming.jdbc.JdbcUtils;

public class StudentDaoImpl implements StudentDao {
	private QueryRunner qr = new QueryRunner (JdbcUtils.getDataSource());

	@Override
	public int insertStudent(Student student) {
		String sql="insert into student(sname,spassword,sclass,ssex) values(?,?,?,?)";
		try {
		 return	qr.update(sql,student.getSname(),student.getSpassword(),student.getSclass(),student.getSsex());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteStudent(int sno) {
		String sql="delete from student where sno=?";
		try {
			return qr.update(sql,sno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateStudent(Student student) {
		String sql="update student set sname=?,spassword=?,sclass=?,ssex=? where sno=?";
		try {
			return qr.update(sql,student.getSname(),student.getSpassword(),student.getSclass(),student.getSsex(),student.getSno());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
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

	
}
