package com.yoda.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.yoda.board.vo.Reply;

public interface ReplyService {
	public List<Reply> listR(Integer no, int start, int end, HttpSession session);
	public void insertR(Reply ins);
	public void updateR(Reply upt);
	public void deleteR(Integer rno);
	public int count(int no);
}
