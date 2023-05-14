package com.edu.board.dao;

import java.util.List;

import com.edu.board.dto.BoardDTO;
import com.edu.common.util.SearchCriteria;


public interface BoardDAO {

	// 게시글 등록하기
	public int boardRegister(BoardDTO boardDTO)throws Exception;

	// 게시글 리스트 가져오기
	public List<BoardDTO> boardList(SearchCriteria sCri)throws Exception;

	// 게시글 총수 가져오기
	public int boardListTotalCount(SearchCriteria sCri)throws Exception;
	
	
	
}
