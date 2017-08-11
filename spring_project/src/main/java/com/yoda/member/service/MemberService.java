package com.yoda.member.service;

import javax.servlet.http.HttpSession;

import com.yoda.member.vo.Member;

public interface MemberService {
	public boolean loginCheck(Member vo, HttpSession session);
	public Member memberInfo(Member info);
	public void logout(HttpSession session);
}
