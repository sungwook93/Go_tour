package com.edu.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.board.dao.BoardDAO;
import com.edu.board.dto.BoardDTO;
import com.edu.common.util.SearchCriteria;

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

	// 게시글 리스트 가져오기
	@Override
	public List<BoardDTO> boardList(SearchCriteria sCri) throws Exception {
		
		System.out.println("BoardServiceImpl 게시글 리스트 가져오기");
		
		return boardDAO.boardList(sCri);
	}
	
	// 리스트 총 수를 가져온다.
	@Override
	public int boardListTotalCount(SearchCriteria sCri) throws Exception {
		System.out.println("BoardServiceImpl 리스트 총 수를 가져온다.");
		return boardDAO.boardListTotalCount(sCri);
	}

	//게시글 번호에 해당하는 BoardDTO를 가져와서 model에 담는다.
	@Override
	public BoardDTO boardDetail(int board_bno) throws Exception {
		System.out.println("BoardServiceImpl //게시글 번호에 해당하는 BoardDTO를 가져와서 model에 담는다.");
		return boardDAO.boardDetail(board_bno);
	}

}
