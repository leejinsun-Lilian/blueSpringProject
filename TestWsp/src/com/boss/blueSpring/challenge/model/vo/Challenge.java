package com.boss.blueSpring.challenge.model.vo;

import java.sql.Date;

public class Challenge {
	
	private int chlngNo;			// 챌린지 번호
	private String chlngTitle;		// 챌린지 제목
	private String chlngContent;	// 챌린지 내용
	private Date chlngStartDt;		// 챌린지 시작일
	private Date chlngEndDt;		// 챌린지 종료일
	private int currNumMem;			// 챌린지 현재 참가 인원
	private int accNumMem;			// 챌린지 누적 참가 인원
	private char chlngFl;			// 챌린지 삭제 여부
	private Date chlngCreateDt;		// 챌린지 미션 작성일
	private Date chlngUpdateDt;		// 챌린지 미션 수정일
	private int memberNo;			// 회원번호
	private int chlngCategoryNo;	// 챌린지 카테고리 번호
	private String memberId;		// 회원 아이디

	public Challenge() {
	}

	public Challenge(int chlngNo, String chlngTitle, String chlngContent, Date chlngStartDt, Date chlngEndDt,
			int currNumMem, int accNumMem, char chlngFl, Date chlngCreateDt, Date chlngUpdateDt, int memberNo,
			int chlngCategoryNo, String memberId) {
		super();
		this.chlngNo = chlngNo;
		this.chlngTitle = chlngTitle;
		this.chlngContent = chlngContent;
		this.chlngStartDt = chlngStartDt;
		this.chlngEndDt = chlngEndDt;
		this.currNumMem = currNumMem;
		this.accNumMem = accNumMem;
		this.chlngFl = chlngFl;
		this.chlngCreateDt = chlngCreateDt;
		this.chlngUpdateDt = chlngUpdateDt;
		this.memberNo = memberNo;
		this.chlngCategoryNo = chlngCategoryNo;
		this.memberId = memberId;
	}

	
	// admin 챌린지 조회 용
	// CHLNG_NO, CHLNG_TITLE, MEM_ID, CHLNG_FL
	
	public Challenge(int chlngNo, String chlngTitle, String memberId, char chlngFl) {
		super();
		this.chlngNo = chlngNo;
		this.chlngTitle = chlngTitle;
		this.memberId = memberId;
		this.chlngFl = chlngFl;
	}

	public int getChlngNo() {
		return chlngNo;
	}

	public void setChlngNo(int chlngNo) {
		this.chlngNo = chlngNo;
	}

	public String getChlngTitle() {
		return chlngTitle;
	}

	public void setChlngTitle(String chlngTitle) {
		this.chlngTitle = chlngTitle;
	}

	public String getChlngContent() {
		return chlngContent;
	}

	public void setChlngContent(String chlngContent) {
		this.chlngContent = chlngContent;
	}

	public Date getChlngStartDt() {
		return chlngStartDt;
	}

	public void setChlngStartDt(Date chlngStartDt) {
		this.chlngStartDt = chlngStartDt;
	}

	public Date getChlngEndDt() {
		return chlngEndDt;
	}

	public void setChlngEndDt(Date chlngEndDt) {
		this.chlngEndDt = chlngEndDt;
	}

	public int getCurrNumMem() {
		return currNumMem;
	}

	public void setCurrNumMem(int currNumMem) {
		this.currNumMem = currNumMem;
	}

	public int getAccNumMem() {
		return accNumMem;
	}

	public void setAccNumMem(int accNumMem) {
		this.accNumMem = accNumMem;
	}

	public char getChlngFl() {
		return chlngFl;
	}

	public void setChlngFl(char chlngFl) {
		this.chlngFl = chlngFl;
	}

	public Date getChlngCreateDt() {
		return chlngCreateDt;
	}

	public void setChlngCreateDt(Date chlngCreateDt) {
		this.chlngCreateDt = chlngCreateDt;
	}

	public Date getChlngUpdateDt() {
		return chlngUpdateDt;
	}

	public void setChlngUpdateDt(Date chlngUpdateDt) {
		this.chlngUpdateDt = chlngUpdateDt;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getChlngCategoryNo() {
		return chlngCategoryNo;
	}

	public void setChlngCategoryNo(int chlngCategoryNo) {
		this.chlngCategoryNo = chlngCategoryNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "Challenge [chlngNo=" + chlngNo + ", chlngTitle=" + chlngTitle + ", chlngContent=" + chlngContent
				+ ", chlngStartDt=" + chlngStartDt + ", chlngEndDt=" + chlngEndDt + ", currNumMem=" + currNumMem
				+ ", accNumMem=" + accNumMem + ", chlngFl=" + chlngFl + ", chlngCreateDt=" + chlngCreateDt
				+ ", chlngUpdateDt=" + chlngUpdateDt + ", memberNo=" + memberNo + ", chlngCategoryNo=" + chlngCategoryNo
				+ ", memberId=" + memberId + "]";
	}
	
	
	


	
	

}