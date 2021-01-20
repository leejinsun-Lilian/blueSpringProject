package com.boss.blueSpring.challenge.model.dao;

import static com.boss.blueSpring.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.boss.blueSpring.challenge.model.vo.Challenge;
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


	
	
	
	
}
