package com.edu.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edu.member.dto.MemberDTO;
import com.edu.member.service.MemberService;

@Controller("memberController")
@RequestMapping("/member") 
public class MemberControllerImpl implements MemberController {

	
	private static final Logger logger 
	= LoggerFactory.getLogger(MemberControllerImpl.class);


	//-----------------------------------------------------------------------------------------------------------
	//	@Inject		: Java에서 지원하는 어노테이션. 특정 Framework에 종속정이기 않다.
	//	@Autowired	: Spring에서 지원하는 어노테이션.
	//-----------------------------------------------------------------------------------------------------------
	@Autowired
	private	MemberDTO	memberDTO;
	
	@Autowired
	private MemberService memberService;
	
	
	//회원가입 화면 불러오기
	@Override
	@RequestMapping(value="/memberForm.do", method=RequestMethod.GET)
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {

		logger.info("회원가입 화면 불러오기 시작");
		
		ModelAndView mav = new ModelAndView(); // 회원가입 화면으로
		mav.setViewName("/member/memberForm");	
		
		return mav;
	}// end - 화원하기 화면 불러오기

	//회원가입 등록하기
	@Override
	@RequestMapping(value="/addMember.do", method=RequestMethod.POST)
	public ModelAndView addMember(MemberDTO memberDTO, HttpServletRequest request, HttpServletResponse response) throws Exception {

		logger.info("회원가입 등록하기");	
		// 한글이 깨질수도 있으므로 작성해준다
		response.setContentType("text/html;charset=UTF-8");		
		// 사용자가 입력한 회원정보 서비스로 넘겨줌
		memberService.addMember(memberDTO);		
		ModelAndView mav = new ModelAndView(); // 회원가입 화면으로
		mav.setViewName("/member/loginForm");	// 로그인 화면으로 이동시킨다.
		
		return mav;
	}//end - 회원가입 등록하기
	
	//아이디 중복검사
	@Override
	@ResponseBody
	@RequestMapping(value="/idCheck", method = RequestMethod.POST)
	public int idCheck(MemberDTO memberDTO) throws Exception {
		
		System.out.println("아이디 중복검사 (ajax) 시작" + memberDTO);
		
		//받아온 데이터로 아이디가 있는지 확인해본다
		int result = memberService.idCheck(memberDTO);
		
		System.out.println("데이터 받아온값 " + result);
		
		
		return result;
		
	}//end - 아이디 중복검사
	

	//로그인 화면 띄우기
	@Override
	@RequestMapping(value="loginForm.do", method=RequestMethod.GET)
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("로그인 화면 띄우기");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/loginForm");
		return mav;
	}//end - 로그인 화면 띄우기

	// 로그인 처리하기(ajax 사용 fn_login())
	@Override
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	@ResponseBody
	public int login(MemberDTO member, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("로그인 처리 시작한다...");
		System.out.println("로그인 창에서 넘어온 정보 " + member.getUserID() + " : " + member.getPwd());
		
		
		
		// 로그인한 정보를 가지고 데이터베이스에 존재하는지 처리를 하고, 그 결과를 가져온다.
		// member => 로그인 창에서 보내온 정보, memberDTO => DB에서 가져온 정보
		memberDTO = memberService.login(member);
		System.out.println("로그인 처리 결과 =" + memberDTO);
		
		//입력한 아이디 값이 없을경우 member
		if(member.getUserID().equals("") || member.getUserID() == null) {
			return 1;
		}
		
		// 가져온 데이터로 로그인 처리하기 memberDTO
		if(memberDTO != null) { // 로그인한 아이디가 DB에 있을경우 memberDTO(DB)
			//비번이 같으면 성공
			if(member.getPwd().equals(memberDTO.getPwd())) {
				//아이디와 비밀번호가 일치하므로 세션을 발급
				HttpSession session = request.getSession();
				session.setAttribute("member", memberDTO);
				session.setAttribute("isLogOn", true);
				
				return 4;
				
			}else { // 아이디가 있는데 비밀번호가 틀린경우
				return 2;
			}
			
		} else{ // 로그인한 아이디가 DB에 없을경우 memberDTO(DB)
			return 3;
		}	
		
		
	}//end- 로그인 처리하기
	
	
	//로그 아웃 처리하기
	@Override
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 로그아웃 버튼을 누르면 세션정보를 없애고, 메인페이지로 이동하게하기
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/main.do"); //메인페이지로 이동시킨다.
		
		return mav;
	}//end - 로그 아웃 처리하기

	//myPage 화면 띄우기
	@Override
	@RequestMapping(value="/myPage", method=RequestMethod.GET)
	public ModelAndView myPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		logger.info("controller mypage 화면시작");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/myPage"); // mypage 화면
		
		return mav;
	
	}//end- myPage 화면 띄우기
	

	
	
	
	
	
	
	
	

	
	
	
}// end - public class MemberControllerImpl implements MemberController
