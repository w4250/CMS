package com.kunming.dao;
import java.util.List;

import com.kunming.bean.Course;

public interface CourseDao {
	//查询所有的课程
	public List<Course> getAllCourse();
	//添加课程
	public int insertCourse(Course course);
	//按学号查询
	public Course getByidCourse(int cno);
	//修改课程
	public int updateCourse(Course course);
	//删除课程
	public int deleteCourse(int cno);
	
}
