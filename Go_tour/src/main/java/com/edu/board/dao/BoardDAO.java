package com.edu.board.dao;

import com.edu.board.dto.BoardDTO;


public interface BoardDAO {

	// 게시글 등록하기
	public int boardRegister(BoardDTO boardDTO)throws Exception;
	
	
	
}
