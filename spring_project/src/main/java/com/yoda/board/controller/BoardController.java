package com.yoda.board.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yoda.board.service.BoardService;
import com.yoda.board.vo.Board;
import com.yoda.board.vo.BoardPage;


@Controller
@RequestMapping("/*")
public class BoardController {
	@Autowired(required=false)
	private BoardService service;
	
	@RequestMapping("list.do")
	public ModelAndView list(@RequestParam(defaultValue="title") String option,
			@RequestParam(defaultValue="") String keyword,
			@RequestParam(defaultValue="1") int curPage) throws Exception{
//		레코드 갯수 계산		
		int count = service.countArticle(option, keyword);
//		페이지 나누기 관련 처리		
		BoardPage boardPage = new BoardPage(count, curPage);
		int start = boardPage.getPageStart();
		int end = boardPage.getPageEnd();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", service.list(start, end, option, keyword));
		map.put("count", count);
		map.put("option", option);
		map.put("keyword", keyword);
		map.put("boardPage", boardPage);
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("board/list");
		return mav;
	}
	
	@RequestMapping("insert.do")
	public String insert(){
		return "board/insert";
	}
	
	@RequestMapping("insertProc.do")
	public String insertProc(@ModelAttribute Board ins, HttpSession session) throws Exception{
		String writer = (String) session.getAttribute("name");
		ins.setWriter(writer);
		service.insert(ins);
		return "redirect:list.do";
	}
	
	@RequestMapping("read.do")
	public ModelAndView read(@RequestParam int no, HttpSession session) throws Exception{
		service.increaseReadCnt(no, session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/read");
		mav.addObject("article", service.read(no));
		return mav;
	}
	
	@RequestMapping("update.do")
	public ModelAndView update(@RequestParam int no) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/update");
		mav.addObject("upt", service.read(no));
		return mav;
	}
	@RequestMapping("updateProc.do")
	public String updateProc(@ModelAttribute Board upt) throws Exception{
		service.update(upt);
		return "redirect:list.do";
	}
	
	@RequestMapping("delete.do")
	public String delete(@RequestParam int no) throws Exception{
		service.delete(no);
		return "redirect:list.do";
	}
}
