package com.kunming.service;

import java.util.List;

import com.kunming.bean.SC;

public interface SCService {
	//查询所有学生信息
	public List<SC> getAllSc();
	//根据学生编号查询学生信息
	public List<SC> getSCById(int sno);
	//查询所有学生的信息
	public List<SC> getAllSC01();
	//按照学号查询学生信息
	public List<SC> getSCBySno(int cno);
	//按照姓名查询学生信息
	public List<SC> getSCBySname(String sname);
	
	public List<SC> getSCBySclass(String sclass);
	public List<SC> getSCByCname(String cname);
	public List<SC> getSCByCno(int cno);
	public List<SC> getSCByClassroom(String classroom);
	
	//根据学号，课程号查询学号、课程号、上课地点的信息
	public SC getSCBySnoCno(int sno,int cno);
	//修改
	public int updateSC(SC sc);
	public int[] insertSC(SC[] sc);
	//查询某一个学生的课程信息：课程编号，课程名称，课程学分，上课教室
	public List<SC> getStudentCourse(int sno);
	//删除某一个学生的某条课程信息
	public int deleteStudentCourse(int sno,int cno);
}
