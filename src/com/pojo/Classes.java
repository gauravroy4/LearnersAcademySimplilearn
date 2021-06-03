package com.pojo;

public class Classes {
	
	private int classid;
	private String classname;
	private String section;
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	@Override
	public String toString() {
		return "Classes [classid=" + classid + ", classname=" + classname + ", section=" + section + "]";
	}
	
	
	
}
