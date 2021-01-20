package com.boss.blueSpring.main.model.service;

import static com.boss.blueSpring.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.boss.blueSpring.board.model.vo.Board;
import com.boss.blueSpring.challenge.model.vo.Challenge;
import com.boss.blueSpring.challengecrtfd.model.vo.ChallengeCrtfd;
import com.boss.blueSpring.main.model.dao.MainDAO;
import com.boss.blueSpring.notice.model.vo.Notice;

public class MainService {
	
	private MainDAO dao = new MainDAO();
	

	/** [메인] 공지사항 조회 Service
	 * @return nList
	 * @throws Exception
	 */
	public List<Notice> selectMainNotice() throws Exception {
		Connection conn = getConnection();
		List<Notice> nList = dao.selectMainNotice(conn);
		close(conn);
		return nList;
	}


	public List<Board> selectMainBoard()  throws Exception{
		Connection conn = getConnection();
		List<Board> bList = dao.selectMainBoard(conn);
		close(conn);
		return bList;
	}
	
	public List<Challenge> selectMainChallenge()  throws Exception{
		Connection conn = getConnection();
		List<Challenge> cList = dao.selectMainChallenge(conn);
		close(conn);
		return cList;
	}
	
	public List<ChallengeCrtfd> selectMainChallengeCrtfd()  throws Exception{
		Connection conn = getConnection();
		List<ChallengeCrtfd> crtList = dao.selectMainChallengeCrtfd(conn);
		close(conn);
		return crtList;
	}

	
	
	
	
}
