package com.boss.blueSpring.board.model.vo;

import java.sql.Timestamp;

public class Board {
	// DB에서 만든 V_BOARD의 모양 그대로 필드 선언
	private int boardNo;
	private String boardTitle;
	private Timestamp boardCreateDate;
	private String boardContent;
	private int readCount;
	private String boardStatus;
	private Timestamp boardModifyDate;
	private String memberId;
	private String categoryName;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

	
	// 게시글 목록 조회용 생성자
	public Board(int boardNo, String boardTitle, String memberId, int readCount, String categoryName,
			Timestamp boardCreateDate) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.memberId = memberId;
		this.readCount = readCount;
		this.categoryName = categoryName;
		this.boardCreateDate = boardCreateDate;
	}

	// admin 자유게시판 관리 (게시글 조회)
	public Board(int boardNo, String boardTitle, String memberId, String boardStatus) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.memberId = memberId;
		this.boardStatus = boardStatus;

	}


	public Board(int boardNo, String boardTitle, String boardContent, String memberId, int readCount,
			String categoryName, Timestamp boardCreateDate, Timestamp boardModifyDate, String boardStatus) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.memberId = memberId;
		this.readCount = readCount;
		this.categoryName = categoryName;
		this.boardCreateDate = boardCreateDate;
		this.boardModifyDate = boardModifyDate;
		this.boardStatus = boardStatus;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Timestamp getBoardCreateDate() {
		return boardCreateDate;
	}

	public void setBoardCreateDate(Timestamp boardCreateDate) {
		this.boardCreateDate = boardCreateDate;
	}

	public Timestamp getBoardModifyDate() {
		return boardModifyDate;
	}

	public void setBoardModifyDate(Timestamp boardModifyDate) {
		this.boardModifyDate = boardModifyDate;
	}

	public String getBoardStatus() {
		return boardStatus;
	}

	public void setBoardStatus(String boardStatus) {
		this.boardStatus = boardStatus;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", memberId=" + memberId + ", readCount=" + readCount + ", categoryName=" + categoryName
				+ ", boardCreateDate=" + boardCreateDate + ", boardModifyDate=" + boardModifyDate + ", boardStatus="
				+ boardStatus + "]";
	}
	
}
