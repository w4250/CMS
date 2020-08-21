package com.kunming.bean;

public class Student {
	private int sno;
	private String ssex;
	private String sclass;
	private String sname;
	private String spassword;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", ssex=" + ssex + ", sclass=" + sclass + ", sname=" + sname + ", spassword="
				+ spassword + "]";
	}
	public Student(int sno, String ssex, String sclass, String sname, String spassword) {
		super();
		this.sno = sno;
		this.ssex = ssex;
		this.sclass = sclass;
		this.sname = sname;
		this.spassword = spassword;
	}
	public Student() {

	}
}
