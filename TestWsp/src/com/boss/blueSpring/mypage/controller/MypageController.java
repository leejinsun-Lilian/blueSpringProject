package com.boss.blueSpring.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.boss.blueSpring.member.model.service.MemberService;
import com.boss.blueSpring.member.model.vo.Member;
import com.boss.blueSpring.mypage.model.service.MypageService;

@WebServlet("/mypage/*")
public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); // 요청이 들어오는 주소 
		String contextPath = request.getContextPath();
		String command = uri.substring((contextPath + "/mypage").length());
		
		String path = null;
		RequestDispatcher view = null;
		
		String errorMsg = null;
		
		String swalIcon = null;
		String swalTitle = null;
		String swalText = null;
		
		MypageService mService = new MypageService();
		
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		try {
			// mypage 메인
			if(command.equals("/main.do")) {
				path="/WEB-INF/views/mypage/myPage.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// mypage 정보수정 비밀번호 입력
			else if(command.equals("/myInfoChangePw.do")) {
				path="/WEB-INF/views/mypage/myInfoChangePw.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// mypage 정보 수정 비밀번호 확인
			else if(command.equals("/myInfoPwCheck.do")) {
				errorMsg = "비밀번호 확인 중 오류가 발생했습니다.";
				
				
				String pwd = request.getParameter("pwd");
				
				try {
					
					int result = mService.myInfoPwCheck(loginMember.getMemberNo(), pwd);

					if(result > 0) {
						
						path="/WEB-INF/views/mypage/myInfoChange.jsp";
						view = request.getRequestDispatcher(path);
						view.forward(request, response);
						
					} else {
						swalIcon = "error";
						swalTitle = "비밀번호가 일치하지 않습니다.";
						swalText ="";
						
						response.sendRedirect(request.getHeader("referer"));
					}
					session.setAttribute("swalIcon", swalIcon);
					session.setAttribute("swalTitle", swalTitle);
					session.setAttribute("swalText", swalText);
					
				}catch (Exception e) {
			         e.printStackTrace();
			         path = "/WEB-INF/views/common/errorPage.jsp";
			         request.setAttribute("errorMsg", errorMsg);
			         view = request.getRequestDispatcher(path);
			         view.forward(request, response);
				}
				
			}
			
			
			// mypage 정보수정
			else if(command.equals("/myInfoChange.do")) {
				path="/WEB-INF/views/mypage/myInfoChange.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			
			else if(command.equals("/myInfoChangeAction.do")) {
				errorMsg = "회원정보 수정 중 오류가 발생했습니다.";
				String nickname = request.getParameter("changeNickName");

				String post = request.getParameter("post");
				String address1 = request.getParameter("address1");
				String address2 = request.getParameter("address2");
				String addr = post + "," + address1 + "," + address2;
				
				String phone = request.getParameter("changeTel");
				
				Member member = new Member();
				member.setMemberNo(loginMember.getMemberNo());
				member.setMemberNickname(nickname);
				member.setMemberAddr(addr);
				member.setMemberPhone(phone);
				
				
				try {
					int result = mService.updateMember(member);
					
					if(result > 0) {
						swalIcon = "success";
						swalTitle = "수정 완료";
						swalText = "회원 정보가 수정되었습니다.";
						
						
						member.setMemberId(loginMember.getMemberId());
						member.setMemberNm(loginMember.getMemberNm());
						member.setMemberBirth(loginMember.getMemberBirth());
						member.setMemberGender(loginMember.getMemberGender());
						member.setMemberEmail(loginMember.getMemberEmail());
						member.setMemberJoined(loginMember.getMemberJoined());
						member.setMemberScsnFl(loginMember.getMemberScsnFl());
						member.setMemberBlackList(loginMember.getMemberBlackList());
						member.setMemberLevel(loginMember.getMemberLevel());
						
						session.setAttribute("loginMember", member);
					} else {
						swalIcon = "error";
						swalTitle = "수정 실패";
						swalText = "회원 정보 수정을 실패했습니다.";
					}
					
					session.setAttribute("swalIcon", swalIcon);
					session.setAttribute("swalTitle", swalTitle);
					session.setAttribute("swalText", swalText);
					
					response.sendRedirect("main.do");
					
				} catch (Exception e) {
			         e.printStackTrace();
			         path = "/WEB-INF/views/common/errorPage.jsp";
			         request.setAttribute("errorMsg", errorMsg);
			         view = request.getRequestDispatcher(path);
			         view.forward(request, response);
				}
			}
			
			
			else if(command.equals("/nicknameDubCheck.do")) {
				errorMsg = "닉네임 중복 검사 과정에서 오류가 발생했습니다.";
				
				String nickname = request.getParameter("nickname");
				
				try {
					int result = mService.nicknameDubCheck(nickname);
					
					response.getWriter().print(result);
				}catch (Exception e) {
					e.printStackTrace();
					path = "/WEB-INF/views/common/errorPage.jsp";
			        request.setAttribute("errorMsg", errorMsg);
			        view = request.getRequestDispatcher(path);
			        view.forward(request, response);
					
				}
			}
			
			
			 //mypage 비밀번호 변경 폼 
			else if(command.equals("/changePw.do")) {
				path="/WEB-INF/views/common/newPwForm.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			
			// 비밀번호 변경
			else if(command.equals("/changePwComplete.do")) {
				
				String newPw = request.getParameter("newPw1");
				
				int memNo = loginMember.getMemberNo();		
				try {
					int result = mService.changePw(newPw, memNo); 
					if(result > 0) {
						path="/WEB-INF/views/member/pwFindNewPwComplete.jsp";
						view = request.getRequestDispatcher(path);
						view.forward(request, response);
						request.getSession().invalidate();
					} else {
						swalIcon = "error";
						swalTitle = "비밀번호 변경 실패";
						swalText = "비밀번호 형식에 맞게 작성해주세요.";
						path="/WEB-INF/views/member/pwFind.jsp";
						response.sendRedirect(path);
					}
				} catch (Exception e) {
			         e.printStackTrace();
			         path = "/WEB-INF/views/common/errorPage.jsp";
			         request.setAttribute("errorMsg", errorMsg);
			         view = request.getRequestDispatcher(path);
			         view.forward(request, response);
				}
				
			}
			
			// 작성한 게시글 조회
			else if(command.equals("/myBoardList.do")) {
				path="/WEB-INF/views/mypage/myBoardList.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// 작성한 댓글 조회
			else if(command.equals("/myReplyList.do")) {
				path="/WEB-INF/views/mypage/myReplyList.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// 참여중인 챌린지 조회
			else if(command.equals("/progressChallenge.do")) {
				path="/WEB-INF/views/mypage/progressChallenge.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// 역대 챌린지 조회
			else if(command.equals("/allTimeChallenge.do")) {
				path="/WEB-INF/views/mypage/allTimeChallenge.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			
			// 인증 게시글 조회
			else if(command.equals("/challengeCrtfd.do")) {
				path="/WEB-INF/views/mypage/challengeCrtfdList.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			
			// 회원 탈퇴
			else if(command.equals("/deleteAccount.do")) {
				path="/WEB-INF/views/mypage/deleteAccount.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			
			
			
			
			// 회원 탈퇴 완료 
			else if(command.equals("/deleteAccountComplete.do")) {
				errorMsg = "회원탈퇴 도중 오류가 발생했습니다.";
				String pwd = request.getParameter("deletePwd");
				
				int memNo = loginMember.getMemberNo();
				String url = null;
				try {
					int result = mService.updateStatus(pwd, memNo);
					
					if(result > 0) {
						
						session.invalidate();
						session = request.getSession();
						path="/WEB-INF/views/mypage/deleteAccountComplete.jsp";
						view = request.getRequestDispatcher(path);
				        view.forward(request, response);
					}else if(result == 0) {
						swalIcon = "error";
			            swalTitle = "회원 탈퇴에 실패했습니다.";
			            
			            url = "deleteAccount.do";
			            response.sendRedirect(url);
					}else {
			            swalIcon = "warning";
			            swalTitle = "현재 비밀번호가 일치하지 않습니다.";
			            
			            url = "deleteAccount.do";
			            response.sendRedirect(url);
					}
					
			         session.setAttribute("swalIcon", swalIcon);
			         session.setAttribute("swalTitle", swalTitle);

					
				} catch (Exception e) {
			         e.printStackTrace();
			         path = "/WEB-INF/views/common/errorPage.jsp";
			         request.setAttribute("errorMsg", errorMsg);
			         view = request.getRequestDispatcher(path);
			         view.forward(request, response);
				}
				
				
	
			}
			
		}catch (Exception e) {
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
