package com.boss.blueSpring.search.model.dao;

import static com.boss.blueSpring.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.boss.blueSpring.challenge.model.vo.Challenge;
import com.boss.blueSpring.challenge.model.vo.PageInfo;



public class ChCategorySearchDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rset = null;
	
	
	
	/** 조건을 만족하는 게시글 수 조회 DAO
	 * @param conn
	 * @return listCount
	 * @throws Exception
	 */
	public int getListCount(Connection conn, Map<String, Object> map) throws Exception {
		int listCount = 0;
		
		String query = "SELECT COUNT(*) FROM V_BOARD WHERE BRD_DEL_FL = 'N' AND CATEGORY_NM = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, (String)map.get("chlngCategoryNm"));
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
			
		} finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}



	/** 카테고리로 검색한 목록 조회 DAO
	 * @param conn
	 * @param pInfo
	 * @param map
	 * @return bList
	 * @throws Exception
	 */
	public List<Challenge> searchChallengeList(Connection conn, PageInfo pInfo, Map<String, Object> map) throws Exception {
		List<Challenge> cList = null;
		
		String query = 		
				"SELECT * FROM" + 
				"(SELECT  ROWNUM RNUM, V.* "+
				"FROM " +
				"    (SELECT * FROM V_CHLNG_MISSION_LIST "
				+ "WHERE CHLNG_CATE_NM = ? AND CHLNG_FL = 'N' "
				+ "ORDER BY CHLNG_NO DESC) V ) " + 
				"WHERE RNUM BETWEEN ? AND ?";

		try {
			// SQL 구문 조건절에 대입할 변수 생성
			int startRow = (pInfo.getCurrentPage() - 1) * pInfo.getLimit() + 1;
			int endRow = startRow + pInfo.getLimit() - 1;
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, (String)map.get("chlngCategoryNm"));
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			cList = new ArrayList<Challenge>();
			
			while(rset.next()) {
				
				Challenge challenge = new Challenge();
				challenge.setChlngNo(  	rset.getInt("CHLNG_NO")  );
				challenge.setChlngTitle(  rset.getString("CHLNG_TITLE")  );
				challenge.setChlngStartDt(  rset.getTimestamp ("STR_DT")  );
				challenge.setChlngEndDt(  rset.getTimestamp ("END_DT")  );
				challenge.setLikeCount(  	rset.getInt("LIKE_COUNT")  );
				
				
				cList.add(challenge);
			}
			
		} finally {
			close(rset);
			close(pstmt);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
		}
		
		return cList;
	}
	
	
}
