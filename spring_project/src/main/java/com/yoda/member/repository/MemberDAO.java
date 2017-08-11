package com.yoda.member.repository;

import javax.servlet.http.HttpSession;



import com.yoda.member.vo.Member;

public interface MemberDAO {
	public boolean loginCheck(Member vo);
	public Member memberInfo(Member info);
	public void logout(HttpSession session);
}
