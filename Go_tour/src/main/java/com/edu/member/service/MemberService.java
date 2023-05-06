package com.edu.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.edu.common.util.SearchCriteria;
import com.edu.member.dto.MemberDTO;

//-----------------------------------------------------------------------------------------------------------
//회원 정보 서비스
//-----------------------------------------------------------------------------------------------------------
public interface MemberService {
	
	//회원가입 처리하기
	public  int addMember(MemberDTO memberDTO) throws DataAccessException;
	
	//아이디 중복 검사
	public int idCheck(MemberDTO memberDTO) throws Exception;
	
	// 로그인 처리하기
	public MemberDTO login(MemberDTO memberDTO) throws Exception;
	
	

}
