package com.spring.ex02;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//@Controller("loginController3")
public class LoginController3 {
	
	@RequestMapping(value = {"/loginForm2.do"} ,method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView loginForm(HttpServletRequest request , HttpServletResponse response){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("loginForm");
		return mav;
	}
	
	

	@RequestMapping(value = {"/test/login3.do"} ,method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login3(@RequestParam Map<String,String> info,HttpServletRequest request , HttpServletResponse response){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("result3");
		
		System.out.println(info);
		String userID=info.get("userID");
		String userName=info.get("userName");
		
		System.out.println(userID);
		System.out.println(userName);
		
		//화면에 출력하기 위해 사용된 코드
		 mav.addObject("info",info); 
		
		return mav;
	}

	
}
