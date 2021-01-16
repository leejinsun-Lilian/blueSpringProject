package com.boss.blueSpring.admin.controller;

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

import com.boss.blueSpring.admin.model.service.AdminSearchService;
import com.boss.blueSpring.board.model.vo.Board;
import com.boss.blueSpring.board.model.vo.PageInfo;

@WebServlet("/adminSearch/*")
public class AdminSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = uri.substring((contextPath + "/adminSearch").length());

		String path = null;
		RequestDispatcher view = null;

		String swalIcon = null;
		String swalTitle = null;
		String swalText = null;

		String errorMsg = null;
		
		String searchKey = request.getParameter("sk");
		String searchValue = request.getParameter("sv");
		String cp = request.getParameter("cp");
		
		try {
			AdminSearchService service = new AdminSearchService();
			
			// 자유게시판 관리자 검색 Controller *************************************************
			if(command.equals("/board.do")) {
				errorMsg = "자유게시판 관리자 검색 페이지 조회 중 오류 발생.";

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("searchKey", searchKey);
			map.put("searchValue", searchValue);
			map.put("currentPage", cp);
			
			// 페이징 처리를 위한 데이터를 계산하고 저장하는 객체 PageInfo 얻어오기
			PageInfo pInfo = service.getPageInfo(map);
			
			// 검색 게시글 목록 조회
			List<Board> aList = service.searchBoardList(map, pInfo);

			// 조회된 내용과 PageInfo 객체를 request 객체에 담아서 요청 위임
			path = "/WEB-INF/views/admin/adminBoard.jsp";
			
			request.setAttribute("aList", aList);
			request.setAttribute("pInfo", pInfo);
			
			view = request.getRequestDispatcher(path);
			view.forward(request, response);
			
			}
			
			// 신고 목록 관리자 검색 Controller *************************************************
			else if(command.equals("/report.do")) {
				errorMsg = "신고 목록 관리자 검색 페이지 조회 중 오류 발생.";
				
				
				
				
				
				
			}
			
			// 챌린지 관리자 검색 Controller *************************************************
			else if(command.equals("/chall.do")) {
				errorMsg = "챌린지 관리자 검색 페이지 조회 중 오류 발생.";
				
				
				
			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", errorMsg);
			view = request.getRequestDispatcher(path);
			view.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
