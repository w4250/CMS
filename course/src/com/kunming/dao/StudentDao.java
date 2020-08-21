package com.kunming.dao;

import com.kunming.bean.Student;

public interface StudentDao {
	
	public int insertStudent(Student student);
	public int deleteStudent(int sno);
	public int updateStudent(Student student);
	public Student getStuBySnoPassWord(Student s);
}
