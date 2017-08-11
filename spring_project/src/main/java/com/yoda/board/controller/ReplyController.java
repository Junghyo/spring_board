package com.yoda.board.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yoda.board.service.ReplyService;
import com.yoda.board.vo.Reply;
import com.yoda.board.vo.ReplyPage;

@RestController
@RequestMapping("/reply/*")
public class ReplyController {
	@Autowired(required=false)
	private ReplyService service;
	
	@RequestMapping("insert.do")
	public void insertR(@ModelAttribute Reply ins, HttpSession session){
		String id = (String) session.getAttribute("id");
		String name = (String) session.getAttribute("name");
		ins.setReplyer(id);
		ins.setName(name);
		service.insertR(ins);
	}
	
	@RequestMapping("list.do")
	public ModelAndView listR(@RequestParam int no,
			@RequestParam(defaultValue="1") int curPage,
			ModelAndView mav, HttpSession session){
		int count = service.count(no);
		ReplyPage replyPage = new ReplyPage(count, curPage);
		int start = replyPage.getPageStart();
		int end = replyPage.getPageEnd();
		mav.setViewName("board/replyList");
		mav.addObject("listR", service.listR(no, start, end, session));
		mav.addObject("replyPage", replyPage);
		return mav;
	}
	
/*	@RequestMapping("listJson.do")
	@ResponseBody
	public List<Reply> listJson(@RequestParam int no){
		
		return service.listR(no);
	}*/
}
