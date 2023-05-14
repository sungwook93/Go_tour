package com.edu.board.dto;

import java.sql.Timestamp;

public class BoardDTO {
	
	private int board_bno;				// 게시글 번호
	private String board_subject;		// 게시글 제목
	private String userID;				// 사용자 아이디
	private String board_content;		// 게시글 내용
	private Timestamp board_regDate;	// 게시글 작성일자
	private String problem_type1; 		// 문의유형1
	private String problem_type2; 		// 문의유형2
	private String region; 				// 지역
	private String process_status;		// 처리 진행과정	
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
	public String getProblem_type1() {
		return problem_type1;
	}
	public void setProblem_type1(String problem_type1) {
		this.problem_type1 = problem_type1;
	}
	public String getProblem_type2() {
		return problem_type2;
	}
	public void setProblem_type2(String problem_type2) {
		this.problem_type2 = problem_type2;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getProcess_status() {
		return process_status;
	}
	public void setProcess_status(String process_status) {
		this.process_status = process_status;
	}
	@Override
	public String toString() {
		return "BoardDTO [board_bno=" + board_bno + ", board_subject=" + board_subject + ", userID=" + userID
				+ ", board_content=" + board_content + ", board_regDate=" + board_regDate + ", problem_type1="
				+ problem_type1 + ", problem_type2=" + problem_type2 + ", region=" + region + ", process_status="
				+ process_status + "]";
	}
		
	
}// end- public class BoardDTO
