package com.yoda.member.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoda.member.repository.MemberDAO;
import com.yoda.member.vo.Member;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired(required=false)
	private MemberDAO dao;
	@Override
	public boolean loginCheck(Member vo, HttpSession session) {
		// TODO Auto-generated method stub
		boolean result = dao.loginCheck(vo);
		if(result){
			Member vo2 = memberInfo(vo);
			session.setAttribute("id", vo2.getId());
			session.setAttribute("name", vo2.getName());
		}
		return result;
	}

	@Override
	public Member memberInfo(Member info) {
		// TODO Auto-generated method stub
		return dao.memberInfo(info);
	}

	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		session.invalidate();

	}

}
