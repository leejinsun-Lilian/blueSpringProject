package com.boss.blueSpring.challengecrtfd.model.vo;

import java.sql.Date;

public class ChallengeCrtfd {
	
	private int chlngBoardNo;			// 챌린지 인증 게시글 번호
	private Date chlngBoardCrtDt;		// 챌린지 인증글 작성일
	private char chlngBoardDelFl;		// 챌린지 인증글 삭제여부
	private int chlngBoardViews;		// 챌린지 인증글 조회수
	private int memberNo;				// 회원번호
	private int chlngNo;				// 챌린지 번호
	private String memberId;			// 회원아이디
	private String chlngBoardTitle;		// 챌린지 인증글 제목
	private String chlngBoardContent;	// 챌린지 인증글 내용
	private String chlngCateNm;			// 챌린지 카테고리명
	private String memNickname; //작성자 닉네임

	public ChallengeCrtfd() {
		
	}
	
	public ChallengeCrtfd(int chlngBoardNo, Date chlngBoardCrtDt, char chlngBoardDelFl, int chlngBoardViews,
			int memberNo, int chlngNo, String memberId, String chlngBoardTitle, String chlngBoardContent,
			String chlngCateNm, String memNickname) {
		super();
		this.chlngBoardNo = chlngBoardNo;
		this.chlngBoardCrtDt = chlngBoardCrtDt;
		this.chlngBoardDelFl = chlngBoardDelFl;
		this.chlngBoardViews = chlngBoardViews;
		this.memberNo = memberNo;
		this.chlngNo = chlngNo;
		this.memberId = memberId;
		this.chlngBoardTitle = chlngBoardTitle;
		this.chlngBoardContent = chlngBoardContent;
		this.chlngCateNm = chlngCateNm;
		this.memNickname = memNickname;
	}




	// admin 챌린지 인증 게시글 목록 조회용
	public ChallengeCrtfd(int chlngNo, int chlngBoardNo, String chlngBoardTitle, String memberId, char chlngBoardDelFl) {
		super();
		this.chlngNo = chlngNo;
		this.chlngBoardNo = chlngBoardNo;
		this.chlngBoardTitle = chlngBoardTitle;
		this.memberId = memberId;
		this.chlngBoardDelFl = chlngBoardDelFl;
	}


	public int getChlngBoardNo() {
		return chlngBoardNo;
	}

	public void setChlngBoardNo(int chlngBoardNo) {
		this.chlngBoardNo = chlngBoardNo;
	}

	public Date getChlngBoardCrtDt() {
		return chlngBoardCrtDt;
	}

	public void setChlngBoardCrtDt(Date chlngBoardCrtDt) {
		this.chlngBoardCrtDt = chlngBoardCrtDt;
	}

	public char getChlngBoardDelFl() {
		return chlngBoardDelFl;
	}

	public void setChlngBoardDelFl(char chlngBoardDelFl) {
		this.chlngBoardDelFl = chlngBoardDelFl;
	}

	public int getChlngBoardViews() {
		return chlngBoardViews;
	}

	public void setChlngBoardViews(int chlngBoardViews) {
		this.chlngBoardViews = chlngBoardViews;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getChlngNo() {
		return chlngNo;
	}

	public void setChlngNo(int chlngNo) {
		this.chlngNo = chlngNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getChlngBoardTitle() {
		return chlngBoardTitle;
	}

	public void setChlngBoardTitle(String chlngBoardTitle) {
		this.chlngBoardTitle = chlngBoardTitle;
	}

	public String getChlngBoardContent() {
		return chlngBoardContent;
	}

	public void setChlngBoardContent(String chlngBoardContent) {
		this.chlngBoardContent = chlngBoardContent;
	}

	public String getChlngCateNm() {
		return chlngCateNm;
	}

	public void setChlngCateNm(String chlngCateNm) {
		this.chlngCateNm = chlngCateNm;
	}

	public String getMemNickname() {
		return memNickname;
	}

	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}

	@Override
	public String toString() {
		return "ChallengeCrtfd [chlngBoardNo=" + chlngBoardNo + ", chlngBoardCrtDt=" + chlngBoardCrtDt
				+ ", chlngBoardDelFl=" + chlngBoardDelFl + ", chlngBoardViews=" + chlngBoardViews + ", memberNo="
				+ memberNo + ", chlngNo=" + chlngNo + ", memberId=" + memberId + ", chlngBoardTitle=" + chlngBoardTitle
				+ ", chlngBoardContent=" + chlngBoardContent + ", chlngCateNm=" + chlngCateNm + ", memNickname="
				+ memNickname + "]";
	}




	

	
	
}
