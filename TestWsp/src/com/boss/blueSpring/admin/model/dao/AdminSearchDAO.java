package com.boss.blueSpring.admin.model.dao;

import static com.boss.blueSpring.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.boss.blueSpring.board.model.vo.Board;
import com.boss.blueSpring.board.model.vo.PageInfo;
import com.boss.blueSpring.center.model.vo.Center;
import com.boss.blueSpring.report.model.vo.Report;

public class AdminSearchDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rset = null;
	
	
	/** (자유게시판 관리) 조건을 만족하는 게시글 수 조회 DAO
	 * @param conn
	 * @param condition
	 * @return listCount
	 * @throws Exception
	 */
	public int getListCount(Connection conn, String condition) throws Exception {
		int listCount = 0;
		
		String query = "SELECT COUNT(*) FROM V_BOARD WHERE " + condition;
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}


	/** (자유게시판 관리) 검색 게시글 목록 조회 DAO
	 * @param conn
	 * @param pInfo
	 * @param condition
	 * @return aList
	 * @throws Exception
	 */
	public List<Board> searchBoardList(Connection conn, PageInfo pInfo, String condition) throws Exception {
		
		List<Board> aList = null;
		
		String query = 
				"SELECT * FROM" + 
				"    (SELECT ROWNUM RNUM , V.*" + 
				"    FROM" + 
				"        (SELECT BRD_NO, BRD_TITLE, MEM_ID, BRD_DEL_FL FROM V_BOARD " + 
				"        WHERE " + condition + 
				"        ORDER BY BRD_NO DESC) V )" + 
				"WHERE RNUM BETWEEN ? AND ?";
		
		try {
			// SQL 구문 조건절에 대입할 변수 생성
			int startRow = (pInfo.getCurrentPage() -1) * pInfo.getLimit() + 1; // ex) 1
			int endRow = startRow + pInfo.getLimit() -1; // ex) 10
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			aList = new ArrayList<Board>();
			
			while(rset.next()) {
				Board board = new Board(
	                		   			rset.getInt("BRD_NO"), 
	                		   			rset.getString("BRD_TITLE"),
	                		   			rset.getString("MEM_ID"),
	                		   			rset.getString("BRD_DEL_FL"));
				
				aList.add(board);
			}
			
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return aList;
	}


	// 신고 **********************************************************************************************
	
	
	
	/** (신고목록 관리) 조건을 만족하는 게시글 수 조회 DAO
	 * @param conn
	 * @param condition
	 * @return listCount
	 * @throws Exception
	 */
	public int getListCountReport(Connection conn, String condition) throws Exception {
		
		int listCount = 0;
		
		String query = "SELECT COUNT(*) FROM V_REPORT WHERE " + condition;
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}
	
	
	/** 신고목록 검색 DAO
	 * @param conn
	 * @param pInfo
	 * @param condition
	 * @return rList
	 * @throws Exception
	 */
	public List<Report> searchReportList(Connection conn, PageInfo pInfo, String condition) throws Exception {
		
		List<Report> rList = null;
		
		String query = 
				"SELECT * FROM " + 
				"    (SELECT ROWNUM RNUM , V.* " + 
				"    FROM " + 
				"        (SELECT REPORT_NO, REPORT_TYPE, BRD_NO, REPORT_CATE_NO, MEM_ID, TARGET_ID FROM V_REPORT " + 
				"        WHERE " + condition + 
				"        ORDER BY REPORT_NO DESC) V ) " + 
				" WHERE RNUM BETWEEN ? AND ?";
		
		try {
			int startRow = (pInfo.getCurrentPage() -1) * pInfo.getLimit() + 1;
			int endRow = startRow + pInfo.getLimit() -1;
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			rList = new ArrayList<Report>();
			
			while(rset.next()) {
				Report report = new Report(
						   				rset.getInt("REPORT_NO"),
						   				rset.getString("REPORT_TYPE"),
						   				rset.getInt("BRD_NO"),
						   				rset.getInt("REPORT_CATE_NO"),
						   				rset.getString("MEM_ID"),
						   				rset.getString("TARGET_ID"));
				rList.add(report);
			}
			
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return rList;
	}
	
	

	// 센터 **********************************************************************************************

	
	
	/** (센터 관리) 조건을 만족하는 게시글 수 조회 DAO
	 * @param conn
	 * @param condition
	 * @return listCount
	 * @throws Exception
	 */
	public int getListCountCenter(Connection conn, String condition) throws Exception {
		
		int listCount = 0;
		
		String query = "SELECT COUNT(*) FROM V_CENTER WHERE " + condition;
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}


	/** 센터목록 검색 DAO
	 * @param conn
	 * @param pInfo
	 * @param condition
	 * @return cList
	 * @throws Exception
	 */
	public List<Center> searchCenterList(Connection conn, PageInfo pInfo, String condition) throws Exception {
		
		List<Center> cList = null;
		
		String query = 
				"SELECT * FROM " + 
				"    (SELECT ROWNUM RNUM , V.* " + 
				"    FROM " + 
				"        (SELECT CENTER_NO, CENTER_CLA, CENTER_AREA1, CENTER_AREA2, CENTER_NM, CENTER_TEL, CENTER_URL, CENTER_ADDR FROM V_CENTER " + 
				"        WHERE " + condition + 
				"        ORDER BY CENTER_NO DESC) V ) " + 
				" WHERE RNUM BETWEEN ? AND ?";
		
		try {
			int startRow = (pInfo.getCurrentPage() -1) * pInfo.getLimit() + 1;
			int endRow = startRow + pInfo.getLimit() -1;
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			cList = new ArrayList<Center>();
			
			while(rset.next()) {
				Center center = new Center(
						rset.getInt("CENTER_NO"), 
						rset.getString("CENTER_CLA"),
						rset.getString("CENTER_AREA1"), 
						rset.getString("CENTER_AREA2"), 
						rset.getString("CENTER_NM"),
						rset.getString("CENTER_TEL"), 
						rset.getString("CENTER_URL"), 
						rset.getString("CENTER_ADDR"));
				cList.add(center);
			}
			
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return cList;
	}

	



	

}
