package com.kunming.serviceImpl;

import com.kunming.bean.Teacher;
import com.kunming.dao.TeacherDao;
import com.kunming.daoImpl.TeacherDaoImpl;
import com.kunming.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {
	private TeacherDao teacherDao = new TeacherDaoImpl();
	@Override
	public Teacher getTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherDao.getTeacher(teacher);
	}
}
