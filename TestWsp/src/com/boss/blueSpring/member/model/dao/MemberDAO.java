package com.boss.blueSpring.member.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import com.boss.blueSpring.member.model.vo.Member;
import static com.boss.blueSpring.common.JDBCTemplate.*;

public class MemberDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rset = null;
	private Properties prop = null;
	
	public MemberDAO() {
		try {
			String filePath
			= MemberDAO.class.getResource("/com/boss/blueSpring/sql/member/member-query.xml").getPath();
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	/** 로그인용 DAO
	 * @param conn
	 * @param member
	 * @return loginMember
	 * @throws Exception
	 */
	public Member loginMember(Connection conn, Member member) throws Exception {
		Member loginMember = null;
		
		String query = prop.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			rset = pstmt.executeQuery();

			if(rset.next()) {
				loginMember = new Member(rset.getInt("MEM_NO"),
						rset.getString("MEM_ID"),
						rset.getString("MEM_NM"),
						rset.getDate("MEM_BIRTH"),
						rset.getString("MEM_GENDER").charAt(0),
						rset.getString("MEM_PHONE"),
						rset.getString("MEM_ADDR"),
						rset.getString("MEM_EMAIL"),
						rset.getDate("MEM_JOINED"),
						rset.getString("MEM_SCSN_FL").charAt(0),
						rset.getString("MEM_BLACKLIST").charAt(0),
						rset.getString("MEM_LEVEL").charAt(0),
						rset.getString("MEM_NICKNAME"));
			}
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return loginMember;
	}



	/** 아이디 중복 체크 DAO
	 * @param conn
	 * @param id
	 * @return result
	 * @throws Exception
	 */
	public int idDupCheck(Connection conn, String id) throws Exception{
		int result = 0;
		String query = prop.getProperty("idDupCheck");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

}
