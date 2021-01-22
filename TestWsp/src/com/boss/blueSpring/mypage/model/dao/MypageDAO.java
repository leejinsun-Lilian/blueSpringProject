package com.boss.blueSpring.mypage.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.boss.blueSpring.common.JDBCTemplate.*;

import com.boss.blueSpring.board.model.vo.Board;
import com.boss.blueSpring.board.model.vo.PageInfo;
import com.boss.blueSpring.comment.model.vo.Comment;
import com.boss.blueSpring.member.model.dao.MemberDAO;
import com.boss.blueSpring.member.model.vo.Member;

public class MypageDAO {

	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rset = null;
	private Properties prop = null;
	
	public MypageDAO() {
		try {
			String filePath
			= MemberDAO.class.getResource("/com/boss/blueSpring/sql/mypage/mypage-query.xml").getPath();
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**  내 정보 수정 확인용 비밀번호 DAO
	 * @param conn
	 * @param memberNo
	 * @param pwd
	 * @return result
	 * @throws Exception
	 */
	public int myInfoPwCheck(Connection conn, int memberNo, String pwd) throws Exception {
		int result = 0;
		String query = prop.getProperty("myInfoPwCheck");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, pwd);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	/** 내 정보 수정 - 비밀번호 변경 DAO
	 * @param conn
	 * @param newPw
	 * @param memNo
	 * @return result
	 * @throws Exception
	 */
	public int changePw(Connection conn, String newPw, int memNo) throws Exception{
		int result = 0;
		
		String query = prop.getProperty("changePw");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newPw);
			pstmt.setInt(2, memNo);
			
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/** 내 정보 수정 DAO
	 * @param conn
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(Connection conn, Member member) throws Exception{
		int result = 0;
		
		String query = prop.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberNickname());
			pstmt.setString(2, member.getMemberPhone());
			pstmt.setString(3, member.getMemberAddr());
			pstmt.setInt(4, member.getMemberNo());
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/** 닉네임 중복 체크 DAO
	 * @param conn
	 * @param nickname
	 * @return result
	 * @throws Exception
	 */
	public int nicknameDubCheck(Connection conn, String nickname) throws Exception {
		int result = 0;
		String query = prop.getProperty("nicknameDupCheck");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, nickname);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	/** 회원 탈퇴 DAO
	 * @param conn
	 * @param memNo
	 * @return result
	 * @throws Exception
	 */
	public int updateStatus(Connection conn, int memNo) throws Exception {
		int result = 0;
		String query = prop.getProperty("updateStatus");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memNo);
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/** 페이징 처리를 위한 값 계산 DAO
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int getListCount(Connection conn, String memId) throws Exception {
		int result = 0;
		
		String query = prop.getProperty("getListCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
	
	/** 게시글 목록 조회 DAO
	 * @param conn
	 * @param pInfo
	 * @param memId 
	 * @return bList
	 * @throws Exception
	 */
	public List<Board> selectBoardList(Connection conn, PageInfo pInfo, String cn, String memId) throws Exception {
		
		List<Board> bList = null;
		
		String query = prop.getProperty("selectBoardList");
		
		try {
			int startRow = (pInfo.getCurrentPage() - 1) * pInfo.getLimit() + 1;
			int endRow = startRow + pInfo.getLimit() - 1;
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			pstmt.setString(1, memId);
			
			rset = pstmt.executeQuery();
			
			bList = new ArrayList<Board>();
			
			while(rset.next()) {
				Board board = new Board(rset.getInt("BRD_NO"), 
						rset.getString("BRD_TITLE"),
						rset.getString("MEM_ID"), 
						rset.getInt("BRD_VIEWS"),
						rset.getString("CATEGORY_NM"), 
						rset.getTimestamp("BRD_CRT_DT"),
						rset.getInt("LIKES"));
				bList.add(board);
			}
			
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return bList;
	}

	/** 댓글 목록 DAO
	 * @param conn
	 * @param parentBoardNo
	 * @param memId
	 * @return cList
	 * @throws Exception
	 */
	public List<Comment> selectList(Connection conn,PageInfo pInfo, String cn, String memId) throws Exception{
		List<Comment> cList = null;
		
		String query = prop.getProperty("selectList");
		
		try {
			int startRow = (pInfo.getCurrentPage() - 1) * pInfo.getLimit() + 1;
			int endRow = startRow + pInfo.getLimit() - 1;
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			pstmt.setString(3, memId);
			
			rset = pstmt.executeQuery();
			
			cList = new ArrayList<Comment>();
			

			
			while(rset.next()) {
				Comment comment = new Comment(rset.getInt("COM_NO"), 
											  rset.getString("COM_CONTENT"),
											  rset.getTimestamp("COM_CRT_DT"),
											  rset.getInt("BRD_NO"), 
											  rset.getString("MEM_ID"), 
											  rset.getString("COM_DEL_FL"));
				cList.add(comment);
			}
			
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return cList;
	}

	/** 댓글 페이징 처리를 위한 값 계산 DAO
	 * @param conn
	 * @param memId
	 * @return result
	 * @throws Exception
	 */
	public int getCommentPageInfo(Connection conn, String memId) throws Exception{
		int result = 0;
		
		String query = prop.getProperty("getCommentListCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}


}
