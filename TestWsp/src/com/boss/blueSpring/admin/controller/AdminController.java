package com.boss.blueSpring.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boss.blueSpring.admin.model.service.AdminService;
import com.boss.blueSpring.board.model.vo.Board;
import com.boss.blueSpring.board.model.vo.PageInfo;
import com.boss.blueSpring.challenge.model.vo.Challenge;
import com.boss.blueSpring.report.model.vo.Report;

@WebServlet("/admin/*")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = uri.substring((contextPath + "/admin").length());

		String path = null;
		RequestDispatcher view = null;

		String swalIcon = null;
		String swalTitle = null;
		String swalText = null;

		String errorMsg = null;

		try {
			AdminService service = new AdminService();
			
			
			// 관리자 메인 페이지 Controller **************************************************
			if (command.equals("/adminMain.do")) {
				errorMsg = "관리자 메인 페이지 조회 중 오류 발생.";

				path = "/WEB-INF/views/admin/adminMain.jsp";

				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}			
			
			// 회원 정보 조회 Controller **************************************************
			else if (command.equals("/adminMemberInfo.do")) {
				errorMsg = "회원 정보 조회 중 오류 발생.";

				path = "/WEB-INF/views/admin/adminMemberInfo.jsp";

				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// 신고 목록 조회 Controller **************************************************
			else if (command.equals("/adminReport.do")) {
				errorMsg = "신고 목록 조회 중 오류 발생.";
				
				String cp = request.getParameter("cp");
				
				PageInfo pInfo = service.getPageInfo(cp);
				
				List<Report> rList = service.selectReportList(pInfo);
				

				path = "/WEB-INF/views/admin/adminReport.jsp";
				
	            request.setAttribute("rList", rList);
	            request.setAttribute("pInfo", pInfo);

				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// 블랙리스트 조회 Controller **************************************************
			else if (command.equals("/adminBlacklistInfo.do")) {
				errorMsg = "블랙리스트 조회 중 오류 발생.";

				path = "/WEB-INF/views/admin/adminBlacklistInfo.jsp";

				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// 기관 조회 Controller **************************************************
			else if (command.equals("/adminCenterInfo.do")) {
				errorMsg = "기관 목록 조회 중 오류 발생.";

				path = "/WEB-INF/views/admin/adminCenterInfo.jsp";

				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// 자유게시판 관리 (목록 조회) Controller **************************************************
			else if (command.equals("/adminBoard.do")) {
				errorMsg = "관리자 전용 자유게시판 조회 중 오류 발생.";
				
				String cp = request.getParameter("cp");
				
	            // 1. 페이징 처리를 위한 값 계산 Service 호출
	            PageInfo pInfo = service.getPageInfo(cp);
	            
	            // 2. 게시글 목록 조회 비즈니스 로직 수행
	            List<Board> aList = service.selectAdminList(pInfo);
	            // pInfo에 있는 currentPage, limit를 사용해야지만
	            // 현재 페이지에 맞는 게시글 목록만 조회할 수 있음
	            
				path = "/WEB-INF/views/admin/adminBoard.jsp";
				
	            request.setAttribute("aList", aList);
	            request.setAttribute("pInfo", pInfo);

				view = request.getRequestDispatcher(path);
				view.forward(request, response);		
				
			}
			
			// 챌린지 게시판 조회(관리) Controller **************************************************
			else if (command.equals("/adminChall.do")) {
				errorMsg = "관리자 전용 챌린지 게시판 조회 중 오류 발생.";
				
				String cp = request.getParameter("cp");
				
				PageInfo pInfo = service.getPageInfo(cp);
				
				List<Challenge> acList = service.selectAdminChallList(pInfo);
				
				path = "/WEB-INF/views/admin/adminChall.jsp";
				
	            request.setAttribute("acList", acList);
	            request.setAttribute("pInfo", pInfo);

				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				
				
			}
			
			// 챌린지 인증게시판 조회(관리) Controller **************************************************
			else if (command.equals("/adminCrtfd.do")) {
				errorMsg = "관리자 전용 인증게시판 조회 중 오류 발생.";

				path = "/WEB-INF/views/admin/adminCrtfd.jsp";

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

