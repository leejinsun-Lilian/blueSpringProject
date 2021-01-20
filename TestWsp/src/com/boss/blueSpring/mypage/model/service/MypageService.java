package com.boss.blueSpring.mypage.model.service;

import static com.boss.blueSpring.common.JDBCTemplate.*;

import java.sql.Connection;

import com.boss.blueSpring.member.model.dao.MemberDAO;
import com.boss.blueSpring.member.model.vo.Member;
import com.boss.blueSpring.mypage.model.dao.MypageDAO;

public class MypageService {
	
	private MypageDAO dao = new MypageDAO();

	/** 내 정보 수정 확인용 비밀번호 Service
	 * @param memberNo
	 * @param pwd
	 * @return result
	 * @throws Exception
	 */
	public int myInfoPwCheck(int memberNo, String pwd) throws Exception{
		Connection conn = getConnection();
		int result = dao.myInfoPwCheck(conn, memberNo, pwd);
		close(conn);
		return result;
	}

	/** 내 정보 수정 - 비밀번호 변경 Service
	 * @param newPw
	 * @param memNo
	 * @return result
	 * @throws Exception 
	 */
	public int changePw(String newPw, int memNo) throws Exception{
		Connection conn = getConnection();
		int result = dao.changePw(conn, newPw, memNo);
		if(result > 0) commit(conn);
		else rollback(conn);
		return result;
	}

	
	/** 내 정보 수정 Service
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(Member member) throws Exception{
		Connection conn = getConnection();
		int result = dao.updateMember(conn, member);
		if(result > 0) commit(conn);
		else rollback(conn);
		return result;
	}

	/** 닉네임 중복 체크 Service
	 * @param nickname
	 * @return result
	 * @throws Exception
	 */
	public int nicknameDubCheck(String nickname) throws Exception {
		Connection conn = getConnection();
		int result = dao.nicknameDubCheck(conn, nickname);
		close(conn);
		return result;
	}

	/** 회원 탈퇴 Service
	 * @param pwd
	 * @param memNo
	 * @return result
	 * @throws Exception
	 */
	public int updateStatus(String pwd, int memNo) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.myInfoPwCheck(conn, memNo, pwd);
		
		if(result > 0) {
			result = dao.updateStatus(conn, memNo);
			
			if(result > 0) commit(conn);
			else rollback(conn);
			} else {
				result = -1;
			}
		
		close(conn);
		return result;
	}
	

}
