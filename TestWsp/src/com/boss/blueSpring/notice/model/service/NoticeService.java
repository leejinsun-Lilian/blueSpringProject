package com.boss.blueSpring.notice.model.service;

import static com.boss.blueSpring.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.boss.blueSpring.notice.model.dao.NoticeDAO;
import com.boss.blueSpring.notice.model.vo.Notice;
import com.boss.blueSpring.notice.model.vo.PageInfo;

public class NoticeService {

	private NoticeDAO dao = new NoticeDAO();

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
		int listCount = dao.getListCount(conn);
		
		close(conn);
		
		// 얻어온 현재 페이지와 DB에서 조회한 전체 게시글 수를 이용하여
		// PageInfo 객체를 생성
		return new PageInfo(currentPage, listCount);
		
	}
	
	/** 공지사항 목록 조회
	 * @return list
	 * @throws Exception
	 */
	public List<Notice> selectList(PageInfo pInfo) throws Exception{
		Connection conn = getConnection();
		
		List<Notice> list = dao.selectList(conn, pInfo);
		close(conn);
		return list;
	}

	
	
	
	
	
	
}
