package com.boss.blueSpring.admin.model.service;

import static com.boss.blueSpring.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.boss.blueSpring.admin.model.dao.AdminDAO;
import com.boss.blueSpring.board.model.vo.Board;
import com.boss.blueSpring.board.model.vo.PageInfo;

public class AdminService {
	
	private AdminDAO dao = new AdminDAO();

	
	
   /** 자유게시판관리 : 페이징 처리를 위한 값 계산 Service
    * @param cp
    * @return PageInfo(currentPage, listCount)
    * @throws Exception
    */
	public PageInfo getPageInfo(String cp) throws Exception {

		Connection conn = getConnection();

		// cp가 null일 경우
		// 주소창에 보여지는 ?cp=n 부분을 정함
		int currentPage = cp == null ? 1 : Integer.parseInt(cp);

		// DB에서 전체 게시글 수를 조회하여 반환 받기
		int listCount = dao.getListCount(conn);

		close(conn);

		// 얻어온 현재 페이지와, DB에서 조회한 전체 게시글 수를 이용하여
		// PageInfo 객체 생성
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

	
	
	
	
	
}
