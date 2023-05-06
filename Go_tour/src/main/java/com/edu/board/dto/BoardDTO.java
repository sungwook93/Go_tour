package com.edu.board.dto;

import java.sql.Timestamp;

public class BoardDTO {
	
	private int board_bno;				// 게시글 번호
	private String board_subject;		// 게시글 제목
	private String userID;				// 사용자 아이디
	private String board_content;		// 게시글 내용
	private Timestamp board_regDate;	// 게시글 작성일자
	private int board_readCount;		// 게시글 조회수
	
	public int getBoard_bno() {
		return board_bno;
	}
	public void setBoard_bno(int board_bno) {
		this.board_bno = board_bno;
	}
	public String getBoard_subject() {
		return board_subject;
	}
	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public Timestamp getBoard_regDate() {
		return board_regDate;
	}
	public void setBoard_regDate(Timestamp board_regDate) {
		this.board_regDate = board_regDate;
	}
	public int getBoard_readCount() {
		return board_readCount;
	}
	public void setBoard_readCount(int board_readCount) {
		this.board_readCount = board_readCount;
	}
	@Override
	public String toString() {
		return "BoardDTO [board_bno=" + board_bno + ", board_subject=" + board_subject + ", userID=" + userID
				+ ", board_content=" + board_content + ", board_regDate=" + board_regDate + ", board_readCount="
				+ board_readCount + "]";
	}
	
	

}// end- public class BoardDTO
