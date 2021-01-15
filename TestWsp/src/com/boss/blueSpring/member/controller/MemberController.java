package com.boss.blueSpring.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.boss.blueSpring.member.model.vo.Member;
import com.sun.corba.se.spi.protocol.RequestDispatcherRegistry;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); // 요청이 들어오는 주소 
		String contextPath = request.getContextPath();
		String command = uri.substring((contextPath + "/member").length());
		
		String path = null;
		RequestDispatcher view = null;
		
		String errorMsg = null;
		
		String swalIcon = null;
		String swalTitle = null;
		String swalText = null;
		
		String memberId = request.getParameter("id_input");
		String memberPwd = request.getParameter("pw_input");
		String idSave = request.getParameter("id_chk");
		
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPwd(memberPwd);
		try {
			request.setCharacterEncoding("UTF-8");
			
			
			// 로그인 Controller 
			if(command.equals("/loginForm.do")) {
				path="/WEB-INF/views/member/loginForm.jsp";
				
				//Member loginMember = new MemberService().loginMember(member);
				
				
				

				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				
				System.out.println("login : " +  memberId + " / " + memberPwd + " / " + idSave);
				//session.setAttribute("member", member);
				response.sendRedirect(request.getHeader("referer"));
				
			}
			
			// 로그인 확인 Controller
			if(command.equals("/loginAction.do")) {
				path="/WEB-INF/views/member/loginAction.jsp";
				
				
			}
			
		
			
			// 회원가입 Controller
			else if(command.equals("/signup.do")) {
				path="/WEB-INF/views/member/signUp.jsp";
				
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// 회원가입 완료 Controller
			else if(command.equals("/signupComplete.do")) {
				path="/WEB-INF/views/member/signUpComplete.jsp";
				
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			
			// 아이디 찾기 Controller
			else if(command.equals("/idFind.do")) {
				path="/WEB-INF/views/member/idFind.jsp";
				
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			
			// 아이디 찾기 완료 Controller
			else if(command.equals("/idFindComplete.do")) {
				path="/WEB-INF/views/member/idFindComplete.jsp";
				
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			
			// 비밀번호 찾기 Controller 
			else if(command.equals("/pwFind.do")) {
				path="/WEB-INF/views/member/pwFind.jsp";
				
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// 새로운 비밀번호 설정 
			else if(command.equals("/changePw.do")) {
				path="/WEB-INF/views/common/newPwForm.jsp";
				
				view = request.getRequestDispatcher(path);
				view.forward(request, response); 
			}
			
			
			// 비밀번호 변경 완료 페이지
			else if(command.equals("/changePwComplete.do")) {
				path="/WEB-INF/views/member/pwFindNewPwComplete.jsp";
				
				view = request.getRequestDispatcher(path);
				view.forward(request, response); 
			}

			
			

			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
