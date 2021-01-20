package com.boss.blueSpring.challenge.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boss.blueSpring.challenge.model.service.ChallengeService;
import com.boss.blueSpring.challenge.model.vo.Challenge;
import com.boss.blueSpring.challenge.model.vo.PageInfo;

@WebServlet("/challenge/*")
public class ChallengeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); // 요청이 들어오는 주소 
		String contextPath = request.getContextPath();
		String command = uri.substring((contextPath + "/challenge").length());
		
		String path = null;
		RequestDispatcher view = null;
		
		String errorMsg = null;
		
		try {
			ChallengeService service = new ChallengeService();
			
			String cp = request.getParameter("cp");
			
	 
			//챌린지 목록 페이지 이동
			if(command.equals("/list.do")) {
				
				String sort = request.getParameter("sort");

				PageInfo pInfo = service.getPageInfo(cp);

//				if(request.getParameter("cn") != null) {
//				}
//				List<Challenge> list = service.selectList(pInfo, sort, cn);
				List<Challenge> list = service.selectList(pInfo, sort);
				
				
				path="/WEB-INF/views/challenge/challengeList.jsp";
				request.setAttribute("list", list);
				request.setAttribute("pInfo", pInfo);

				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				
				
			}
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
