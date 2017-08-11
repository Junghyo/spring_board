/*CREATE TABLE REPLY(
	RNO NUMBER,
	NO NUMBER,
	REPLYTEXT VARCHAR2(2000),
	PREPLYER VARCHAR2(1000),
	NAME VARCHAR2(1000),
	REGDATE DATE DEFAULT SYSDATE,
	UPTDATE DATE DEFAULT SYSDATE
);*/
package com.yoda.board.vo;

import java.util.Date;

public class Reply {
	private Integer rno;
	private Integer no;
	private String replytext;
	private String replyer;
	private String name;
	private Date regdate;
	private Date uptdate;
	private String secret;
	private String writer;
	
	public Integer getRno() {
		return rno;
	}
	public void setRno(Integer rno) {
		this.rno = rno;
	}
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getReplytext() {
		return replytext;
	}
	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUptdate() {
		return uptdate;
	}
	public void setUptdate(Date uptdate) {
		this.uptdate = uptdate;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	
}
