package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//컨트롤러 충돌시 하나를 막음
//@Controller
public class LoginController {

	@RequestMapping(value = {"/loginForm.do","/loginForm2.do"} ,method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView loginForm(HttpServletRequest request , HttpServletResponse response){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("loginForm");
		return mav;
	}
	
	@RequestMapping(value = "/test/login.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login(HttpServletRequest request , HttpServletResponse response) throws Exception {
		//request.setCharacterEncoding("utf-8");
		String userID=request.getParameter("userID");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("result");
		
		mav.addObject("userID" ,userID);
		return mav;
	}
	
	@RequestMapping(value = "/test/login2.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login2(@RequestParam(value = "userID") String userID ,
			@RequestParam(value = "userName") String userName ,HttpServletRequest request , HttpServletResponse response) throws Exception {
		//아래코드는 기존코드이며 바뀐코드는 위에 @RequestParam(value = "userID") String userID 이부분
		//	String userID=request.getParameter("userID");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("result");
		
		mav.addObject("userID" ,userID);
		mav.addObject("userName" ,userName);
		return mav;
	}
	
	//Model클래스의 addAttribute()메서드는 ModelAndView의addObject()메서드와
	//같은 기능을 합니다 Model클래스는 따로 뷰 정보를 전달할 필요가 없을 때 사용하면 좋다
	@RequestMapping(value = "/test/login5.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String login5(Model Model, HttpServletRequest request , HttpServletResponse response) throws Exception {
		
		Model.addAttribute("userID","아이디입니다");
		return "result5";
	}
	
}
