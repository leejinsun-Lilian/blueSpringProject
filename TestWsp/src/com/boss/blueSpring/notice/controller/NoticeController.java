package com.boss.blueSpring.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			// 공지사항 리스트
			if(command.equals("/list.do")) {
				path="/WEB-INF/views/notice/noticeList.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// 공지사항 등록 이동
			else if(command.equals("/insert.do")) {
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
			// TODO: handle exception
		}
		
		
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
