package com.yoda.board.repository;

import java.util.List;

import com.yoda.board.vo.Reply;

public interface ReplyDAO {
	public List<Reply> listR(Integer no, int start, int end);
	public void insertR(Reply ins);
	public void updateR(Reply upt);
	public void deleteR(Integer rno);
	public int count(int no);
}
