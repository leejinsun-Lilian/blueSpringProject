package com.boss.blueSpring.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.boss.blueSpring.admin.model.service.AdminService;
import com.boss.blueSpring.admin.model.vo.BlacklistPageInfo;
import com.boss.blueSpring.admin.model.vo.CenterPageInfo;
import com.boss.blueSpring.admin.model.vo.ChallCrtfdPageInfo;
import com.boss.blueSpring.admin.model.vo.ChallPageInfo;
import com.boss.blueSpring.admin.model.vo.MemberPageInfo;
import com.boss.blueSpring.admin.model.vo.ReportPageInfo;
import com.boss.blueSpring.board.model.vo.Board;
import com.boss.blueSpring.board.model.vo.PageInfo;
import com.boss.blueSpring.center.model.vo.Center;
import com.boss.blueSpring.challenge.model.vo.Challenge;
import com.boss.blueSpring.challengecrtfd.model.vo.ChallengeCrtfd;
import com.boss.blueSpring.member.model.vo.Member;
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
			
			
			// 관리자 메인 페이지 Controller ***********************************************
			if (command.equals("/adminMain.do")) {
				errorMsg = "관리자 메인 페이지 조회 중 오류 발생.";

				path = "/WEB-INF/views/admin/adminMain.jsp";

				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}			
			
			// 회원 정보 조회 Controller **************************************************
			else if (command.equals("/adminMemberInfo.do")) {
				errorMsg = "회원 정보 조회 중 오류 발생.";
				
				String cp = request.getParameter("cp");
				
				MemberPageInfo mpInfo = service.MemberPageInfo(cp);
				
				List<Member> mList = service.selectMemberList(mpInfo);

				path = "/WEB-INF/views/admin/adminMemberInfo.jsp";
				
	            request.setAttribute("mList", mList);
	            request.setAttribute("mpInfo", mpInfo);

				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// 신고 목록 조회 Controller **************************************************
			else if (command.equals("/adminReport.do")) {
				errorMsg = "신고 목록 조회 중 오류 발생.";
				
				String cp = request.getParameter("cp");
				
				ReportPageInfo rpInfo = service.ReportPageInfo(cp);
				
				List<Report> rList = service.selectReportList(rpInfo);
				

				path = "/WEB-INF/views/admin/adminReport.jsp";
				
	            request.setAttribute("rList", rList);
	            request.setAttribute("rpInfo", rpInfo);

				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// 블랙리스트 조회 Controller **************************************************
			else if (command.equals("/adminBlacklistInfo.do")) {
				errorMsg = "블랙리스트 조회 중 오류 발생.";
				
				String cp = request.getParameter("cp");
				
				BlacklistPageInfo bpInfo = service.BlacklistPageInfo(cp);
				
				List<Member> bkList = service.selectBlackList(bpInfo);
				
				path = "/WEB-INF/views/admin/adminBlacklistInfo.jsp";
				
	            request.setAttribute("bkList", bkList);
	            request.setAttribute("bpInfo", bpInfo);

				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// 기관 조회 Controller **************************************************
			else if (command.equals("/adminCenterInfo.do")) {
				errorMsg = "기관 목록 조회 중 오류 발생.";
				
				String cp = request.getParameter("cp");
				
				CenterPageInfo cpInfo = service.CenterPageInfo(cp);
				
				List<Center> cList = service.selectCenterList(cpInfo);
				
				path = "/WEB-INF/views/admin/adminCenterInfo.jsp";
				
	            request.setAttribute("cList", cList);
	            request.setAttribute("cpInfo", cpInfo);

				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			
			// 자유게시판 관리 (목록 조회) Controller **************************************************
			else if (command.equals("/adminBoard.do")) {
				errorMsg = "관리자 전용 자유게시판 조회 중 오류 발생.";
				
				String cp = request.getParameter("cp");
				
	            PageInfo pInfo = service.getPageInfo(cp);
	            
	            List<Board> aList = service.selectAdminList(pInfo);
	            
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
				
				ChallPageInfo chpInfo = service.ChallPageInfo(cp);
				
				List<Challenge> chList = service.selectChallList(chpInfo);
				
				path = "/WEB-INF/views/admin/adminChall.jsp";
				
	            request.setAttribute("chList", chList);
	            request.setAttribute("chpInfo", chpInfo);
				

				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				
				
			}
			
			// 챌린지 인증게시판 조회(관리) Controller **************************************************
			else if (command.equals("/adminCrtfd.do")) {
				errorMsg = "관리자 전용 인증게시판 조회 중 오류 발생.";
				
				String cp = request.getParameter("cp");
				
				ChallCrtfdPageInfo crtpInfo = service.ChallCrtfdPageInfo(cp);
				
				List<ChallengeCrtfd> crtList = service.selectChallCrtfdList(crtpInfo);

				path = "/WEB-INF/views/admin/adminCrtfd.jsp";
				
	            request.setAttribute("crtList", crtList);
	            request.setAttribute("crtpInfo", crtpInfo);

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

