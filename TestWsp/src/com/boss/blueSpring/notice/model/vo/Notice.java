package com.boss.blueSpring.notice.model.vo;

import java.sql.Date;

public class Notice {

	private int noticeNo; // 공지글 번호
	private String noticeTitle; // 공지글 제목
	private Date noticeCrtDt; // 작성일
	private String noticeContent; //공지글 내용
	private String noticeDelFl; // 삭제여부(N,Y)
	private Date noticeUpdateDt; // 수정날짜
	private String memberId; // 작성자 아이디
	private int noticeViews; //조회수
	
	public Notice() {}

	
	
	public Notice(int noticeNo, String noticeTitle, Date noticeCrtDt, String noticeContent, String noticeDelFl,
			Date noticeUpdateDt, String memberId, int noticeViews) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeCrtDt = noticeCrtDt;
		this.noticeContent = noticeContent;
		this.noticeDelFl = noticeDelFl;
		this.noticeUpdateDt = noticeUpdateDt;
		this.memberId = memberId;
		this.noticeViews = noticeViews;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public Date getNoticeCrtDt() {
		return noticeCrtDt;
	}

	public void setNoticeCrtDt(Date noticeCrtDt) {
		this.noticeCrtDt = noticeCrtDt;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeDelFl() {
		return noticeDelFl;
	}

	public void setNoticeDelFl(String noticeDelFl) {
		this.noticeDelFl = noticeDelFl;
	}

	public Date getNoticeUpdateDt() {
		return noticeUpdateDt;
	}

	public void setNoticeUpdateDt(Date noticeUpdateDt) {
		this.noticeUpdateDt = noticeUpdateDt;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getNoticeViews() {
		return noticeViews;
	}

	public void setNoticeViews(int noticeViews) {
		this.noticeViews = noticeViews;
	}

	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeCrtDt=" + noticeCrtDt
				+ ", noticeContent=" + noticeContent + ", noticeDelFl=" + noticeDelFl + ", noticeUpdateDt="
				+ noticeUpdateDt + ", memberId=" + memberId + ", noticeViews=" + noticeViews + "]";
	}

	
	
}
