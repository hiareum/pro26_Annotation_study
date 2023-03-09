package com.spring.ex01;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//@Controller어노테이션으로 메인컨트롤러로 지정
//@RequestMapping로 테스트파일에 있는 jsp는 모두 매핑
@Controller("mainController")
@RequestMapping("/test")
public class MainController {
	//매핑된 값은 hi.do이며 서버에 http://localhost:8080/pro26/test/hi.do로 요청시 get방식으로 출력
	@RequestMapping(value = "/hi.do", method = RequestMethod.GET)
	ModelAndView main1(HttpServletRequest request,HttpServletResponse response)throws Exception {
		//뷰네임을 가져오기 위해 ModelAndView객체 생성
		ModelAndView mav = new ModelAndView();
		//ModelAndView에 addObject로 키값:hikey 에 안녕하세요라는 문구입력
		mav.addObject("hikey","안녕하세요");
		//뷰네임이 hiJsp라는 jsp파일
		mav.setViewName("hiJsp");
		//반환
		return mav;

	}
	
	//value = {"/hi2.do" ,"/hi2_1.do"}설정하므로 둘중하나의 매핑값으로 요청해도 출력됨
	@RequestMapping(value = {"/hi2.do" ,"/hi2_1.do"}, method = RequestMethod.GET)
	ModelAndView main2(HttpServletRequest request,HttpServletResponse response)throws Exception {
		//뷰네임을 가져오기 위해 ModelAndView객체 생성
		ModelAndView mav = new ModelAndView();
		//ModelAndView에 addObject로 키값:hikey 에 안녕하세요2라는 문구입력
		mav.addObject("hikey","안녕하세요2");
		//뷰네임이 hiJsp2라는 jsp파일
		mav.setViewName("hiJsp2");
		//반환
		return mav;

	}

}
