package com.yoda.board.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yoda.board.vo.Reply;
@Repository
public class ReplyDAOImpl implements ReplyDAO {
	@Autowired(required=false)
	SqlSession SqlSession;
	
	@Override
	public List<Reply> listR(Integer no, int start, int end) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("start", start);
		map.put("end",end);
		return SqlSession.selectList("listR", map);
	}

	@Override
	public void insertR(Reply ins) {
		// TODO Auto-generated method stub
		SqlSession.insert("insertR", ins);
	}

	@Override
	public void updateR(Reply upt) {
		// TODO Auto-generated method stub
		SqlSession.update("updateR", upt);
	}

	@Override
	public void deleteR(Integer rno) {
		// TODO Auto-generated method stub
		SqlSession.delete("deleteR", rno);
	}

	@Override
	public int count(int no) {
		// TODO Auto-generated method stub
		return SqlSession.selectOne("count", no);
	}
	
}
