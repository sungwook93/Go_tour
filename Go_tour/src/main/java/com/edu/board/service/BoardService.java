package com.edu.board.service;

import com.edu.board.dto.BoardDTO;

public interface BoardService {

	
	//게시글 등록 처리하기 등록된 숫자가 돌아오기때문에 int로 받는다.
	public int boardRegister(BoardDTO boardDTO) throws Exception;
	
	
}
