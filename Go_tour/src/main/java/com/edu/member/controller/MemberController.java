package com.edu.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edu.member.dto.MemberDTO;

public interface MemberController {
	
	//회원가입 화면 불러오기
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception;

	//회원가입 등록하기
	public ModelAndView addMember(MemberDTO memberDTO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// 아이디 중복 검사하기
	public int idCheck(MemberDTO memberDTO) throws Exception;
	
	//로그인 화면 띄우기
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response)throws Exception;

	//로그인 처리하기
	public int login(MemberDTO member, 
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//로그아웃 처리하기
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	//나의 정보 화면으로 이동한다.
	public ModelAndView myPage(HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	
}// end - public interface MemberController
