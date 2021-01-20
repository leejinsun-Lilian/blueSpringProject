package com.boss.blueSpring.main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boss.blueSpring.board.model.vo.Board;
import com.boss.blueSpring.challenge.model.vo.Challenge;
import com.boss.blueSpring.challengecrtfd.model.vo.ChallengeCrtfd;
import com.boss.blueSpring.main.model.service.MainService;
import com.boss.blueSpring.notice.model.vo.Notice;

@WebServlet("/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI(); // 요청 들어오는 주소 /travel/
		String contextPath = request.getContextPath();
		String command = uri.substring((contextPath + "/main").length());

		// 컨트롤러 내에서 공용으로 사용할 변수 미리 선언
		String path = null; // forward 또는 redirect 경로를 저장할 변수
		RequestDispatcher view = null; // 요청 위임 객체

		String swalIcon = null; // sweet alert로 메세지 전달하는 용도
		String swalTitle = null;
		String swalText = null;

		String errorMsg = null; // 에러 메세지 전달용 변수

		try {
			MainService service = new MainService();
			
			// 메인 공지사항(정부정책) 조회 Controller ****************************************
			errorMsg = "메인 공지사항 페이지 조회 중 오류 발생.";
			
			List<Notice> nList = service.selectMainNotice();
			List<Board> bList = service.selectMainBoard();
			List<Challenge> cList = service.selectMainChallenge();
			List<ChallengeCrtfd> crtList = service.selectMainChallengeCrtfd();
			
			request.setAttribute("nList", nList);
			request.setAttribute("bList", bList);
			request.setAttribute("cList", cList);
			request.setAttribute("crtList", crtList);
			
			view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
			
			
			// 메인 검색 페이지 Controller **************************************************
			/*else if (command.equals("/searchPage.do")) {
				errorMsg = "검색 페이지 조회 중 오류 발생.";

				path = "/WEB-INF/views/main/mainSearchPage.jsp";

				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}*/
			
			
			
			
			
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
