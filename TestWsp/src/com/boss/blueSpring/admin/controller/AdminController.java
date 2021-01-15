package com.boss.blueSpring.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/*")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI(); // 요청 들어오는 주소 /travel/
		String contextPath = request.getContextPath();
		String command = uri.substring((contextPath + "/admin").length());

		// 컨트롤러 내에서 공용으로 사용할 변수 미리 선언
		String path = null; // forward 또는 redirect 경로를 저장할 변수
		RequestDispatcher view = null; // 요청 위임 객체

		String swalIcon = null; // sweet alert로 메세지 전달하는 용도
		String swalTitle = null;
		String swalText = null;

		String errorMsg = null; // 에러 메세지 전달용 변수

		try {
//			NoticeService service = new NoticeService();
			
			// 관리자 메인 페이지 Controller **************************************************
			if (command.equals("/adminMain.do")) {
				errorMsg = "관리자 메인 페이지 조회 중 오류 발생.";

				// 요청을 위임할 경로 jsp 경로 지정
				path = "/WEB-INF/views/admin/adminMain.jsp";

				// 요청 위임 객체 생성 후 위임 진행
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}			
			
			// 회원 정보 조회 Controller **************************************************
			else if (command.equals("/adminMemberInfo.do")) {
				errorMsg = "회원 정보 조회 중 오류 발생.";

				// 요청을 위임할 경로 jsp 경로 지정
				path = "/WEB-INF/views/admin/adminMemberInfo.jsp";

				// 요청 위임 객체 생성 후 위임 진행
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// 신고 목록 조회 Controller **************************************************
			else if (command.equals("/adminReport.do")) {
				errorMsg = "신고 목록 조회 중 오류 발생.";

				// 요청을 위임할 경로 jsp 경로 지정
				path = "/WEB-INF/views/admin/adminReport.jsp";

				// 요청 위임 객체 생성 후 위임 진행
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// 블랙리스트 조회 Controller **************************************************
			else if (command.equals("/adminBlacklistInfo.do")) {
				errorMsg = "블랙리스트 조회 중 오류 발생.";

				// 요청을 위임할 경로 jsp 경로 지정
				path = "/WEB-INF/views/admin/adminBlacklistInfo.jsp";

				// 요청 위임 객체 생성 후 위임 진행
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// 기관 조회 Controller **************************************************
			else if (command.equals("/adminSenterInfo.do")) {
				errorMsg = "기관 목록 조회 중 오류 발생.";

				// 요청을 위임할 경로 jsp 경로 지정
				path = "/WEB-INF/views/admin/adminSenterInfo.jsp";

				// 요청 위임 객체 생성 후 위임 진행
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// 자유게시판 조회(관리) Controller **************************************************
			else if (command.equals("/adminBoard.do")) {
				errorMsg = "관리자 전용 자유게시판 조회 중 오류 발생.";

				// 요청을 위임할 경로 jsp 경로 지정
				path = "/WEB-INF/views/admin/adminBoard.jsp";

				// 요청 위임 객체 생성 후 위임 진행
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// 챌린지 게시판 조회(관리) Controller **************************************************
			else if (command.equals("/adminChall.do")) {
				errorMsg = "관리자 전용 챌린지 게시판 조회 중 오류 발생.";

				// 요청을 위임할 경로 jsp 경로 지정
				path = "/WEB-INF/views/admin/adminChall.jsp";

				// 요청 위임 객체 생성 후 위임 진행
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// 챌린지 인증게시판 조회(관리) Controller **************************************************
			else if (command.equals("/adminChallSub.do")) {
				errorMsg = "관리자 전용 인증게시판 조회 중 오류 발생.";

				// 요청을 위임할 경로 jsp 경로 지정
				path = "/WEB-INF/views/admin/adminChallSub.jsp";

				// 요청 위임 객체 생성 후 위임 진행
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("errorMsg", errorMsg);
			view = request.getRequestDispatcher(path);
			view.forward(request, response);
		}
	}
	
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

