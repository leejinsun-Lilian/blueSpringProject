package com.boss.blueSpring.notice.model.dao;

import static com.boss.blueSpring.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.boss.blueSpring.notice.model.vo.Notice;
import com.boss.blueSpring.notice.model.vo.PageInfo;;

public class NoticeDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rset = null;
	
	Properties prop = null;
	
	public NoticeDAO() {
		String fileName = NoticeDAO.class.getResource("/com/boss/blueSpring/sql/notice/notice-query.xml").getPath();
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 전체 공지글 수 반환 DAO
	 * @param conn
	 * @return listCount
	 * @throws Exception
	 */
	public int getListCount(Connection conn) throws Exception{
		int listCount = 0;
		
		String query = prop.getProperty("getListCount");
		
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
	
	
	/** 공지사항 목록 조회
	 * @param conn
	 * @return list
	 * @throws Exception
	 */
	public List<Notice> selectList(Connection conn, PageInfo pInfo) throws Exception{
		List<Notice> list = null;
		
		String query = prop.getProperty("selectList");
		
		try {
			// SQL 구문 조건절에 대입할 변수 생성
			int startRow = (pInfo.getCurrentPage() - 1) * pInfo.getLimit() + 1;    // 시작은 1부터 
			int endRow = startRow + pInfo.getLimit() - 1; // 10
						
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			// 오류 없을시 ArrayList 생성
			list = new ArrayList<Notice>();
			
			while(rset.next()) {
				
				Notice notice = new Notice();
				notice.setNoticeNo(  	rset.getInt("NOTICE_NO")  );
				notice.setNoticeTitle(  rset.getString("NOTICE_TITLE")  );
				notice.setMemberId(  	rset.getString("MEM_ID")  );
				notice.setNoticeViews(  	rset.getInt("NOTICE_VIEWS")  );
				notice.setNoticeCrtDt(  rset.getDate("NOTICE_CRT_DT")  );
				
				list.add(notice);
				
			}
			
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}

	
	/** 공지글 상세조회 DAO
	 * @param conn
	 * @param noticeNo
	 * @return notice
	 * @throws Exception
	 */
	public Notice selectNotice(Connection conn, int noticeNo) throws Exception{
		Notice notice = null;
		
		String query = prop.getProperty("selectNotice");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, noticeNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				notice = new Notice();
				
				notice.setNoticeNo( rset.getInt("NOTICE_NO")   );
				notice.setNoticeTitle(  rset.getString("NOTICE_TITLE") );
				notice.setNoticeContent( rset.getString("NOTICE_CONTENT") );
				notice.setMemberId( rset.getString("MEMBER_ID") );
				notice.setNoticeViews( rset.getInt("NOTICE_VIEWS"));
				notice.setNoticeCrtDt( rset.getTimestamp("NOTICE_CRT_DT"));
				notice.setNoticeUpdateDt( rset.getTimestamp("NOTICE_UPDATE_DT"));
				
			}
			
			
			
		} finally {
			close(rset);
			close(pstmt);
		}

		
		
		return notice;
	}


	/** 게시글 조회수 증가 DAO
	 * @param conn
	 * @param boardNo
	 * @return result
	 */
	public int increaseReadCount(Connection conn, int boardNo) throws Exception{
		int result = 0;
		
		String query = prop.getProperty("increaseReadCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,	boardNo);
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}

		return result;
	}

	
	
	
	
	
	
}
