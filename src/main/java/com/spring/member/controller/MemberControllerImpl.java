package com.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.member.dao.MemberDAO;
import com.spring.member.dao.MemberDAOImpl;
import com.spring.member.service.MemberService;
import com.spring.member.vo.MemberVO;

@Controller(value = "memberController")
public class MemberControllerImpl  implements  MemberController {

//@Autowired으로 자동으로 주입
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO;
	


//	@Autowired을 쓰기 전에는 set해줬어야 했다
//	public void setMemberService(MemberService memberService) {
//		this.memberService = memberService;
//	}


	@Override
	@RequestMapping(value = "/member/listMembers.do" , method = RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		여기서 service로 가야함
		String viewName = getViewName(request);
		List membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);
		return mav;
		
	}
	
	@RequestMapping(value = "/member/*Form.do" , method = RequestMethod.GET)
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView(viewName);
		mav.setViewName(viewName);
		return mav;
	}
	
	
	@Override
	@RequestMapping(value = "/member/removeMember.do" , method = RequestMethod.GET)
	public ModelAndView removeMember(@RequestParam("id")String id,HttpServletRequest request, HttpServletResponse response) throws Exception{
		memberService.removeMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
		
	}
	
	@Override
	@RequestMapping(value = "/member/addMember.do" , method = RequestMethod.POST)
	//인터페이스에도 @ModelAttribute("member")MemberVO member,입력해줘야함
	public ModelAndView addMember(@ModelAttribute("member")MemberVO member,HttpServletRequest request, HttpServletResponse response) throws Exception {
		int result = 0;
		result = memberService.addMember(member);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
		
	}
	


/*	public ModelAndView modMember(HttpServletRequest request, HttpServletResponse response) throws Exception{
	
		String viewName = getViewName(request);
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String name=request.getParameter("name");
		String email=request.getParameter("email");

		MemberVO memberVO =new MemberVO();
		memberVO.setId(id);
		memberVO.setPwd(pwd);
		memberVO.setName(name);
		memberVO.setEmail(email);
		request.setAttribute("MemberVO", memberVO);
		ModelAndView mav = new ModelAndView(viewName);
		mav.setViewName(viewName);
		return mav;
		
	}  */
	

	
//	
		

//	public ModelAndView modMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		request.setCharacterEncoding("utf-8");	
//		MemberVO memberVO =new MemberVO();
//		//요청들어온 내용을 모두 바인드
//		bind(request, memberVO);
//		int result = 0;
//		result = memberService.modMember(memberVO);
//		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
//		return mav;
//		
//	}
	

	

	
		
		

	
	
	
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String fileName = uri.substring(begin, end);
		if (fileName.indexOf(".") != -1) {
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		}
		if (fileName.lastIndexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length());
		}
		return fileName;
	}



	


	

}
