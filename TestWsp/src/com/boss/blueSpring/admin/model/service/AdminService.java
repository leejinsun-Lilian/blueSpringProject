package com.boss.blueSpring.admin.model.service;

import static com.boss.blueSpring.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.boss.blueSpring.admin.model.dao.AdminDAO;
import com.boss.blueSpring.board.model.vo.Board;
import com.boss.blueSpring.board.model.vo.PageInfo;
import com.boss.blueSpring.center.model.vo.Center;
import com.boss.blueSpring.challenge.model.vo.Challenge;
import com.boss.blueSpring.report.model.vo.Report;

public class AdminService {
	
	private AdminDAO dao = new AdminDAO();

	
   /***************** 자유게시판관리 : 페이징 처리를 위한 값 계산 Service
    * @param cp
    * @return PageInfo(currentPage, listCount)
    * @throws Exception
    */
	public PageInfo getPageInfo(String cp) throws Exception {

		Connection conn = getConnection();

		int currentPage = cp == null ? 1 : Integer.parseInt(cp);

		int listCount = dao.getListCount(conn);

		close(conn);

		return new PageInfo(currentPage, listCount);
	}

	/** 자유게시판관리 : 게시글 목록 조회 Service
	 * @param pInfo
	 * @return aList
	 * @throws Exception
	 */
	public List<Board> selectAdminList(PageInfo pInfo) throws Exception {
		Connection conn = getConnection();

		List<Board> aList = dao.selectAdminList(conn, pInfo);

		close(conn);

		return aList;
	}

// ******************************************************* 챌린지 관리
	
	public List<Challenge> selectAdminChallList(PageInfo pInfo) throws Exception {

		return null;
	}

// ******************************************************* 신고 목록
	
	   /** 신고 목록 관리 : 페이징 처리를 위한 값 계산 Service
	    * @param cp
	    * @return PageInfo(currentPage, listCount)
	    * @throws Exception
	    */
		public PageInfo getPageInfoReport(String cp) throws Exception {

			Connection conn = getConnection();

			int currentPage = cp == null ? 1 : Integer.parseInt(cp);

			int listCount = dao.getReportListCount(conn);

			close(conn);

			return new PageInfo(currentPage, listCount);
			
		}

	/** 신고 목록 조회 Service
	 * @param pInfo
	 * @return rList
	 * @throws Exception
	 */
	public List<Report> selectReportList(PageInfo pInfo) throws Exception {
		
		Connection conn = getConnection();

		List<Report> rList = dao.selectReportList(conn, pInfo);

		close(conn);

		return rList;
	}

	
	
	
//	******************************************************* 센터
	
	/** 센터 목록 관리 : 페이징 처리를 위한 값 계산 Service
	 * @param cp
	 * @return
	 * @throws Exception
	 */
	public PageInfo getPageInfoCenter(String cp) throws Exception {

		Connection conn = getConnection();

		int currentPage = cp == null ? 1 : Integer.parseInt(cp);

		int listCount = dao.getCenterListCount(conn);

		close(conn);

		return new PageInfo(currentPage, listCount);
	}

	/** 센터 목록 조회 Service
	 * @param pInfo
	 * @return cList
	 * @throws Exception
	 */
	public List<Center> selectCenterList(PageInfo pInfo) throws Exception {

		Connection conn = getConnection();
		
		List<Center> cList = dao.selectCenterList(conn, pInfo);

		close(conn);

		return cList;

	}



	
	
	
	
	
}
