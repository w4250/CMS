package com.kunming.bean;

public class Teacher {
	private int tno;
	private String tname;
	private String tpassword;
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTpassword() {
		return tpassword;
	}
	public void setTpassword(String tpassword) {
		this.tpassword = tpassword;
	}
	@Override
	public String toString() {
		return "Teacher [tno=" + tno + ", tname=" + tname + ", tpassword=" + tpassword + "]";
	}
	public Teacher(int tno, String tname, String tpassword) {
		super();
		this.tno = tno;
		this.tname = tname;
		this.tpassword = tpassword;
	}
	public Teacher() {
		
	}
}
