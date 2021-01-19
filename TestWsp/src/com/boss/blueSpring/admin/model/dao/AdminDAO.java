package com.boss.blueSpring.admin.model.dao;

import static com.boss.blueSpring.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.boss.blueSpring.admin.model.vo.BlacklistPageInfo;
import com.boss.blueSpring.admin.model.vo.CenterPageInfo;
import com.boss.blueSpring.admin.model.vo.ChallCrtfdPageInfo;
import com.boss.blueSpring.admin.model.vo.ChallPageInfo;
import com.boss.blueSpring.admin.model.vo.MemberPageInfo;
import com.boss.blueSpring.admin.model.vo.ReportPageInfo;
import com.boss.blueSpring.board.model.dao.BoardDAO;
import com.boss.blueSpring.board.model.vo.Board;
import com.boss.blueSpring.board.model.vo.PageInfo;
import com.boss.blueSpring.center.model.vo.Center;
import com.boss.blueSpring.challenge.model.vo.Challenge;
import com.boss.blueSpring.challengecrtfd.model.vo.ChallengeCrtfd;
import com.boss.blueSpring.member.model.vo.Member;
import com.boss.blueSpring.report.model.vo.Report;

public class AdminDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rset = null;
	
	private Properties prop = null;

	
	public AdminDAO() {
		String fileName = BoardDAO.class.getResource("/com/boss/blueSpring/sql/admin/admin-query.xml").getPath();
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(fileName)); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ************************************************************************* 자유게시판
	
   /** [자유게시판] 관리 : 전체 게시글 수 반환 DAO
    * @param conn
    * @return listCount
    * @throws Exception
    */
	public int getListCount(Connection conn) throws Exception {
      int listCount = 0;
      String query = prop.getProperty("getAdminBoardListCount");
      try {
         stmt = conn.createStatement();
         rset = stmt.executeQuery(query);
         if(rset.next()) {
            listCount = rset.getInt(1);
         }
      } finally {
         close(rset);
         close(stmt);
      }
      return listCount;
   }


	/** [자유게시판] 관리 : 게시글 목록 조회 DAO
	 * @param conn
	 * @param pInfo
	 * @return aList
	 * @throws Exception
	 */
	public List<Board> selectAdminList(Connection conn, PageInfo pInfo) throws Exception {
		List<Board> aList = null;
		String query = prop.getProperty("selectAdminBoardList");
	      try {
	          int startRow = (pInfo.getCurrentPage() - 1) * pInfo.getLimit() + 1;
	          int endRow = startRow + pInfo.getLimit() -  1;
	          pstmt = conn.prepareStatement(query);
	          pstmt.setInt(1, startRow);
	          pstmt.setInt(2,  endRow);
	          rset = pstmt.executeQuery();
	          aList = new ArrayList<Board>();
	             while(rset.next()) {
	                   Board board = new Board(
	                		   			rset.getInt("BRD_NO"), 
	                		   			rset.getString("BRD_TITLE"),
	                		   			rset.getString("MEM_ID"),
	                		   			rset.getString("BRD_DEL_FL"));
	                   aList.add(board);
	                }
	       } finally {
	          close(rset);
	          close(pstmt);
	       }
		
		return aList;
		
		
	}

	
	// ************************************************************************* 신고
	
	   /** [신고] 관리 : 전체 게시글 수 반환 DAO
	    * @param conn
	    * @return listCount
	    * @throws Exception
	    */
		public int getReportListCount(Connection conn) throws Exception {
	      int listCount = 0;
	      String query = prop.getProperty("getReportListCount");
	      
	      try {
	         stmt = conn.createStatement();
	         rset = stmt.executeQuery(query);
	         if(rset.next()) {
	            listCount = rset.getInt(1);
	         }
	      } finally {
	         close(rset);
	         close(stmt);
	      }
	      return listCount;
	   }
	
	/** [신고] 관리 : 목록 조회 DAO
	 * @param conn
	 * @param rpInfo
	 * @return rList
	 * @throws Exception
	 */
	public List<Report> selectReportList(Connection conn, ReportPageInfo rpInfo) throws Exception {
		List<Report> rList = null;
		String query = prop.getProperty("selectReportList");
		try {
	          int startRow = (rpInfo.getCurrentPage() - 1) * rpInfo.getLimit() + 1;
	          int endRow = startRow + rpInfo.getLimit() -  1;
	          pstmt = conn.prepareStatement(query);
	          pstmt.setInt(1, startRow);
	          pstmt.setInt(2,  endRow);
	          rset = pstmt.executeQuery();
	          rList = new ArrayList<Report>();
	             while(rset.next()) {
	                   Report report = new Report(
	                		   				rset.getInt("REPORT_NO"),
	                		   				rset.getString("REPORT_TYPE"),
	                		   				rset.getInt("BRD_NO"),
	                		   				rset.getInt("REPORT_CATE_NO"),
	                		   				rset.getString("MEM_ID"),
	                		   				rset.getString("TARGET_ID"),
	                		   				rset.getString("MEM_BLACKLIST"));
	                   rList.add(report);
	                }
		} finally {
	        close(rset);
	        close(pstmt);
		}
		return rList;
	}
	
	
	// ************************************************************************* 센터
	
   /** [센터] 관리 : 전체 게시글 수 반환 DAO
    * @param conn
    * @return listCount
    * @throws Exception	
    */
	public int getCenterListCount(Connection conn) throws Exception {
		int listCount = 0;
		String query = prop.getProperty("getCenterListCount");
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if (rset.next()) {
				listCount = rset.getInt(1);
			}
		} finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}

	
	/** [센터] 관리 : 목록 조회 DAO
	 * @param conn
	 * @param cpInfo
	 * @return cList
	 * @throws Exception
	 */
	public List<Center> selectCenterList(Connection conn, CenterPageInfo cpInfo) throws Exception {
		List<Center> cList = null;
		String query = prop.getProperty("selectCenterList");
		try {
			int startRow = (cpInfo.getCurrentPage() - 1) * cpInfo.getLimit() + 1;
			int endRow = startRow + cpInfo.getLimit() - 1;
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			cList = new ArrayList<Center>();
			while (rset.next()) {
				Center center = new Center(
						rset.getInt("CENTER_NO"),
						rset.getString("CENTER_CLA"),
						rset.getString("CENTER_AREA1"), 
						rset.getString("CENTER_AREA2"), 
						rset.getString("CENTER_NM"),
						rset.getString("CENTER_TEL"), 
						rset.getString("CENTER_URL"), 
						rset.getString("CENTER_DEL_FL").charAt(0));
				cList.add(center);
			}
		} finally {
			close(rset);
			close(pstmt);
		}
		return cList;
	}


	// ************************************************************************* 회원정보
	
   /** [회원정보] 관리 : 전체 게시글 수 반환 DAO
    * @param conn
    * @return listCount
    * @throws Exception	
    */
	public int getMemberListCount(Connection conn) throws Exception {
		int listCount = 0;
		String query = prop.getProperty("getMemberListCount");
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if (rset.next()) {
				listCount = rset.getInt(1);
			}
		} finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}
	
	/** [회원정보] 관리 : 목록 조회 DAO
	 * @param conn
	 * @param mpInfo
	 * @return mList
	 * @throws Exception
	 */
	public List<Member> selectMemberList(Connection conn, MemberPageInfo mpInfo) throws Exception {
		List<Member> mList = null;
		String query = prop.getProperty("selectMemberList");
		try {
			int startRow = (mpInfo.getCurrentPage() - 1) * mpInfo.getLimit() + 1;
			int endRow = startRow + mpInfo.getLimit() - 1;
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			mList = new ArrayList<Member>();
			while (rset.next()) {
					Member member = new Member(
							rset.getInt("MEM_NO"),
							rset.getString("MEM_ID"),
							rset.getString("MEM_NICKNAME"), 
							rset.getString("MEM_NM"),
							rset.getDate("MEM_BIRTH"),
							rset.getString("MEM_GENDER").charAt(0), 
							rset.getString("MEM_PHONE"), 
							rset.getString("MEM_ADDR"),
							rset.getDate("MEM_JOINED"),
							rset.getString("MEM_SCSN_FL").charAt(0),
							rset.getString("MEM_BLACKLIST").charAt(0),
							rset.getString("MEM_LEVEL").charAt(0));
							mList.add(member);
					};
		} finally {
			close(rset);
			close(pstmt);
		}
		return mList;
	}

	// ************************************************************************* 블랙리스트
	
   /** [블랙리스트] 관리 : 전체 게시글 수 반환 DAO
    * @param conn
    * @return listCount
    * @throws Exception	
    */
	public int getBlackListCount(Connection conn) throws Exception {
		int listCount = 0;
		String query = prop.getProperty("getBlackListCount");
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if (rset.next()) {
				listCount = rset.getInt(1);
			}
		} finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}

	
	/** [블랙리스트] 관리 : 목록 조회 DAO
	 * @param conn
	 * @param bpInfo
	 * @return bkList
	 * @throws Exception
	 */
	public List<Member> selectBlackList(Connection conn, BlacklistPageInfo bpInfo) throws Exception {
		List<Member> bkList = null;
		String query = prop.getProperty("selectBlackList");
		try {
			int startRow = (bpInfo.getCurrentPage() - 1) * bpInfo.getLimit() + 1;
			int endRow = startRow + bpInfo.getLimit() - 1;
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			bkList = new ArrayList<Member>();
			while (rset.next()) {
					Member member = new Member(
							rset.getInt("MEM_NO"),
							rset.getString("MEM_ID"),
							rset.getString("MEM_NICKNAME"), 
							rset.getString("MEM_NM"),
							rset.getDate("MEM_BIRTH"),
							rset.getString("MEM_GENDER").charAt(0), 
							rset.getString("MEM_PHONE"),
							rset.getDate("MEM_JOINED"),
							rset.getString("MEM_SCSN_FL").charAt(0),
							rset.getString("MEM_BLACKLIST").charAt(0),
							rset.getString("MEM_LEVEL").charAt(0));
							bkList.add(member);
					};
		} finally {
			close(rset);
			close(pstmt);
		}
		return bkList;
	}
	
	// ************************************************************************* 챌린지
	
   /** [챌린지] 관리 : 전체 게시글 수 반환 DAO
    * @param conn
    * @return listCount
    * @throws Exception
    */
	public int getChallListCount(Connection conn) throws Exception {
		int listCount = 0;
		String query = prop.getProperty("getChallListCount");
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if (rset.next()) {
				listCount = rset.getInt(1);
			}
		} finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}
	
	/** [챌린지] 관리 : 목록 조회 DAO
	 * @param conn
	 * @param chpInfo
	 * @return chList
	 * @throws Exception
	 */
	public List<Challenge> selectChallList(Connection conn, ChallPageInfo chpInfo) throws Exception {
		List<Challenge> chList = null;
		String query = prop.getProperty("selectChallList");
		try {
			int startRow = (chpInfo.getCurrentPage() - 1) * chpInfo.getLimit() + 1;
			int endRow = startRow + chpInfo.getLimit() - 1;
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			chList = new ArrayList<Challenge>();
			while (rset.next()) {
				Challenge challenge = new Challenge(
							rset.getInt("CHLNG_NO"),
							rset.getString("CHLNG_TITLE"),
							rset.getString("MEM_ID"), 
							rset.getString("CHLNG_FL").charAt(0));
							chList.add(challenge);
					};
		} finally {
			close(rset);
			close(pstmt);
		}
		return chList;
	}

	// ************************************************************************* 챌린지 인증게시판
	
   /** [챌린지] 관리 : 전체 게시글 수 반환 DAO
    * @param conn
    * @return listCount
    * @throws Exception
    */
	public int getChallCrtfdListCount(Connection conn) throws Exception {
		int listCount = 0;
		String query = prop.getProperty("getChallCrtfdListCount");
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if (rset.next()) {
				listCount = rset.getInt(1);
			}
		} finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}

	
	/** [챌린지 인증게시판] 관리 : 목록 조회 DAO
	 * @param conn
	 * @param crtpInfo
	 * @return crtList
	 * @throws Exception
	 */
	public List<ChallengeCrtfd> selectChallCrtfdList(Connection conn, ChallCrtfdPageInfo crtpInfo) throws Exception {
		List<ChallengeCrtfd> crtList = null;
		String query = prop.getProperty("selectChallCrtfdList");
		try {
			int startRow = (crtpInfo.getCurrentPage() - 1) * crtpInfo.getLimit() + 1;
			int endRow = startRow + crtpInfo.getLimit() - 1;
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			crtList = new ArrayList<ChallengeCrtfd>();
			while (rset.next()) {
				ChallengeCrtfd challengeCrtfd = new ChallengeCrtfd(
							rset.getInt("CHLNG_NO"),
							rset.getInt("CHLNG_BRD_NO"),
							rset.getString("MEM_ID"), 
							rset.getString("CHLNG_BRD_DEL_FL").charAt(0));
							crtList.add(challengeCrtfd);
					};
		} finally {
			close(rset);
			close(pstmt);
		}
		return crtList;
	}


	
	
	
	
}
