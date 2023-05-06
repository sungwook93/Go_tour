package com.edu.board.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.board.dao.BoardDAO;
import com.edu.board.dto.BoardDTO;

@Service // bean으로 인식 시키기
public class BoardServiceImpl implements BoardService {

	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Autowired
	private BoardDAO boardDAO;
	
	//게시글 등록하기
	@Override
	public int boardRegister(BoardDTO boardDTO) throws Exception {
		
		System.out.println("BoardServiceImpl 게시글 등록 처리하기() 시작한다.");
		
		return boardDAO.boardRegister(boardDTO);
	}//end- 게시글 등록하기

}
