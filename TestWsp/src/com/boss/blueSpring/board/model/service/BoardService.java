package com.boss.blueSpring.board.model.service;

import static com.boss.blueSpring.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.boss.blueSpring.board.model.dao.BoardDAO;
import com.boss.blueSpring.board.model.vo.Board;
import com.boss.blueSpring.board.model.vo.Like;
import com.boss.blueSpring.board.model.vo.PageInfo;

public class BoardService {
	
	private BoardDAO dao = new BoardDAO();
	
	
	/** 페이징 처리를 위한 값 계산 Service
	 * @param cp
	 * @return pInfo
	 * @throws Exception
	 */
	public PageInfo getPageInfo(String cp) throws Exception {
		Connection conn = getConnection();
		
		int currentPage = cp == null ? 1 : Integer.parseInt(cp);
		
		int listCount = dao.getListCount(conn); 
		
		close(conn);
		
		return new PageInfo(currentPage, listCount);
	}


	/** 게시글 목록 조회 Service
	 * @param pInfo
	 * @return bList
	 * @throws Exception
	 */
	public List<Board> selectBoardList(PageInfo pInfo, String cn) throws Exception {
		Connection conn = getConnection();
		
		List<Board> bList = dao.selectBoardList(conn, pInfo, cn);
		
		close(conn);
		
		return bList;
	}


	/** 게시글 상세 조회
	 * @param boardNo
	 * @return board
	 * @throws Exception
	 */
	public Board selectBoard(int boardNo) throws Exception {
		Connection conn = getConnection();
		
		Board board = dao.selectBoard(conn, boardNo);
		
		if(board != null) {
			int result = dao.increaseReadCount(conn, boardNo);
			
			if(result > 0) {
				commit(conn);
				
				board.setReadCount(board.getReadCount() + 1);
			} else {
				rollback(conn);
			}
		}
		
		close(conn);
		
		return board;
	}


	/** 게시글 등록 Service
	 * @param map
	 * @return result
	 * @throws Exception
	 */
	public int insertBoard(Map<String, Object> map) throws Exception {
		Connection conn = getConnection();
		
		int result = 0;
				
		int boardNo = dao.selectNextNo(conn);	
		
		if(boardNo > 0) {
			map.put("boardNo", boardNo);
			
			// 크로스 사이트 스크립팅 방지
			String boardTitle = (String)map.get("boardTitle");
			String boardContent = (String)map.get("boardContent");
						
			boardTitle = replaceParameter(boardTitle);
			boardContent = replaceParameter(boardContent);
			
			// 글 내용 개행문자 \r\n -> <br> 변경 처리
			boardContent = boardContent.replaceAll("\r\n", "<br>");
		
			// 처리된 내용을 다시 map에 추가
			map.put("boardTitle", boardTitle);
			map.put("boardContent", boardContent);
			
			result  = dao.insertBoard(conn, map);
			
//			try { // 파일 추가 작업 필요.
				// 4. 게시글 부분(제목, 내용, 카테고리)만 BOARD 테이블에 삽입하는 DAO 호출
				
				// 5. 파일 정보 부분만 ATTACHMENT 테이블에 삽입하는 DAO 호출
				// List<Attachment> fList = (List<Attachment>)map.get("fList");
				
				// 게시글 부분 삽입 성공 && 파일 정보가 있을 경우
				// if(result > 0 && !fList.isEmpty()) {
				
//				if(result > 0) {
//					result = 0; // result 재활용을 위해 0으로 초기화
					
					// fList의 요소를 하나씩 반복 접근하여
					// DAO 메소드를 반복 호출해 정보를 삽입함.
//					for(Attachment at : fList) {
//						
//						// 파일 정보가 저장된 Attachment 객체에 
//						// 해당 파일이 작성된 게시글 번호를 추가 세팅
//						at.setParentBoardNo(boardNo);
//						
//						result = dao.insertAttachment(conn, at);
//						
//						if(result == 0) { // 파일 정보 삽입 실패
//							//break; // 보류
//							
//							// 강제로 예외 발생
//							throw new FileInsertFailedException("파일 정보 삽입 실패");
//						}
//					}
//				}
			// end try
//			}catch(Exception e) {
//				// 4,5 번에 대한 추가 작업
//				// 게시글 또는 파일 정보 삽입 중 에러 발생 시 
//				// 서버에 저장된 파일을 삭제하는 작업이 필요.	
//				
////				List<Attachment> fList = (List<Attachment>)map.get("fList");
////				
////				if(!fList.isEmpty()) {
////					for(Attachment at : (List<Attachment>)map.get("fList")) {
////						String filePath = at.getFilePath();
////						String fileName = at.getFileName();
////						
////						File deleteFile = new File(filePath + fileName);
////						// C:\Users\kang2\5_WebServer\wsp\WebContent\resources/uploadImages\20210107103301_43006.png
////						if(deleteFile.exists()) {
////							// 해당 경로에 해당 파일이 존재하면 
////							deleteFile.delete(); // 해당 파일 삭제
////						}
////					}				
////				}
//				// 에러 페이지가 보여질 수 있도록 catch한 Exception을 Controller로 던져줌.
//				throw e;
//			}
//			
		} // end catch
		
		// 6. 트랜잭션 처리			
		if(result > 0) { 
			commit(conn);
			// 삽입 성공 시 상세 조회 화면으로 이동해야되기 때문에
			// 글번호를 반환할 수 있도록 result에 boardNo 대입
//			result = boardNo;
			result = boardNo;
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	// 크로스 사이트 스크립팅 방지 메소드
	private String replaceParameter(String param) {
		String result = param;
		if(param != null) {
			result = result.replaceAll("&", "&amp;");
			result = result.replaceAll("<", "&lt;");
			result = result.replaceAll(">", "&gt;");
			result = result.replaceAll("\"", "&quot;");
		}
		
		return result;
		
	}


	/** 게시글 수정 화면으로 전환하는 Service
	 * @param boardNo
	 * @return board
	 * @throws Exception
	 */
	public Board updateBoardForm(int boardNo) throws Exception {
		Connection conn = getConnection();
		
		Board board = dao.selectBoard(conn, boardNo);
		
		board.setBoardContent(board.getBoardContent().replaceAll("<br>", "\r\n"));
		
		close(conn);
		
		return board;
	}


	/** 게시글 수정 Service
	 * @param map
	 * @return result
	 * @throws Exception
	 */
	public int updateBoard(Map<String, Object> map) throws Exception {
		Connection conn = getConnection();
		
		int result = 0; // service 수행 결과 저장 변수
		// List<Attachment> deleteFiles = null; // 삭제할 파일 정보 저장 변수 선언
		
		// 1. 글 제목/내용 크로스 사이트 스크립팅 방지 처리
		String boardTitle = (String)map.get("boardTitle");
		String boardContent = (String)map.get("boardContent");
		
		boardTitle = replaceParameter(boardTitle);
		boardContent = replaceParameter(boardContent);
		
		// 2. 글 내용 개행문자 \r\n -> <br> 변경 처리
		boardContent = boardContent.replaceAll("\r\n", "<br>");
	
		// 처리된 내용을 다시 map에 추가
		map.put("boardTitle", boardTitle);
		map.put("boardContent", boardContent);
		
		// try {
			// 3. 게시글 부분 수정 DAO 호출
			result = dao.updateBoard(conn, map);
			
			// 4. 게시글 수정이 성공하고 fList가 비어있지 않으면 
			//	    파일 정보 수정 DAO 호출
			
			// 수정 화면에서 새로운 이미지가 업로드된 파일 정보만을 담고 있는 List
			// List<Attachment> newFileList = (List<Attachment>)map.get("fList");
			
			// if(result > 0 && !newFileList.isEmpty()) {
				// DB에서 해당 게시글의 수정 전 파일 목록을 조회함
			// 	List<Attachment> oldFileList = dao.selectBoardFiles(conn, (int)map.get("boardNo"));
				
				// newFileList -> 수정된썸네일(lv.0)				
				// oldFileList -> 썸네일(lv.0), 이미지1(lv.1), 이미지2(lv.2)
			
				// 기존 썸네일(lv.0) -> 수정된썸네일(lv.0)로 변경됨
				// --> DB에서 기존 썸네일의 데이터를 수정된 썸네일로 변경
				//	 --> DB에서 기존 썸네일 정보가 사라짐.
				
			//	result = 0; // result 재활용
			//	deleteFiles = new ArrayList<Attachment>();
				
				// 새로운 이미지 정보 반복 접근
			//	for(Attachment newFile : newFileList) {
					
					// flag가 false인 경우 : 새 이미지와 기존 이미지의 파일 레벨이 중복되는 경우 -> update
					// flag가 true인 경우 : 새 이미지와 기존 이미지의 파일 레벨이 중복되지 않는 경우 -> insert
			//		boolean flag = true;
					
					// 기존 이미지 정보 반복 접근
			//		for(Attachment oldFile : oldFileList) {
						// 새로운 이미지와 기존 이미지의 파일 레벨이 동일한 파일이 있다면
			//			if(newFile.getFileLevel() == oldFile.getFileLevel()) {
							// 기존 파일을 삭제 List에 추가
			//				deleteFiles.add(oldFile);
							
							// 새 이미지 정보에 이전 파일 번호를 추가 -> 파일 번호를 이용한 수정 진행
			//				newFile.setFileNo(oldFile.getFileNo());
							
			//				flag = false;
							
			//				break;
			//			}
			//		}
					
					// flag 값에 따라 insert 또는 update
			//		if(flag) {
			//			result = dao.insertAttachment(conn, newFile);
			//		} else {
			//			result = dao.updateAttachment(conn, newFile);
			//		}
					
					// 파일 정보 삽입 또는 수정 중 실패 시
			//		if(result == 0) {
						// 강제로 사용자 정의 예외 발생
			//			throw new FileInsertFailedException("파일 정보 삽입 실패");
			//		}
			//	}
				
//			}
			
//		} catch (Exception e) {
//			List<Attachment> fList = (List<Attachment>)map.get("fList");
//			
//			if(!fList.isEmpty()) {
//				for(Attachment at : fList) {
//					String filePath = at.getFilePath();
//					String fileName = at.getFileName();
//					
//					File deleteFile = new File(filePath + fileName);
//					// C:\Users\kang2\5_WebServer\wsp\WebContent\resources/uploadImages\20210107103301_43006.png
//					if(deleteFile.exists()) {
//						// 해당 경로에 해당 파일이 존재하면 
//						deleteFile.delete(); // 해당 파일 삭제
//					}
//				}				
//			}
//			// 에러 페이지가 보여질 수 있도록 catch한 Exception을 Controller로 던져줌.
//			throw e;
//		}
		
		// 5. 트랜잭션 처리 및 삭제 목록에 있는 파일 삭제
		if(result > 0) {
			commit(conn);
			// DB 정보와 맞지 않는 파일 (deleteFiles) 삭제 진행
//			if(deleteFiles != null) {
//				for(Attachment at : deleteFiles) {
//					String filePath = at.getFilePath();
//					String fileName = at.getFileName();
//					
//					File deleteFile = new File(filePath + fileName);
//					
//					if(deleteFile.exists()) {
//						deleteFile.delete();
//					}
//				}				
//			}
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}


	/** 게시글 삭제 DAO
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteBoard(int boardNo) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.deleteBoard(conn, boardNo);
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		return result;
	}


	/** 좋아요 Service
	 * @param boardNo
	 * @param memberNo
	 * @param likeCount 
	 * @throws Exception
	 */
	public int boardLike(int boardNo, int memberNo) throws Exception {
		Connection conn = getConnection();
		
		int like = 0;
		int result = 0;
		
		try{
			result = dao.insertLikes(conn, boardNo, memberNo);
			like = 1;
		}catch(Exception e){
			result = dao.deleteLikes(conn, boardNo, memberNo);
			like = 0;
		}
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return like;
	}


	/** 좋아요 목록 얻어오기
	 * @param memberNo 
	 * @param boardNo 
	 * @param memberNo 
	 * @return likeList
	 * @throws Exception
	 */
	public Like selectLike(int boardNo, int memberNo) throws Exception {
		Connection conn = getConnection();
		
		Like likeInfo = dao.selectLike(conn, boardNo, memberNo);
		
		close(conn);
		
		return likeInfo;
	}


	
}
