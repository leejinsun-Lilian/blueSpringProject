package com.boss.blueSpring.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boss.blueSpring.board.model.service.BoardService;
import com.boss.blueSpring.board.model.vo.Board;
import com.boss.blueSpring.board.model.vo.PageInfo;
import com.boss.blueSpring.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); // 			/wsp/board/list.do
		String contextPath = request.getContextPath(); //   /wsp
		String command = uri.substring( (contextPath + "/board").length()); // /wsp/board를 잘라내는 구문
		
		String path = null;
		RequestDispatcher view = null;
		
		String swalIcon = null;
		String swalTitle = null;
		String swalText = null;		
		
		String errorMsg = null;
		
		try {
			BoardService service = new BoardService();
			
			String cp = request.getParameter("cp");
			
			// ===== 게시글 목록 조회 Controller =====
			if(command.equals("/list.do")) {
				errorMsg = "게시판 목록 조회 과정에서 오류 발생";
				
				PageInfo pInfo = service.getPageInfo(cp);
				String cn = getInitParameter("cn");
				
				List<Board> bList = service.selectBoardList(pInfo, cn);
				
				
				
				// 나중에 파일 작성할 곳
				
				//
				
				path = "/WEB-INF/views/board/boardMain.jsp";
				
				request.setAttribute("pInfo", pInfo);
				request.setAttribute("bList", bList);
				
				view = request.getRequestDispatcher(path);
				view.forward(request, response);				
			}
			
			// ===== 게시글 상세 조회 Controller =====
			else if(command.equals("/view.do")) {
				errorMsg = "게시글 상세 조회 과정에서 오류 발생.";
				
				int boardNo = Integer.parseInt(request.getParameter("no"));
				
				Board board = service.selectBoard(boardNo);
				
				if(board != null) {
					// 첨부파일 조회 추가 작업 필요
					
					//
					
					path = "/WEB-INF/views/board/boardView.jsp";
					request.setAttribute("board", board);
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
					
				} else { // 상세조회 실패
					request.getSession().setAttribute("swalIcon", "error");
					request.getSession().setAttribute("swalTitle", "게시글 상세 조회 실패");
					response.sendRedirect("list.do?cp=1");
				}				
			}
			
			// ===== 게시글 등록 화면 이동 Controller =====
			else if(command.equals("/boardWriteForm.do")) {
				errorMsg = "게시글 등록 화면으로 전화하는 과정에서 오류 발생";
				
				path = "/WEB-INF/views/board/boardWrite.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// ===== 게시글 등록 Controller =====
			else if(command.equals("/write.do")) {
				errorMsg = "게시글 삽입 과정에서 오류 발생";
				
				// 전송 파일 용량 지정 (byte단위) 
				int maxSize = 20 * 1024 * 1024; // 20MB == 20 * 1024KB == 20 * 1024 * 1024
				
				String root = request.getSession().getServletContext().getRealPath("/");
				String filePath = root + "resources/img/";
				
				// 파일관련 작성할 곳
				MultipartRequest multiRequest = new MultipartRequest(request, filePath, maxSize, "UTF-8", new MyFileRenamePolicy());
				//
				
				// 파일 외 
				// 폼 태그에서 enctype="multipart/form-data"을 작성해서 일반적인 request로는 값을 받아올 수 없다.
				String boardTitle = multiRequest.getParameter("b-title");
				String boardContent = multiRequest.getParameter("b-content");
				int categoryCode = Integer.parseInt(multiRequest.getParameter("b-category"));
				
				// 세션에서 로그인한 회원의 번호 얻어오기
//				Member loginMember = (Member)request.getSession().getAttribute("loginMember");
//				int boardWriter = loginMember.getMemberNo();
				
				Map<String, Object> map = new HashMap<String, Object>();
//				map.put("fList", fList);
				map.put("boardTitle", boardTitle);
				map.put("boardContent", boardContent);
				map.put("categoryCode", categoryCode);
//				map.put("boardWriter", boardWriter);
				
				int result = service.insertBoard(map);
				
				if(result > 0) { // DB 삽입 성공 시 result에는 삽입한 글 번호가 저장되어있다.
					swalIcon = "success";
					swalTitle = "게시글 등록 성공";
					path = "view.do?cp=1&no=" + result;
//					System.out.println(result);
				} else {
					swalIcon = "error";
					swalTitle = "게시글 등록 실패";
					path = "list.do";
//					System.out.println(2);
				}
				
				request.getSession().setAttribute("swalIcon", swalIcon);
				request.getSession().setAttribute("swalTitle", swalTitle);
				response.sendRedirect(path);
				
			}
			
			// ===== 게시글  수정 화면 전환 Controller =====
			else if(command.equals("/updateBoardForm.do")) {
				errorMsg ="게시글 수정 화면으로 전환하는 과정에서 오류 발생";
				
				int boardNo = Integer.parseInt(request.getParameter("no"));
				
				Board board = service.updateBoardForm(boardNo);
				
				// 업데이트 화면 출력용 게시글 조회가 성공한 경우 
				if(board != null) {
					// 해당 게시글에 작성된 이미지(파일) 목록 정보 조회 
					// List<Attachment> fList = service.selectBoardFiles(boardNo);
					
//					if(!fList.isEmpty()) {
//						request.setAttribute("fList", fList);
//					}
					
					request.setAttribute("board", board);
					path = "/WEB-INF/views/board/boardUpdate.jsp";
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
				} else {
					request.getSession().setAttribute("swalIcon", "error");
					request.getSession().setAttribute("swalTitle", "게시글 수정 화면 전환 실패");
					response.sendRedirect(request.getHeader("referer"));
					
				}	
			}
			
			// ===== 게시글  수정 Controller =====
			else if(command.equals("/update.do")) {
				errorMsg = "게시글 수정 과정에서 오류 발생";
				
				int maxSize = 20 * 1024 * 1024;
				String root = request.getSession().getServletContext().getRealPath("/");
				String filePath = root + "resources/img/";
				
				MultipartRequest mRequest = new MultipartRequest(request, filePath, maxSize, "UTF-8", new MyFileRenamePolicy());
				
				String boardTitle = mRequest.getParameter("b-title");
				String boardContent = mRequest.getParameter("b-content");
				int categoryCode = Integer.parseInt(mRequest.getParameter("b-category"));
				int boardNo = Integer.parseInt(mRequest.getParameter("no"));
				
//				System.out.println(Integer.parseInt(mRequest.getParameter("no")));
				
				// 세션에서 로그인한 회원의 번호 얻어오기
//				Member loginMember = (Member)request.getSession().getAttribute("loginMember");
//				int boardWriter = loginMember.getMemberNo();
				
				Map<String, Object> map = new HashMap<String, Object>();
//				map.put("fList", fList);
				map.put("boardTitle", boardTitle);
				map.put("boardContent", boardContent);
				map.put("categoryCode", categoryCode);
				map.put("boardNo", boardNo);
//				map.put("boardWriter", boardWriter);
				
				int result = service.updateBoard(map);
				
				path = "view.do?cp=" + cp + "&no=" + boardNo;
				
			 	String sk = mRequest.getParameter("sk");
			 	String sv = mRequest.getParameter("sv");
			 	
			 	if(sk != null && sv != null) {
			 		path += "&sk=" + sk + "&sv=" + sv;
			 	}
				
				if(result > 0) { // DB 삽입 성공 시 result에는 삽입한 글 번호가 저장되어있다.
					swalIcon = "success";
					swalTitle = "게시글 등록 성공";
				} else {
					swalIcon = "error";
					swalTitle = "게시글 등록 실패";
				}
				
				request.getSession().setAttribute("swalIcon", swalIcon);
				request.getSession().setAttribute("swalTitle", swalTitle);
				response.sendRedirect(path);			
			}
			
			// ===== 게시글 삭제 Controller =====
			else if(command.equals("/deleteBoard.do")) {
				errorMsg = "게시글 삭제 과정에서 오류 발생";
				
				int boardNo = Integer.parseInt(request.getParameter("no"));
				
				int result = service.deleteBoard(boardNo);
				
				if(result > 0) { 
					swalIcon = "success";
					swalTitle = "게시글이 삭제되었습니다.";
					path = "list.do";				
				} else { 					
					swalIcon = "error";
					swalTitle = "게시글 삭제 실패";
					path = request.getHeader("referer");
				}
				
				request.getSession().setAttribute("swalIcon", swalIcon);
				request.getSession().setAttribute("swalTitle", swalTitle);
				response.sendRedirect(path);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			path="/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("errorMsg", errorMsg);
			view = request.getRequestDispatcher(path);
			view.forward(request, response);
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}