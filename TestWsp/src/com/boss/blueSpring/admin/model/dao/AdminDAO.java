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
import com.boss.blueSpring.center.model.vo.Center;
import com.boss.blueSpring.report.model.vo.Report;

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

	// 자유게시판 **********************************
	
	
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


	/** 자유게시판관리 : 게시글 목록 조회 DAO
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

	
//	신고목록 게시판 ***********************************
	
	   /** 신고목록관리 : 전체 게시글 수 반환 DAO
	    * @param conn
	    * @return listCount
	    * @throws Exception
	    */
		public int getReportListCount(Connection conn) throws Exception {
			
	      int listCount = 0;
	      
	      String query = prop.getProperty("getReportListCount");
	      
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
	
	/** 신고 목록 조회 DAO
	 * @param conn
	 * @param pInfo
	 * @return rList
	 * @throws Exception
	 */
	public List<Report> selectReportList(Connection conn, PageInfo pInfo) throws Exception {
		
		List<Report> rList = null;
		
		String query = prop.getProperty("selectReportList");
		
		try {
	          int startRow = (pInfo.getCurrentPage() - 1) * pInfo.getLimit() + 1;
	          int endRow = startRow + pInfo.getLimit() -  1;
	          
	          pstmt = conn.prepareStatement(query);
	          
	          pstmt.setInt(1, startRow);
	          pstmt.setInt(2,  endRow);
	          
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
	
	
//	센터 ***********************************
	
	
	 /** 센터관리 : 전체 게시글 수 반환 DAO
	    * @param conn
	    * @return listCount
	    * @throws Exception	
	    */
	public int getCenterListCount(Connection conn) throws Exception {

		int listCount = 0;

		String query = prop.getProperty("getCenterListCount");

		try {
			stmt = conn.createStatement();

			rset = stmt.executeQuery(query);

			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}

	
	/** 센터 목록 조회 DAO
	 * @param conn
	 * @param pInfo
	 * @return cList
	 * @throws Exception
	 */
	public List<Center> selectCenterList(Connection conn, PageInfo pInfo) throws Exception {
		List<Center> cList = null;

		String query = prop.getProperty("selectCenterList");

		try {
			int startRow = (pInfo.getCurrentPage() - 1) * pInfo.getLimit() + 1;
			int endRow = startRow + pInfo.getLimit() - 1;

			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			cList = new ArrayList<Center>();

			while (rset.next()) {
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
