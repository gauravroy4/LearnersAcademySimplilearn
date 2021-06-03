package com.pojo;

public class AssignClass {
	
	private int sno;
	private int classid;
	private int subjectid;
	private int teacherid;
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public int getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(int subjectid) {
		this.subjectid = subjectid;
	}
	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	@Override
	public String toString() {
		return "AssignClass [sno=" + sno + ", classid=" + classid + ", subjectid=" + subjectid + ", teacherid="
				+ teacherid + "]";
	}
	
	
	
}
