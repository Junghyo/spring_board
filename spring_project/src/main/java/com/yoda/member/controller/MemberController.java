package com.yoda.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yoda.member.service.MemberService;
import com.yoda.member.vo.Member;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired(required=false)
	private MemberService service;
	
	@RequestMapping("login.do")
	public String login(){
		return "member/login";
	}
	
	@RequestMapping("loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute Member vo, HttpSession session){
		boolean result = service.loginCheck(vo, session);
		ModelAndView mav = new ModelAndView();
		if(result == true){
			mav.setViewName("member/home");
			mav.addObject("msg", "success");
		}else{
			mav.setViewName("member/login");
			mav.addObject("msg", "failure");
		}
		return mav;
	}
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session){
		service.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/login");
		mav.addObject("msg", "logout");
		return mav;
	}
	
}
