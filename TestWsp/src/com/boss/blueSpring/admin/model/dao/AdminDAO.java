package com.boss.blueSpring.admin.model.dao;

import static com.boss.blueSpring.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.boss.blueSpring.board.model.dao.BoardDAO;
import com.boss.blueSpring.board.model.vo.Board;
import com.boss.blueSpring.board.model.vo.PageInfo;

public class AdminDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rset = null;
	
	private Properties prop = null;

	
	public AdminDAO() {
		String fileName = BoardDAO.class.getResource("/com/boss/blueSpring/sql/admin/admin-query.xml").getPath();
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(fileName)); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


   /** 자유게시판관리 : 전체 게시글 수 반환 DAO
    * @param conn
    * @return listCount
    * @throws Exception
    */
	public int getListCount(Connection conn) throws Exception {
		
      int listCount = 0;
      
      String query = prop.getProperty("getAdminBoardListCount");
      
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


	
	/** 자유게시판관리 : 게시글 목록 조회 Service
	 * @param conn
	 * @param pInfo
	 * @return aList
	 * @throws Exception
	 */
	public List<Board> selectAdminList(Connection conn, PageInfo pInfo) throws Exception {

		List<Board> aList = null;

		String query = prop.getProperty("selectAdminBoardList");

	      try {
	          // SQL 구문 조건절에 대입할 변수 생성
	          int startRow = (pInfo.getCurrentPage() - 1) * pInfo.getLimit() + 1;
	          int endRow = startRow + pInfo.getLimit() -  1;
	          
	          pstmt = conn.prepareStatement(query);
	          
	          pstmt.setInt(1, startRow);
	          pstmt.setInt(2,  endRow);
	          
	          rset = pstmt.executeQuery();
	          
	          aList = new ArrayList<Board>();
	          
	             while(rset.next()) {
	                   Board board = new Board(
	                		   			rset.getInt("BRD_NO"), 
	                		   			rset.getString("BRD_TITLE"),
	                		   			rset.getString("MEMBER_ID"),
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
