package com.kunming.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.kunming.bean.Course;
import com.kunming.dao.CourseDao;
import com.kunming.jdbc.JdbcUtils;

public class CourseDaoImpl implements CourseDao {
	private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	@Override
	public List<Course> getAllCourse() {
		String sql = "select * from course";
		
		try {
			return qr.query(sql, new BeanListHandler<>(Course.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return null;
	}
	@Override
	public int insertCourse(Course course) {
		String sql = "insert into course(cname,ccredit) values(?,?)";
		
		try {
		return qr.update(sql,course.getCname(),course.getCcredit());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public Course getByidCourse(int cno) {
		String sql = "select * from course where cno=?";
		
		try {
			return qr.query(sql, new BeanHandler<>(Course.class),cno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int updateCourse(Course course) {
		String sql = "update course set cname=?,ccredit=? where cno=?";
		try {
			return qr.update(sql,course.getCname(),course.getCcredit(),course.getCno());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int deleteCourse(int cno) {
		String sql = "delete from course where cno=?";
		try {
		 return qr.update(sql,cno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
