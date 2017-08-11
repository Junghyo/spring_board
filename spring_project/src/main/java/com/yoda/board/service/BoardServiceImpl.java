package com.yoda.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoda.board.repository.BoardDAO;
import com.yoda.board.vo.Board;
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired(required=false)
	private BoardDAO dao;
	@Override
	public List<Board> list(int start, int end, String option, String keyword) throws Exception {
		// TODO Auto-generated method stub
		return dao.list(start, end, option, keyword);
	}

	@Override
	public Board read(int no) throws Exception {
		// TODO Auto-generated method stub
		return dao.read(no);
	}

	@Override
	public void insert(Board ins) throws Exception {
		// TODO Auto-generated method stub
		String title = ins.getTitle();
		String content = ins.getTitle();
		String writer = ins.getWriter();
		title = title.replace("<", "&lt;");
		title = title.replace("<", "&gt;");
		writer = writer.replace("<", "&lt;");
		writer = writer.replace("<", "&gt;");
		title = title.replace("  ", "&nbsp;&nbsp;");
		writer = writer.replace("  ", "&nbsp;&nbsp;");
		content = content.replace("\n", "<br>");
		ins.setTitle(title);
		ins.setContent(content);
		ins.setWriter(writer);
		dao.insert(ins);
	}

	@Override
	public void update(Board upt) throws Exception {
		// TODO Auto-generated method stub
		dao.update(upt);
	}

	@Override
	public void delete(int no) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(no);
	}

	@Override
	public void increaseReadCnt(int no, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		long update_time = 0;
		if(session.getAttribute("update_time: "+no)!=null){
			update_time = (Long) session.getAttribute("update_time: "+no);
		}
		long current_time = System.currentTimeMillis();
		if(current_time - update_time>1000){
			dao.increaseReadCnt(no);
			session.setAttribute("update_time: "+no, current_time);
		}
	}

	@Override
	public int countArticle(String option, String keyword) throws Exception {
		// TODO Auto-generated method stub
		return dao.countArticle(option, keyword);
	}
	

}
