package com.boss.blueSpring.center.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/center/*")
public class CenterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); // 			/wsp/board/list.do
		String contextPath = request.getContextPath(); //   /wsp
		String command = uri.substring( (contextPath + "/center").length()); // /wsp/board를 잘라내는 구문
		
		String path = null;
		RequestDispatcher view = null;
		
		String swalIcon = null;
		String swalTitle = null;
		String swalText = null;		
		
		String errorMsg = null;
		
		try {
			
			if(command.equals("/centerForm.do")) {
				
				path = "/WEB-INF/views/center/centerMain.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);				
			}

		} catch (Exception e) {
			e.printStackTrace();
			path="/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("errorMsg", errorMsg);
			view = request.getRequestDispatcher(path);
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
