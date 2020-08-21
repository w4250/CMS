package com.kunming.service;


import com.kunming.bean.Student;

public interface StudentService {

	public int insertStu(Student student);
	public int deleteStudent(int sno);
	public int updateStudent(Student student);
	public Student getStuBySnoPassWord(Student s);
}
