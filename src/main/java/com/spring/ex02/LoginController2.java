package com.spring.ex02;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*@Controller*/
public class LoginController2 {
	
	@RequestMapping(value = {"/loginForm.do","/loginForm2.do"} ,method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView loginForm(HttpServletRequest request , HttpServletResponse response){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("loginForm");
		return mav;
	}
	

	@RequestMapping(value = "/test/login2.do")
	//required = true로하면 jsp에서<input  type="hidden"  name="email" value="hong@test.com" />한 코드가 반드시 실행됨 값이없으면 예외가 남
	//false로했을 경우 값이 있으면 출력되고 없으면 null
	ModelAndView loign2(@RequestParam(value = "email",required = false) String email,HttpServletRequest request , HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("result2");
		mav.addObject("email",email);
		return mav;
		
		
	}
	
}
