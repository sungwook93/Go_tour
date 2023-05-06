package com.edu.board.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.board.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private static String Namespace = "com.edu.board";
	
	// 게시글 등록하기
	@Override
	public int boardRegister(BoardDTO boardDTO) throws Exception {
		System.out.println("BoardDAOImpl에서 게시글 등록하기!!!!!!!!!");
		return sqlSession.insert(Namespace + ".boardRegister", boardDTO);
		
	}

}
