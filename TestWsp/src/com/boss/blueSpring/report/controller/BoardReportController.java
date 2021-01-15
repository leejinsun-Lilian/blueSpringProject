package com.boss.blueSpring.report.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.boss.blueSpring.report.service.ReportService;

@WebServlet("/boardReport.do")
public class BoardReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String swalIcon = null;
		String swalTitle = null;
		String swalText = null;		
		
		String path = null;
		
		int reportCategory = Integer.parseInt(request.getParameter("reportCategory"));
		String reportContent = request.getParameter("reportContent");
		int boardNo = Integer.parseInt(request.getParameter("brdNo"));
		int memberNo = Integer.parseInt(request.getParameter("memNo"));
		
		System.out.println("=================[신고]");
		
//		
//		System.out.println(reportContent);
//		System.out.println(boardNo);
//		System.out.println(memberNo);
		
		try {			
			ReportService service = new ReportService();
			
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("reportCategory", reportCategory);
			map.put("reportContent", reportContent);
			map.put("boardNo", boardNo);
			map.put("memberNo", memberNo);
			
			System.out.println(map);
			
			int result = service.insertBoardReport(map);
			
			if(result > 0) { // DB 삽입 성공 시 result에는 삽입한 글 번호가 저장되어있다.
				int blindCheck = service.boardBlind(map);
				if(blindCheck > 0) {
					swalIcon = "success";
					swalTitle = "신고 접수가 완료되었습니다.";
					path = "WEB-INF/views/board/boardReport.jsp";
				} else {
					swalIcon = "error";
					swalTitle = "신고 접수에 성공했으나 게시글 블라인드 처리 과정에서 오류 발생.";
					path = "WEB-INF/views/board/boardReport.jsp";
				}

			} else {
				swalIcon = "error";
				swalTitle = "신고 접수 중 오류 발생.";
				path = "WEB-INF/views/board/boardReport.jsp";
			}		
			
			session.setAttribute("swalIcon", swalIcon);
			session.setAttribute("swalTitle", swalTitle);
			
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
			
//			response.sendRedirect(url);
			
		} catch (Exception e) {
			e.printStackTrace();
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("errorMsg", "검색 과정에서 오류 발생");
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}