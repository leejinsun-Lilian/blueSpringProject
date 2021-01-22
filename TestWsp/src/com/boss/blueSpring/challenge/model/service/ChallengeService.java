package com.boss.blueSpring.challenge.model.service;

import static com.boss.blueSpring.common.JDBCTemplate.*;

import java.io.File;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.boss.blueSpring.challenge.model.dao.ChallengeDAO;
import com.boss.blueSpring.challenge.model.exception.FileInsertFailedException;
import com.boss.blueSpring.challenge.model.vo.Attachment;
import com.boss.blueSpring.challenge.model.vo.Challenge;
import com.boss.blueSpring.challenge.model.vo.PageInfo;


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
		 
		if(sort.equals("like")) {
			orderBy = " LIKE_COUNT DESC, ";
		}else {
			orderBy = "";
		}
		

		List<Challenge> list = dao.selectList(conn, pInfo, orderBy);   //, end
		
		
		close(conn);
		return list;
	}

	/** 파일 레벨이 0인 사진(대표사진)을 가져오기 위한 Service 
	 * @param challengeNo
	 * @return fmList
	 */
	public List<Attachment> selectThumbFiles(PageInfo pInfo) throws Exception{
		Connection conn = getConnection();
		
		List<Attachment> fmList = dao.selectThumbFiles(conn, pInfo);
		
		close(conn);
		
		return fmList;
	
	}

	/** 챌린지 상세조회 Service
	 * @param challengeNo
	 * @return challenge
	 * @throws Exception
	 */
	public Challenge selectChallenge(int challengeNo) throws Exception{

		Connection conn = getConnection();
		
		Challenge challenge = dao.selectChallenge(conn, challengeNo);
		
		close(conn);
		
		return challenge;
	}
//
//	/** 챌린지 좋아요 가져오기 Service
//	 * @param challengeNo
//	 * @param memberNo
//	 * @return likeInfo
//	 */
//	public Like selectLike(int challengeNo, int memberNo) throws Exception {
//		Connection conn = getConnection();
//		
//		Like likeInfo = dao.selectLike(conn, challengeNo, memberNo);
//		
//		close(conn);
//		
//		return likeInfo;
//	}
//	
//	

	/** 챌린지 등록 Service (등록 + 파일 업로드)
	 * @param map
	 * @return result
	 * @throws Exception
	 */
	public int insertChallenge(Map<String, Object> map) throws Exception{
		Connection conn = getConnection();
		int result = 0;
		//System.out.println(789);
		
		int chlngNo = dao.selectNextNo(conn);
		System.out.println(chlngNo);
		if(chlngNo > 0) {
			
			map.put("chlngNo", chlngNo);
			
			String chlngTitle = (String)map.get("chlngTitle");
			String chlngContent = (String)map.get("chlngContent");
			
			chlngTitle =  replaceParameter(chlngTitle);
			chlngContent = replaceParameter(chlngContent);
			
			chlngContent = chlngContent.replaceAll("\r\n", "<br>");
			
			map.put("chlngTitle", chlngTitle);
			map.put("chlngContent", chlngContent);
			
			try {
				
				// 4. 게시글 부분(제목, 내용, 카테고리)만 challenge 테이블에 삽입하는 DAO 호출
				result = dao.insertChallenge(conn, map);
				System.out.println("r : " + result);
				// 5. 파일 정보 부분만 ATTACHMENT 테이블에 삽입하는 DAO 호출
				List<Attachment> cList = (List<Attachment>)map.get("cList");
				
				// 게시글 부분 삽입 성공 && 파일 정보가 있을 경우
				if(result > 0 && !cList.isEmpty()) {
					
					result = 0; // result 재활용을 위해 0으로 초기화
					
					// fList의 요소를 하나씩 반복 접근하여
					//DAO 메소드를 반복 호출해 정보를 삽입함.
					for(Attachment at : cList) {          ///\사진이 4장이면 for문 4번 돌아가는거임
						
						// 파일 정보가 저장된 Attachment 객체에 
						// 해당 파일이 작성된 게시글 번호를 추가 세팅
						at.setParentChNo(chlngNo);
						
						result = dao.insertAttachment(conn, at);
						System.out.println("f : " + result);
						if(result == 0) { // 파일 정보 삽입 실패
							//break; //보류
							System.out.println("e : " + result);
							// 강제로 예외 발생
							throw new FileInsertFailedException("파일 정보 삽입 실패");
						}
					}
				}
				
			}catch (Exception e) {
				// 4,5번에 대한 추가 작업
				// 게시글 또는 파일 정보 삽입 중 에러 발생 시 
				// 서버에 저장된 파일을 삭제하는 작업이 필요.
				System.out.println("c : " + result);
				List<Attachment> cList = (List<Attachment>)map.get("cList");
				
				if(!cList.isEmpty()) {
					for(Attachment at : cList) {
						
						String filePath = at.getFilePath();
						String fileName = at.getFileName();
						
						File deleteFile = new File(filePath + fileName);
						
						if(deleteFile.exists()) {
							// 해당 경로에 해당 파일이 존재하면 
							deleteFile.delete(); //해당 파일 삭제
						}
					}
				}
				
				// 에러 페이지가 보여질 수 있도록 catch한 Exception을 Controller로 던져줌
				throw e;
			}

			// 6. 트랜잭션 처리
			if(result > 0) {
				commit(conn);
				
				// 삽입 성공 시 상세 조회 화면으로  이동해야되기 때문에 
				// 글번호를 반환할 수 있도록 result에 boardNo를 대입
				result = chlngNo;
				
			}else {
				rollback(conn);
			}
		
		}
		// 7. 커넥션 반환
		close(conn);
		
		// 8. 결과 반환
		return result;
	}
	
	
	// 크로스 사이트 스크립팅 방지 메소드
	private String replaceParameter(String param) {
		
		String result = param;    
		
		if(param != null) {   //result, param 상관없음
			result = result.replaceAll("&", "&amp;");	
			result = result.replaceAll("<", "&lt;");	
			result = result.replaceAll(">", "&gt;");
			result = result.replaceAll("\"", "&quot;");
		}
		return result;
	}

	/** 챌린지 삭제 여부 (상테 업데이트) Service
	 * @param chlngNo
	 * @return result
	 * @throws Exception
	 */
	public int updateChFl(int chlngNo) throws Exception{
		int result = 0;
		Connection conn = getConnection();
		result = dao.updateChFl(conn, chlngNo);
		
		if(result > 0) {
			commit(conn);
			
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	/** 해당 글에 포함되는 이미지들 목록 조회Service
	 * @param challengeNo
	 * @return fList
	 * @throws Exception
	 */
	public List<Attachment> selectChallengeFiles(int challengeNo) throws Exception{
		Connection conn = getConnection();
		
		List<Attachment> fList = dao.selectChallengeFiles(conn, challengeNo);
		
		close(conn);
		
		return fList;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
