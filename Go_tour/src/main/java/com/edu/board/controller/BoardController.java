package com.edu.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.edu.board.dto.BoardDTO;
import com.edu.board.service.BoardService;
import com.edu.common.util.SearchCriteria;

@Controller 
@RequestMapping(value = "/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	
	@Autowired
	private BoardService boardService;
	
	//게시글 목록 보여주기 (Paging 처리 + 검색)
	@RequestMapping(value="/boardList", method= RequestMethod.GET)
	public ModelAndView boardList(SearchCriteria sCri) throws Exception{
		
		System.out.println("boardList controller 시작");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/board/boardList");
		
		return mav;
	}//end - 게시글 목록 보여주기
	
	// 게시글 쓰기 화면불러오기
	@RequestMapping(value="/boardRegisterForm", method=RequestMethod.GET)
	public String boardRegisterForm() throws Exception{
		
		logger.info("boardController 게시글작성 화면 불러오기");
		
		return "/board/boardRegisterForm";
	}//end - 게시글 쓰기 화면 불러오기
	
	// 게시글 등록하기
	// ajax를 사용하므로 데이터를 다시 돌려줄때는 ResponseBody를 사용한다.
	@ResponseBody
	@RequestMapping(value="/boardRegister", method=RequestMethod.POST)
	public String boardRegister(BoardDTO boardDTO)throws Exception{
		
		logger.info("boardController 게시글 등록하기 시작");
		System.out.println("BoardDTO 값" + boardDTO);
		int result =  boardService.boardRegister(boardDTO);
		
		System.out.println(result + "=============");
		
		if(result == 1) { //게시글 등록에 성공하면 Y를돌려준다.
			return "Y";
		} else { // 게시글 등록 실패
			return "N";
		}
		
	}// end -  게시글 등록하기
	
	
}
