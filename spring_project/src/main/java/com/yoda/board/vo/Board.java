/*CREATE TABLE BOARD
(
   NO        NUMBER,
   TITLE     VARCHAR2 (200),
   CONTENT   VARCHAR2 (4000),
   WRITER    VARCHAR2 (50),
   REGDATE   DATE DEFAULT SYSDATE,
   READCNT   NUMBER DEFAULT 0
)
NOCACHE
LOGGING;*/
package com.yoda.board.vo;

import java.util.Date;

public class Board {
	private int no;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private int readCnt;
	private String name;
	private int recnt;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getReadCnt() {
		return readCnt;
	}
	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRecnt() {
		return recnt;
	}
	public void setRecnt(int recnt) {
		this.recnt = recnt;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Board [ no=" + no + ", title=" + title + "content=" + content + "writer=" + writer +
				"regDate=" + regDate + "readCnt=" + readCnt + "]" ;
	}
	
}
