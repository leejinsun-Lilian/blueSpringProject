package com.boss.blueSpring.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boss.blueSpring.board.model.vo.Board;
import com.boss.blueSpring.notice.model.service.NoticeService;
import com.boss.blueSpring.notice.model.vo.Notice;
import com.boss.blueSpring.notice.model.vo.PageInfo;

@WebServlet("/notice/*")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); // 요청이 들어오는 주소 
		String contextPath = request.getContextPath();
		String command = uri.substring((contextPath + "/notice").length());
		
		String path = null;
		RequestDispatcher view = null;
		
		String errorMsg = null;
		
		try {
			NoticeService service =  new NoticeService();
			
			// 현재 페이지를 얻어옴
			String cp = request.getParameter("cp"); // 처음은 null
			
			// 공지사항 목록 조회
			if(command.equals("/list.do")) {
				PageInfo pInfo = service.getPageInfo(cp); 
				
				
				List<Notice> list = service.selectList(pInfo);
				
				/* 썸네일 관련 부분 */
				
				
				path="/WEB-INF/views/notice/noticeList.jsp";
				
				request.setAttribute("list", list);
				request.setAttribute("pInfo", pInfo);
				
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			
			
			// 공지사항 등록 이동
			else if(command.equals("/insertForm.do")) {
				path="/WEB-INF/views/notice/noticeInsert.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			
			// 공지사항 상세보기
			else if(command.equals("/view.do")) {
				path="/WEB-INF/views/notice/noticeView.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// 공지사항  수정    화면, 수정내용 넘기는거 따로
			
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		
		
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
