/*CREATE TABLE MEMBER(
	ID VARCHAR2(500) PRIMARY KEY,
	PWD VARCHAR2(250) NOT NULL,
	NAME VARCHAR2(500) NOT NULL,
	EMAIL VARCHAR2(1000) NOT NULL,
	REGDATE DATE DEFAULT SYSDATE,
	UPTDATE DATE DEFAULT SYSDATE
);*/
package com.yoda.member.vo;

import java.util.Date;

public class Member {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date regDate;
	private Date uptDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getUptDate() {
		return uptDate;
	}
	public void setUptDate(Date uptDate) {
		this.uptDate = uptDate;
	}
	
}
