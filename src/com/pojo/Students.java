package com.pojo;

import java.util.Date;

public class Students {

	private int stdid;
	private String stdname;
	private Date dob;
	private String parent;
	private String contact;
	private int cid;
	public int getStdid() {
		return stdid;
	}
	public void setStdid(int stdid) {
		this.stdid = stdid;
	}
	public String getStdname() {
		return stdname;
	}
	public void setStdname(String stdname) {
		this.stdname = stdname;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "Students [stdid=" + stdid + ", stdname=" + stdname + ", dob=" + dob + ", parent=" + parent
				+ ", contact=" + contact + ", cid=" + cid + "]";
	}
	
	

	
	
}
