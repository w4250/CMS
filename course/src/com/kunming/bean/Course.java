package com.kunming.bean;

public class Course {
	private int cno;
	private String cname;
	private float ccredit;
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public float getCcredit() {
		return ccredit;
	}
	public void setCcredit(float ccredit) {
		this.ccredit = ccredit;
	}
	@Override
	public String toString() {
		return "Course [cno=" + cno + ", cname=" + cname + ", ccredit=" + ccredit + "]";
	}
	public Course(int cno, String cname, float ccredit) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.ccredit = ccredit;
	}
	public Course() {
		
	}
}
