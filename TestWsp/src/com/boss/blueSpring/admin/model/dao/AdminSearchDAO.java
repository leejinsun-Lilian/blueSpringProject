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

public class AdminSearchDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rset = null;
	
	
	/** 조건을 만족하는 게시글 수 조회 DAO
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


	/** 검색 게시글 목록 조회 DAO
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
	

}
