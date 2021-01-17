package com.boss.blueSpring.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.MembershipService;

import com.boss.blueSpring.member.model.service.MemberService;
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
		
		MemberService mService = new MemberService();
		
		
		try {
			request.setCharacterEncoding("UTF-8");
			
			
			// ****************************************************************** 로그인 페이지를 보여주는 Controller ******************************************************************
			if(command.equals("/login.do")) {
				path="/WEB-INF/views/member/loginForm.jsp";				
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			
			// ****************************************************************** 로그인  Controller ******************************************************************
			else if(command.equals("/loginAction.do")) {
				
				
				String memberId = request.getParameter("id_input");
				String memberPwd = request.getParameter("pw_input");
				String idSave = request.getParameter("id_chk");
				
				Member member = new Member();
				member.setMemberId(memberId);
				member.setMemberPwd(memberPwd);
				
				try {
					Member loginMember = mService.loginMember(member);
					
					response.setContentType("text/html; charset=UTF-8");
					
					HttpSession session = request.getSession();
					
					
					if(loginMember != null && loginMember.getMemberBlackList() == 'N') {
						
						session.setMaxInactiveInterval(60*30);
						
						session.setAttribute("loginMember", loginMember);
						
						Cookie cookie = new Cookie("saveId", memberId);
						
						
						if(idSave != null) {
							cookie.setMaxAge(60 * 60 * 24 * 7);
						} else {
							cookie.setMaxAge(0);
						}
						
						cookie.setPath(request.getContextPath());
						
						response.addCookie(cookie);
						
						
						
						
						response.sendRedirect(request.getContextPath());
						
					} else if(loginMember.getMemberBlackList() == 'Y') {
						swalIcon = "error";
						swalTitle = "로그인 실패";
						swalText = "접근이 불가능한 계정입니다.";
						
						response.sendRedirect(request.getHeader("referer"));
					}
					
					else {
						swalIcon = "error";
						swalTitle = "로그인 실패";
						swalText = "아이디와 비밀번호를 확인해주세요.";
						
						response.sendRedirect(request.getHeader("referer"));
						 
					}
					session.setAttribute("swalIcon", swalIcon);
					session.setAttribute("swalTitle", swalTitle);
					session.setAttribute("swalText", swalText);
					
					
				} catch (Exception e) {
					e.printStackTrace();
					
					request.setAttribute("errorMsg", "로그인 과정에서 오류가 발생했습니다.");
					
					view = request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp");
					view.forward(request, response);
				}
				
			}
			
			
			else if(command.equals("/logout.do")) {
				request.getSession().invalidate();
				response.sendRedirect(request.getHeader("referer"));
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
