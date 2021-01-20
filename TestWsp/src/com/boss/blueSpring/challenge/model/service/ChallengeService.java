package com.boss.blueSpring.challenge.model.service;

import static com.boss.blueSpring.common.JDBCTemplate.close;
import static com.boss.blueSpring.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.boss.blueSpring.challenge.model.dao.ChallengeDAO;
import com.boss.blueSpring.challenge.model.vo.Challenge;
import com.boss.blueSpring.challenge.model.vo.PageInfo;
import com.boss.blueSpring.notice.model.vo.Notice;

public class ChallengeService {
	
	private ChallengeDAO dao = new ChallengeDAO();
	
	/** 페이징 처리 Service
	 * @param cp
	 * @return pInfo
	 * @throws Exception
	 */
	public PageInfo getPageInfo(String cp) throws Exception{
		Connection conn = getConnection();
		
		// cp가 null일 경우
		int currentPage = cp == null ? 1 : Integer.parseInt(cp);
									// t          f
		
		//DB에서 전체 게시글 수를 조회
		int listCount = dao.getChallengeCount(conn);
		
		close(conn);
		
		// 얻어온 현재 페이지와 DB에서 조회한 전체 게시글 수를 이용하여
		// PageInfo 객체를 생성
		return new PageInfo(currentPage, listCount);
		
	}

	/** 챌린지 목록 조회
	 * @param pInfo
	 * @param sort
	 * @return list
	 * @throws Exception
	 */
	public List<Challenge> selectList(PageInfo pInfo, String sort) throws Exception{
		Connection conn = getConnection();
		
		 sort = sort == null ? "" : sort;
		
		 String orderBy = null;
		 //String end = null;
		 
		if(sort.equals("like")) {
			orderBy = " LIKE_COUNT DESC, ";
		}else {
			orderBy = "";
		}
		
//		if(cn != null) {
//			end = "AND CHLNG_CATE_NM = " + "'" + cn + "'";
//		}
		List<Challenge> list = dao.selectList(conn, pInfo, orderBy);   //, end
		
		
		close(conn);
		return list;
	}

	public List<Challenge> selectList1(PageInfo pInfo, String sort) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
