package com.yoda.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoda.board.repository.ReplyDAO;
import com.yoda.board.vo.Reply;
@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired(required=false)
	private ReplyDAO dao;
	
	@Override
	public List<Reply> listR(Integer no, int start, int end, HttpSession session) {
		// TODO Auto-generated method stub
		List<Reply> replies = dao.listR(no, start, end);
		String id = (String) session.getAttribute("id");
		for(Reply reply : replies){
			if(reply.getSecret().equals("y")){
				if(id==null || id==""){
					reply.setReplytext("비밀 댓글입니다.");
				} else {
					String writer = reply.getWriter();
					String replyer = reply.getReplyer();
					if(!id.equals(writer) && !id.equals(replyer)){
						reply.setReplytext("비밀 댓글입니다.");
					}
				}
			}
		}
		return replies;
	}

	@Override
	public void insertR(Reply ins) {
		// TODO Auto-generated method stub
		dao.insertR(ins);
	}

	@Override
	public void updateR(Reply upt) {
		// TODO Auto-generated method stub
		dao.updateR(upt);
	}

	@Override
	public void deleteR(Integer rno) {
		// TODO Auto-generated method stub
		dao.deleteR(rno);
	}

	@Override
	public int count(int no) {
		// TODO Auto-generated method stub
		return dao.count(no);
	}
	
	

}
