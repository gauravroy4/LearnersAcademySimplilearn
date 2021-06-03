package com.pojo;

public class Subjects {
	
	private int subid;
	private String subname;
	private String language;
	
	
	public int getSubid() {
		return subid;
	}
	public void setSubid(int subid) {
		this.subid = subid;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "Subjects [subid=" + subid + ", subname=" + subname + ", language=" + language + "]";
	}
	
	

}
