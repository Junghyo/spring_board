package com.yoda.member.repository;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yoda.member.vo.Member;
@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired(required=false)
	SqlSession SqlSession;
	
	@Override
	public boolean loginCheck(Member vo) {
		// TODO Auto-generated method stub
		String name = SqlSession.selectOne("loginCheck", vo);
		return (name==null) ? false : true;
	}

	@Override
	public Member memberInfo(Member info) {
		// TODO Auto-generated method stub
		return SqlSession.selectOne("memberInfo", info);
	}

	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
	}

}
