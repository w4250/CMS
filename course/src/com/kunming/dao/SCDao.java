package com.kunming.dao;

import java.util.List;

import com.kunming.bean.Course;
import com.kunming.bean.SC;
import com.kunming.bean.Student;

public interface SCDao {
	//学生信息，课程信息，所有信息都封装在SC中
	public List<SC> getAllsc();
	//根据学生编号查询信息:编号是唯一，实体类作为一个返回值类型。
	//但是目前为止：多表联合查询：3张，3张表的信息，student，course，SC
	public List<SC> getSCById(int sno);
	//查询学生的信息
	public List<SC>  getAllSC01();
	public List<SC> getBySC(Student s,SC sc,Course c);
	public List<SC> getSCBySno(int sno);
	public List<SC> getSCBySname(String sname);
	public List<SC> getSCBySclass(String sclass);
	public List<SC> getSCByCname(String cname);
	public List<SC> getSCByCno(int cno);
	public List<SC> getSCByClassroom(String classroom);
	//根据学号，课程号查询学号、课程号、上课地点的信息
	public SC getSCBySnoCno(int sno,int cno);
	//修改
	public int updateSC(SC sc);
	//添加
	public int[] insertSC(SC[] sc);
	//查询某一个学生的课程信息：课程编号，课程名称，课程学分，上课教室
	public List<SC> getStudentCourse(int sno);
	//删除某一个学生的某条课程信息
	public int deleteStudentCourse(int sno,int cno);
}