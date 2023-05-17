package com.edu.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.board.dto.BoardDTO;
import com.edu.common.util.SearchCriteria;

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

	// 게시글 리스트 가져오기
	@Override
	public List<BoardDTO> boardList(SearchCriteria sCri) throws Exception {
		System.out.println("BoardDAOImpl에서 게시글 리스트 가져오기");
		return sqlSession.selectList(Namespace + ".boardList", sCri);
	}
	
	// 게시글 총 수를 가져온다.
	@Override
	public int boardListTotalCount(SearchCriteria sCri) throws Exception {
		System.out.println("BoardDAOImpl에서 게시글 총 수를 가져온다.");
		return sqlSession.selectOne(Namespace + ".boardListTotalCount", sCri);
	}

	//게시글 번호에 해당하는 BoardDTO를 가져와서 model에 담는다.
	@Override
	public BoardDTO boardDetail(int board_bno) throws Exception {
		System.out.println("BoardDAOImpl에서 게시글 번호에 해당하는 BoardDTO를 가져와서 model에 담는다.");
		return sqlSession.selectOne(Namespace + ".boardDetail", board_bno);
	}

	
	
}
