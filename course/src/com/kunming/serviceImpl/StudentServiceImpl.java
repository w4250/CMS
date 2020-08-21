package com.kunming.serviceImpl;

import com.kunming.bean.Student;
import com.kunming.dao.StudentDao;
import com.kunming.daoImpl.StudentDaoImpl;
import com.kunming.service.StudentService;

public class StudentServiceImpl implements StudentService {
	StudentDao studentDao = new StudentDaoImpl();
	@Override
	public int insertStu(Student student) {
		// TODO Auto-generated method stub
		return studentDao.insertStudent(student);
	}
	@Override
	public int deleteStudent(int sno) {
		// TODO Auto-generated method stub
		return studentDao.deleteStudent(sno);
	}
	@Override
	public int updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.updateStudent(student);
	}
	@Override
	public Student getStuBySnoPassWord(Student s) {
		// TODO Auto-generated method stub
		return studentDao.getStuBySnoPassWord(s);
	}

}
