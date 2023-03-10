package com.spring.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.member.dao.MemberDAO;
import com.spring.member.vo.MemberVO;

@Service(value = "memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService{
	
//	MemberDAO를 주입(inject)
	@Autowired
	private MemberDAO memberDAO;
	



	@Override
	public List listMembers() throws DataAccessException {
		List membersList = null;
		membersList = memberDAO.selectAllMembers();
		return membersList;
	}
	
	@Override
	public int addMember(MemberVO memberVO)throws DataAccessException{
		return memberDAO.insertMember(memberVO);
	}


	/*
	 * @Override public int modMember(MemberVO memberVO) throws DataAccessException
	 * { return memberDAO.modMember(memberVO); }
	 */
	
	@Override
	public int removeMember(String id) throws DataAccessException {
		return memberDAO.removeMember(id);
	}
	
	


	
	
	
}
