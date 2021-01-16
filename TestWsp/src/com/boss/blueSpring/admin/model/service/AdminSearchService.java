package com.boss.blueSpring.admin.model.service;

import static com.boss.blueSpring.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.boss.blueSpring.admin.model.dao.AdminSearchDAO;
import com.boss.blueSpring.board.model.vo.Board;
import com.boss.blueSpring.board.model.vo.PageInfo;
import com.boss.blueSpring.center.model.vo.Center;
import com.boss.blueSpring.report.model.vo.Report;

public class AdminSearchService {
	
	private AdminSearchDAO dao = new AdminSearchDAO();

	/** 검색 내용이 포함된 페이징 처리 정보 생성 Service (자유게시판)
	 * @param map
	 * @return pInfo
	 * @throws Exception
	 */
	public PageInfo getPageInfo(Map<String, Object> map) throws Exception {
		
		Connection conn = getConnection();

		// 얻어온 파라미터 cp가 null이면 1, 아니면 int형으로 파싱
		map.put("currentPage", 
				( map.get("currentPage") == null) ? 1 : Integer.parseInt((String)map.get("currentPage")) );
		
		// 검색 조건에 따른 SQL 조건문을 조합하는 메소드 호출
		String condition = createCondition(map);
		
		// DB에서 조건을 만족하는 게시글의 수를 조회하기
		int listCount = dao.getListCount(conn, condition);
		
		// 커넥션 반환
		close(conn);
		
		// PageInfo 객체를 생성하여 반환
		return new PageInfo( (int)map.get("currentPage"), listCount);
		
	}

	
	/** 검색 조건에 따라 SQL에 사용될 조건문을 조합하는 메소드 (자유게시판)
	 * @param map
	 * @return
	 */
	private String createCondition(Map<String, Object> map) {
		
		String condition = null;
		
		String searchKey = (String)map.get("searchKey");
		String searchValue = (String)map.get("searchValue");
		
		// 검색 조건 (searchKey)에 따라 SQL 조합
		switch(searchKey) {
		case "no" : 
			condition = " BRD_NO = " + searchValue;
			break;

		case "title" : 
			condition = " BRD_TITLE LIKE '%' || '" + searchValue + "' || '%' ";
			break;
			
		case "writer" : 
			condition = " MEM_ID LIKE '%' || '" + searchValue + "' || '%' ";
			break;

		case "status" : 
			condition = " BRD_DEL_FL = " + "'" + searchValue + "'";                    
			
			break;
			
		}
		
		return condition;
		
	}
	
	/** 검색 게시글 목록 리스트 조회 Service (자유게시판)
	 * @param map
	 * @param pInfo 
	 * @return aList
	 * @throws Exception
	 */
	public List<Board> searchBoardList(Map<String, Object> map, PageInfo pInfo) throws Exception {
		Connection conn = getConnection();
		
		String condition = createCondition(map);
		
		List<Board> aList = dao.searchBoardList(conn, pInfo, condition);
		
		close(conn);
		
		return aList;
		
	}

// 신고 ***************************************************************************************************
	
	/** 검색 내용이 포함된 페이징 처리 정보 생성 Service (신고목록)
	 * @param map
	 * @return pInfo
	 * @throws Exception
	 */
	public PageInfo getPageInfoReport(Map<String, Object> map) throws Exception {
		
		Connection conn = getConnection();

		map.put("currentPage", 
				( map.get("currentPage") == null) ? 1 : Integer.parseInt((String)map.get("currentPage")) );
		
		String condition = createReportCondition(map);
		
		int listCount = dao.getListCountReport(conn, condition);
		
		close(conn);
		
		return new PageInfo( (int)map.get("currentPage"), listCount);
	}
	
	/** 검색 조건에 따라 SQL에 사용될 조건문을 조합하는 메소드 (신고 목록)
	 * @param map
	 * @return
	 */
	private String createReportCondition(Map<String, Object> map) {
		
		String condition = null;
		
		String searchKey = (String)map.get("searchKey");
		String searchValue = (String)map.get("searchValue");
		
		switch(searchKey) {
		case "reportNo" : 
			condition = "REPORT_NO = " + searchValue;
			break;

		case "reportType" : 
			condition = "REPORT_TYPE LIKE '%' || '" + searchValue + "' || '%' ";
			break;

		case "brdNo" : 
			condition = "BRD_NO = " + searchValue;                    
			break;
		}
		
		return condition;
	}


	/** 신고목록 검색 Service
	 * @param map
	 * @param pInfo
	 * @return rList;
	 * @throws Exception
	 */
	public List<Report> searchReportList(Map<String, Object> map, PageInfo pInfo) throws Exception {
		Connection conn = getConnection();
		
		String condition = createReportCondition(map);
		
		List<Report> rList = dao.searchReportList(conn, pInfo, condition);
		
		close(conn);
		
		return rList;
	}

	// 센터 ***************************************************************************************************
	
	
	/** 센터 : 검색 내용이 포함된 페이징 처리 정보 생성 Service
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public PageInfo getPageInfoCenter(Map<String, Object> map) throws Exception {
		
		Connection conn = getConnection();

		map.put("currentPage", 
				( map.get("currentPage") == null) ? 1 : Integer.parseInt((String)map.get("currentPage")) );
		
		String condition = createCenterCondition(map);
		
		int listCount = dao.getListCountCenter(conn, condition);
		
		close(conn);
		
		return new PageInfo( (int)map.get("currentPage"), listCount);
		
		
		
		
	}

	/** 검색 조건에 따라 SQL에 사용될 조건문을 조합하는 메소드 (센터)
	 * @param map
	 * @return
	 */
	private String createCenterCondition(Map<String, Object> map) throws Exception {
		
		String condition = null;
		
		String searchKey = (String)map.get("searchKey");
		String searchValue = (String)map.get("searchValue");
		
		switch(searchKey) {
		case "centerNo" : 
			condition = " CENTER_NO = " + searchValue;
			break;

		case "centerCla" : 
			condition = " CENTER_CLA LIKE '%' || '" + searchValue + "' || '%' ";
			break;
			
		case "centerArea1" : 
			condition = " CENTER_AREA1 LIKE '%' || '" + searchValue + "' || '%' ";
			break;

		case "centerArea2" : 
			condition = " CENTER_AREA2 LIKE '%' || '" + searchValue + "' || '%' ";
			break;

		case "centerNm" : 
			condition = " CENTER_NM LIKE '%' || '" + searchValue + "' || '%' ";
			break;
			
		}
		
		return condition;
		
	}


	/** 센터 목록 검색 Service
	 * @param map
	 * @param pInfo
	 * @return cList;
	 * @throws Exception
	 */
	public List<Center> searchCenterList(Map<String, Object> map, PageInfo pInfo) throws Exception {
		
		Connection conn = getConnection();
		
		String condition = createCenterCondition(map);
		
		List<Center> cList = dao.searchCenterList(conn, pInfo, condition);
		
		close(conn);
		
		return cList;
	}
	
	
	
	

}
