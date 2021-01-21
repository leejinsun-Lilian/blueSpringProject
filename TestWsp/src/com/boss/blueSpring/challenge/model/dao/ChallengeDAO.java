package com.boss.blueSpring.challenge.model.dao;

import static com.boss.blueSpring.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.boss.blueSpring.challenge.model.vo.Challenge;
import com.boss.blueSpring.challenge.model.vo.Like;
import com.boss.blueSpring.challenge.model.vo.PageInfo;

public class ChallengeDAO {

	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rset = null;
	
	Properties prop = null;
	
	public ChallengeDAO() {
		String fileName = ChallengeDAO.class.getResource("/com/boss/blueSpring/sql/challenge/challenge-query.xml").getPath();
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/** 전체 챌린지 수 반환 DAO
	 * @param conn
	 * @return listCount
	 * @throws Exception
	 */
	public int getChallengeCount(Connection conn) throws Exception{
		int listCount = 0;
		
		String query = prop.getProperty("getChallengeCount");
		
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
	 * @param orderBy
	 * @return list
	 * @throws Exception
	 */
	public List<Challenge> selectList(Connection conn, PageInfo pInfo, String orderBy) throws Exception{
		List<Challenge> list = null;
		
		//String query = prop.getProperty("selectList");         //+ end
		String query = "SELECT* FROM " + 
						"	(SELECT ROWNUM RNUM, V.* " + 
						"	FROM\r\n" + 
						"		(SELECT * FROM V_CHLNG_MISSION_LIST WHERE CHLNG_FL = 'N' " +
				    	" ORDER BY " + orderBy + " CHLNG_NO DESC) V ) " + 
						"WHERE RNUM BETWEEN ? AND ? " 
						;
		try {
			// SQL 구문 조건절에 대입할 변수 생성
			int startRow = (pInfo.getCurrentPage() - 1) * pInfo.getLimit() + 1;    // 시작은 1부터 
			int endRow = startRow + pInfo.getLimit() - 1; // 9?????????
						
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			// 오류 없을시 ArrayList 생성
			list = new ArrayList<Challenge>();
			
			while(rset.next()) {
				
				Challenge challenge = new Challenge();
				challenge.setChlngNo(  	rset.getInt("CHLNG_NO")  );
				challenge.setChlngTitle(  rset.getString("CHLNG_TITLE")  );
				challenge.setChlngStartDt(  rset.getTimestamp ("STR_DT")  );
				challenge.setChlngEndDt(  rset.getTimestamp ("END_DT")  );
				challenge.setLikeCount(  	rset.getInt("LIKE_COUNT")  );
				challenge.setchlngCateNm(  	rset.getString("CHLNG_CATE_NM")  );
				
				
				list.add(challenge);
				
			}
			
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}


	/** 챌린지 상세 조회 DAO
	 * @param conn
	 * @param challengeNo
	 * @return challenge
	 * @throws Exception
	 */
	public Challenge selectChallenge(Connection conn, int challengeNo) throws Exception{
		Challenge challenge = null;
		
		String query = prop.getProperty("selectChallenge");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, challengeNo);
			
			rset = pstmt.executeQuery();
			
			//챌린지 번호 , 제목, 내용, 작성자(닉네임), 시작일, 종료일, 카테고리, 좋아요
			if(rset.next()) {
				challenge = new Challenge();
				
				challenge.setChlngNo(rset.getInt("CHLNG_NO"));
				challenge.setChlngTitle(rset.getString("CHLNG_TITLE"));
				challenge.setChlngContent(rset.getString("CHLNG_CONTENT"));
				challenge.setMemNickname(rset.getString("MEM_NICKNAME"));
				challenge.setChlngStartDt(rset.getTimestamp("STR_DT"));
				challenge.setChlngEndDt(rset.getTimestamp("END_DT"));
				challenge.setchlngCateNm(rset.getString("CHLNG_CATE_NM"));
				challenge.setLikeCount(rset.getInt("LIKE_COUNT"));
				challenge.setMemberId(rset.getString("MEM_ID"));
			}
			
			
			
		} finally {
			close(rset);
			close(pstmt);
	
		}
		return challenge;
	}


//	/** 챌린지 좋아요 가져오기DAO
//	 * @param conn
//	 * @param challengeNo
//	 * @param memberNo
//	 * @return likeInfo
//	 * @throws Exception
//	 */
//	public Like selectLike(Connection conn, int challengeNo, int memberNo) throws Exception{
//
//		Like likeInfo = null;
//		
//		String query = "SELECT * FROM CHALLENGE_LIKES WHERE CHLNG_NO = ? AND MEM_NO = ?";
//		
//		try {
//		
//			pstmt = conn.prepareStatement(query);
//			
//			pstmt.setInt(1, challengeNo);
//			pstmt.setInt(2, memberNo);
//			
//			rset = pstmt.executeQuery();
//			
//			likeInfo = new Like();
//			
//			if(rset.next()) {
//				Like like = new Like();
//				
//				like.setChallengeNo(rset.getInt("CHLNG_NO"));
//				like.setMemberNo(rset.getInt("MEM_NO"));
//				
//				likeInfo = like;
//			}
//			
//			
//		} finally {
//			close(rset);
//			close(pstmt);
//		}
//		
//		return likeInfo;
//	}


	
	
	
	
}
