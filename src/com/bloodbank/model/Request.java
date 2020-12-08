package com.bloodbank.model;

public class Request {

	private Integer id;
	private String rdid;
	private Integer sid;
	private String status;
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Request [id=" + id + ", sid=" + sid + ", rdid=" + rdid + ", status=" + status + "]";
}
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDid() {
		return rdid;
	}
	public void setDid(String rdid) {
		this.rdid = rdid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}



