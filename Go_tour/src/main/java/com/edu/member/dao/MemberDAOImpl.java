package com.edu.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.edu.common.util.SearchCriteria;
import com.edu.member.dto.MemberDTO;


@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private static final Logger logger 
	= LoggerFactory.getLogger(MemberDAOImpl.class);
	
	private	static final String Namespace = "com.edu.member";

	//회원가입 처리하기
	@Override
	public int addMember(MemberDTO memberDTO) throws DataAccessException {
		logger.info("회원가입 처리하기" + memberDTO);
		
		
		return sqlSession.insert(Namespace + ".addMember", memberDTO);
	}//end - 회원가입 처리하기
	
	// 아이디 중복검사
	@Override
	public int idCheck(MemberDTO memberDTO) throws Exception {
		System.out.println("memberDAO 아이디 중복검사" + memberDTO);
		
		return sqlSession.selectOne(Namespace + ".idCheck", memberDTO);
	}//end- 아이디 중복검사
	
	//로그인 처리하기
	@Override
	public MemberDTO login(MemberDTO memberDTO) throws DataAccessException {
		
		MemberDTO memDTO = sqlSession.selectOne(Namespace + ".loginID", memberDTO);
		return memDTO;
	}//end - 로그인 처리하기

	
	
	
	

	
}
