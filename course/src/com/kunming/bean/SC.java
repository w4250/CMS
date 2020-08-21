package com.kunming.bean;

public class SC {
	private int sno;
	private int cno;
	private String classroom;
	private Course course;
	private Student student;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "SC [sno=" + sno + ", cno=" + cno + ", classroom=" + classroom + ", course=" + course + ", student="
				+ student + "]";
	}
	public SC(int sno, int cno, String classroom, Course course, Student student) {
		super();
		this.sno = sno;
		this.cno = cno;
		this.classroom = classroom;
		this.course = course;
		this.student = student;
	}
	public SC() {
	}
}
