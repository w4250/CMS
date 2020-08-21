package com.kunming.service;

import java.util.List;

import com.kunming.bean.Course;

public interface CourseService {
	public List<Course> getAllCourse();
	public int insertCourse(Course course);
	public Course getByidCourse(int cno);
	public int updateCourse(Course course);
	public int deleteCourse(int cno);
}
