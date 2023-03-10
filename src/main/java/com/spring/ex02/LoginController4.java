package com.spring.ex02;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*@Controller("loginController4")*/
public class LoginController4 {
	
	@RequestMapping(value = {"/loginForm3.do"} ,method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView loginForm(HttpServletRequest request , HttpServletResponse response){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("loginForm");
		return mav;
	}
	
	

	@RequestMapping(value = {"/test/login4.do"} ,method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login4(@ModelAttribute("loginVO1") LoginVO loginVO,HttpServletRequest request , HttpServletResponse response){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("result4");
		
		String userID=loginVO.getUserID();
		System.out.println(userID);
		
		/* mav.addObject("loginVO",loginVO); @ModelAttribute했기때문에 이 코드는 안써도딤 */
		return mav;
	}

	
}
