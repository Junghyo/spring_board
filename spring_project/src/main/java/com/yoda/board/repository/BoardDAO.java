package com.yoda.board.repository;

import java.util.List;


import com.yoda.board.vo.Board;

public interface BoardDAO {
	public List<Board> list(int start, int end, String option, String keyword) throws Exception;
	public Board read(int no) throws Exception;
	public void insert(Board ins) throws Exception;
	public void update(Board upt) throws Exception;
	public void delete(int no) throws Exception;
	public void increaseReadCnt(int no) throws Exception;
	public int countArticle(String option, String keyword) throws Exception;
	
}
