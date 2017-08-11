package com.yoda.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.yoda.board.vo.Board;

public interface BoardService {
	public List<Board> list(int start, int end, String option, String keyword) throws Exception;
	public Board read(int no) throws Exception;
	public void insert(Board ins) throws Exception;
	public void update(Board upt) throws Exception;
	public void delete(int no) throws Exception;
	public void increaseReadCnt(int no, HttpSession session) throws Exception;
	public int countArticle(String option, String keyword) throws Exception;
}
