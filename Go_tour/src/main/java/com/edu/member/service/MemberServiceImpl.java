package com.edu.member.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.edu.common.util.SearchCriteria;
import com.edu.member.dao.MemberDAO;
import com.edu.member.dto.MemberDTO;

//-----------------------------------------------------------------------------------------------------------
//회원 정보 서비스
//-----------------------------------------------------------------------------------------------------------
@Service("memberService")
public class MemberServiceImpl implements MemberService {

	private static final Logger logger 
	= LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired
	private MemberDAO memberDAO;

	//회원가입 처리하기
	@Override
	public int addMember(MemberDTO memberDTO) throws DataAccessException {

		logger.info("회원가입 처리하기 " + memberDTO);
		
		return memberDAO.addMember(memberDTO);
	}//end - 회원가입 처리하기
	
	//아이디 중복검사하기
	@Override
	public int idCheck(MemberDTO memberDTO) throws Exception {

		System.out.println("Memberservice 아이디 중복검사" + memberDTO);
		int result = memberDAO.idCheck(memberDTO);
		
		return result;
	}//end - 아이디 중복검사하기
	
	//로그인 처리하기
	@Override
	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		logger.info("로그인 처리하기");
		
		return memberDAO.login(memberDTO);
	}//로그인 처리하기



	


}
