package com.edu.board.service;

import java.util.List;

import com.edu.board.dto.BoardDTO;
import com.edu.common.util.SearchCriteria;

public interface BoardService {

	
	//게시글 등록 처리하기 등록된 숫자가 돌아오기때문에 int로 받는다.
	public int boardRegister(BoardDTO boardDTO) throws Exception;

	//게시글 리스트를 가져온다.
	public List<BoardDTO> boardList(SearchCriteria sCri)throws Exception;

	// 리스트 총수를 가져온다.
	public int boardListTotalCount(SearchCriteria sCri)throws Exception;
	
	
}
