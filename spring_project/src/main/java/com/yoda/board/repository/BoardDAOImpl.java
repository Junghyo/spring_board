package com.yoda.board.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yoda.board.vo.Board;
@Repository
public class BoardDAOImpl implements BoardDAO {
	@Autowired(required=false)
	SqlSession SqlSession;
	@Override
	public List<Board> list(int start, int end, String option, String keyword) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("option", option);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		return SqlSession.selectList("list", map);
	}

	@Override
	public Board read(int no) throws Exception {
		// TODO Auto-generated method stub
		return SqlSession.selectOne("read", no);
	}

	@Override
	public void insert(Board ins) throws Exception {
		// TODO Auto-generated method stub
		SqlSession.insert("insert", ins);

	}

	@Override
	public void update(Board upt) throws Exception {
		// TODO Auto-generated method stub
		SqlSession.update("update", upt);
	}

	@Override
	public void delete(int no) throws Exception {
		// TODO Auto-generated method stub
		SqlSession.delete("delete", no);

	}

	@Override
	public void increaseReadCnt(int no) throws Exception {
		// TODO Auto-generated method stub
		SqlSession.update("increaseReadCnt", no);

	}

	@Override
	public int countArticle(String option, String keyword) throws Exception {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("option", option);
		map.put("keyword", keyword);
		return SqlSession.selectOne("countArticle", map);
	}
	
}
