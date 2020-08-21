package com.kunming.serviceImpl;

import java.util.List;

import com.kunming.bean.Course;
import com.kunming.dao.CourseDao;
import com.kunming.daoImpl.CourseDaoImpl;
import com.kunming.service.CourseService;

public class CourseServiceImpl implements CourseService {
	private CourseDao courseDao=new CourseDaoImpl();
	@Override
	public List<Course> getAllCourse() {
		// TODO Auto-generated method stub
		return courseDao.getAllCourse();
	}
	@Override
	public int insertCourse(Course course) {
		// TODO Auto-generated method stub
		return courseDao.insertCourse(course);
	}
	@Override
	public Course getByidCourse(int cno) {
		// TODO Auto-generated method stub
		return courseDao.getByidCourse(cno);
	}
	@Override
	public int updateCourse(Course course) {
		// TODO Auto-generated method stub
		return courseDao.updateCourse(course);
	}
	@Override
	public int deleteCourse(int cno) {
		// TODO Auto-generated method stub
		return courseDao.deleteCourse(cno);
	}
}
