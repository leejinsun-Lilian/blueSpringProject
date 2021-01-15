package com.boss.blueSpring.report.model.vo;

import java.sql.Date;

public class Report {
	private int reportNo; 			// 신고글 번호
	private String reportType;  	// 신고 유형(댓글, 게시판)
	private int boardNo; 			// 신고 대상 글
	private int memberNo; 			// 신고자
	private int reportCategoryNo;   // 신고 유형
	private Date reportCreateDate;  // 신고접수일
	private String reportDeleteFl;  // 신고글 삭제 유무
	
	public Report() {
		// TODO Auto-generated constructor stub
	}

	public Report(int reportNo, String reportType, int boardNo, int memberNo, int reportCategoryNo,
			Date reportCreateDate, String reportDeleteFl) {
		super();
		this.reportNo = reportNo;
		this.reportType = reportType;
		this.boardNo = boardNo;
		this.memberNo = memberNo;
		this.reportCategoryNo = reportCategoryNo;
		this.reportCreateDate = reportCreateDate;
		this.reportDeleteFl = reportDeleteFl;
	}

	public int getReportNo() {
		return reportNo;
	}

	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getReportCategoryNo() {
		return reportCategoryNo;
	}

	public void setReportCategoryNo(int reportCategoryNo) {
		this.reportCategoryNo = reportCategoryNo;
	}

	public Date getReportCreateDate() {
		return reportCreateDate;
	}

	public void setReportCreateDate(Date reportCreateDate) {
		this.reportCreateDate = reportCreateDate;
	}

	public String getReportDeleteFl() {
		return reportDeleteFl;
	}

	public void setReportDeleteFl(String reportDeleteFl) {
		this.reportDeleteFl = reportDeleteFl;
	}

	@Override
	public String toString() {
		return "Report [reportNo=" + reportNo + ", reportType=" + reportType + ", boardNo=" + boardNo + ", memberNo="
				+ memberNo + ", reportCategoryNo=" + reportCategoryNo + ", reportCreateDate=" + reportCreateDate
				+ ", reportDeleteFl=" + reportDeleteFl + "]";
	}
		
}
