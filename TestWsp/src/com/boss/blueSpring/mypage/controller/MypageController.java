package com.boss.blueSpring.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mypage/*")
public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); // 요청이 들어오는 주소 
		String contextPath = request.getContextPath();
		String command = uri.substring((contextPath + "/member").length());
		
		String path = null;
		RequestDispatcher view = null;
		
		String errorMsg = null;
		
		try {
			// mypage 메인
			if(command.equals("/main.do")) {
				path="/WEB-INF/views/mypage/myPage.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// mypage 정보수정 비밀번호 입력
			else if(command.equals("/myinfochangepw.do")) {
				path="/WEB-INF/views/mypage/myInfoChangePw.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// mypage 정보수정
			else if(command.equals("/myinfochange.do")) {
				path="/WEB-INF/views/mypage/myInfoChange.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// mypage 비밀번호 변경
			else if(command.equals("/pwchange.do")) {
				path="/WEB-INF/views/common/newPwForm.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// 작성한 게시글 조회
			else if(command.equals("/myboardlist.do")) {
				path="/WEB-INF/views/mypage/myBoardList.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// 작성한 댓글 조회
			else if(command.equals("/myreplylist.do")) {
				path="/WEB-INF/views/mypage/myReplyList.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// 참여중인 챌린지 조회
			else if(command.equals("/progresschallenge.do")) {
				path="/WEB-INF/views/mypage/progressChallenge.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// 역대 챌린지 조회
			else if(command.equals("/alltimechallenge.do")) {
				path="/WEB-INF/views/mypage/allTimeChallenge.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
		}catch (Exception e) {
			
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
