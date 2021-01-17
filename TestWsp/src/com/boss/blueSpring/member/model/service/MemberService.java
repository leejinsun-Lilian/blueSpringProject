package com.boss.blueSpring.member.model.service;

import com.boss.blueSpring.member.model.dao.MemberDAO;
import com.boss.blueSpring.member.model.vo.Member;

import java.sql.Connection;

import static com.boss.blueSpring.common.JDBCTemplate.*;

public class MemberService {
	
	private MemberDAO dao = new MemberDAO();
	
	
	

	/** 로그인 Service
	 * @param member
	 * @return loginMember
	 * @throws Exception
	 */
	public Member loginMember(Member member) throws Exception {
		Connection conn = getConnection();
		Member loginMember = dao.loginMember(conn, member);
		close(conn);
		return loginMember;
	}




	/** 아이디 중복 체크 Service
	 * @param id
	 * @return result
	 * @throws Exception
	 */
	public int idDupCheck(String id) throws Exception {
		Connection conn = getConnection();
		int result = dao.idDupCheck(conn, id);
		close(conn);
		return result;
	}
	
	
}