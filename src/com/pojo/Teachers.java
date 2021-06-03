package com.pojo;

public class Teachers {
	
	private int tid;
	private String tname;
	private String contact;
	
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Teachers [tid=" + tid + ", tname=" + tname + ", contact=" + contact + "]";
	}
	
	

}
